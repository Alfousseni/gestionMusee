/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IExposition;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Employe;
import models.Exposition;
import models.Oeuvre;

/**
 *
 * @author couly
 */
public class ExpositionService extends UnicastRemoteObject implements IExposition {
         EntityManager EM;

    public ExpositionService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }


    @Override
    public Exposition addExposition(Exposition e) throws RemoteException {
          Exposition expositionsaved;
                  EntityTransaction et = null;

       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(e);
            EM.flush();
            et.commit();
            expositionsaved = e;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion de l'exposition  " + ex.getMessage());
            throw ex;
        }
        
        return expositionsaved;
    }

    @Override
    public List<Exposition> allExposition() throws RemoteException {
         List<Exposition> expositionList = null;
        try {
            expositionList = EM.createNamedQuery("Exposition.findAll", Exposition.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des exposition : " + e.getMessage());
            throw e;
        }
        return expositionList;
    }

    @Override
    public List<Exposition> allExpositionDispo() throws RemoteException {
 List<Exposition> expositionList = null;
        try {
            expositionList = EM.createNamedQuery("Exposition.expoDispo", Exposition.class)
                    .setParameter("currentDate", new Date())
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des exposition : " + e.getMessage());
            throw e;
        }
        return expositionList;    }

    @Override
    public Exposition findExpositionByname(String name) throws RemoteException {
        Exposition ex;
        try {
            // Récupération de la chambre par son nom depuis la base de données
            ex = EM.createNamedQuery("Exposition.findByNom", Exposition.class)
                    .setParameter("nom", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des exposition : " + e.getMessage());
            throw e;
    }
        return ex;
    
    }

    @Override
    public Exposition updateExposition(Exposition e) throws RemoteException {
        Exposition expositionsaved;
        EntityTransaction et = null;

        try {

            et = EM.getTransaction();
            et.begin();
            expositionsaved = EM.merge(e);

            EM.flush();
            et.commit();
            expositionsaved = e;
        } catch (Exception ex) {
            if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion de l'exposition  " + ex.getMessage());
            throw ex;
        }

        return expositionsaved;
    }

    @Override
    public void deleteExposition(int id) throws RemoteException {
           EntityTransaction et = null;

        try {
            et = EM.getTransaction();
            et.begin();
            Exposition expositionToDelete = EM.find(Exposition.class, id);
            if (expositionToDelete != null) {
                EM.remove(expositionToDelete);
                EM.flush();
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de la suppression de l'employe " + ex.getMessage());
            throw new RemoteException("Erreur lors de la suppression de l'employe", ex);
        }
    }
}
