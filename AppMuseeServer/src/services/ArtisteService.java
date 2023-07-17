/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IArtiste;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Artiste;

/**
 *
 * @author couly
 */
public class ArtisteService extends UnicastRemoteObject implements IArtiste {
        EntityManager EM;

    public ArtisteService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Artiste addArtiste(Artiste a) throws RemoteException {
        EntityTransaction et = null;
       
       Artiste artistesaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(a);
            EM.flush();
            et.commit();
            artistesaved = a;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion de l'artiste " + ex.getMessage());
            throw ex;
        }
        
        return artistesaved;
    }
    

    @Override
    public List<Artiste> allAtriste() throws RemoteException {
           List<Artiste> artisteList = null;
        try {
            artisteList = EM.createNamedQuery("Artiste.findAll", Artiste.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des artistes : " + e.getMessage());
            throw e;
        }
        return artisteList;
    }

    @Override
    public Artiste findByEmail(String a) throws RemoteException {
Artiste artiste = null;

        try {
            artiste = EM.createNamedQuery("Artiste.findByEmail", Artiste.class)
                    .setParameter("email", a)
                    .getSingleResult();
        } catch (Exception ex) {
            System.err.println("Erreur lors de la recuperation de l'artiste : " + ex.getMessage());
            return artiste;
        }
        return artiste;
    }    }
    
    

