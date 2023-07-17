/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IEmploye;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Artiste;
import models.Employe;

/**
 *
 * @author couly
 */
public class EmployeService extends UnicastRemoteObject implements IEmploye {
       EntityManager EM;

    public EmployeService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Employe addEmploye(Employe e) throws RemoteException {
         EntityTransaction et = null;
       
       Employe employesaved;
       
        try {
            
            et = EM.getTransaction();
            et.begin();
            EM.persist(e);
            EM.flush();
            et.commit();
            employesaved = e;
        } catch (Exception ex) {
             if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion de l'employe " + ex.getMessage());
            throw ex;
        }
        
        return employesaved;
    }

    @Override
    public List<Employe> allEmploye() throws RemoteException {
  List<Employe> employeList = null;
        try {
            employeList = EM.createNamedQuery("Employe.findAll", Employe.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des employe : " + e.getMessage());
            throw e;
        }
        return employeList;    }
    
}
