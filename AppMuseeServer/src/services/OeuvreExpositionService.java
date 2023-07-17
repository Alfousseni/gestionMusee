/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IOeuvreExposition;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.OeuvresExposition;

/**
 *
 * @author couly
 */
public class OeuvreExpositionService extends UnicastRemoteObject implements IOeuvreExposition {
 EntityManager EM;

    public OeuvreExpositionService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public OeuvresExposition addOeuvreExposition(OeuvresExposition u) throws RemoteException {
         EntityTransaction et = null;
       
       OeuvresExposition oeuvreexpositionsaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(u);
            EM.flush();
            et.commit();
            oeuvreexpositionsaved = u;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion de l jointure  " + ex.getMessage());
            throw ex;
        }
        
        return oeuvreexpositionsaved;
    }

    @Override
    public List<OeuvresExposition> allOeuvreExposition() throws RemoteException {
        List<OeuvresExposition> oeuvresxpositionList = null;
        try {
            oeuvresxpositionList = EM.createNamedQuery("OeuvresExposition.findAll", OeuvresExposition.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des jointure : " + e.getMessage());
            throw e;
        }
        return oeuvresxpositionList;
    }
    
}
