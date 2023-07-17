/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IVisiteur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Visiteur;

/**
 *
 * @author couly
 */
public class VisiteurService extends UnicastRemoteObject implements IVisiteur {
    
       EntityManager EM;

    public VisiteurService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }


    @Override
    public Visiteur addVisiteur(Visiteur v) throws RemoteException {
EntityTransaction et = null;
       
       Visiteur visiteursaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(v);
            EM.flush();
            et.commit();
            visiteursaved = v;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion du visiteur " + ex.getMessage());
            throw ex;
        }
        
        return visiteursaved;    }

    @Override
    public List<Visiteur> allVisiteur() throws RemoteException {
          List<Visiteur> visiteurList = null;
        try {
            visiteurList = EM.createNamedQuery("Visiteur.findAll", Visiteur.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des artistes : " + e.getMessage());
            throw e;
        }
        return visiteurList;
    }
    
}
