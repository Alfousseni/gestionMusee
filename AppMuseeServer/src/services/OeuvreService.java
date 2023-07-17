/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IOeuvre;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Oeuvre;

/**
 *
 * @author couly
 */
public class OeuvreService extends UnicastRemoteObject implements IOeuvre {
    
        EntityManager EM;

    public OeuvreService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Oeuvre addOeuvre(Oeuvre o) throws RemoteException {
        EntityTransaction et = null;
       
       Oeuvre oeuvresaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(o);
            EM.flush();
            et.commit();
            oeuvresaved = o;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion user " + ex.getMessage());
            throw ex;
        }
        
        return oeuvresaved;
    }

    @Override
    public List<Oeuvre> allOeuvre() throws RemoteException {
  List<Oeuvre> oeuvreList = null;
        try {
            oeuvreList = EM.createNamedQuery("Oeuvre.findAll", Oeuvre.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des oeuvre : " + e.getMessage());
            throw e;
        }
        return oeuvreList;    }

    @Override
    public Oeuvre findOeuvreByname(String o) throws RemoteException {
         Oeuvre ex;
        try {
            // Récupération de la chambre par son nom depuis la base de données
            ex = EM.createNamedQuery("Oeuvre.findByNom", Oeuvre.class)
                    .setParameter("nom", o)
                    .getSingleResult();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des exposition : " + e.getMessage());
            throw e;
    }
        return ex;
    }
    
}
