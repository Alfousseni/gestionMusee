/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IBillet;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Billet;

/**
 *
 * @author couly
 */
public class BilletService extends UnicastRemoteObject implements IBillet {
     EntityManager EM;

    public BilletService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Billet addBillet(Billet b) throws RemoteException {
        EntityTransaction et = null;
       
       Billet billetsaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(b);
            EM.flush();
            et.commit();
            billetsaved = b;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion du billet  " + ex.getMessage());
            throw ex;
        }
        
        return billetsaved;
    }

    @Override
    public List<Billet> allBillet() throws RemoteException {
          List<Billet> billetList = null;
        try {
            billetList = EM.createNamedQuery("Billet.findAll", Billet.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des billet : " + e.getMessage());
            throw e;
        }
        return billetList;
    }
    
}
