/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.EntityManagerUtil;
import dao.IUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Employe;
import models.User;

/**
 *
 * @author couly
 */
public class UserService extends UnicastRemoteObject implements IUser {

    EntityManager EM;

    public UserService() throws RemoteException {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public User addUser(User u) throws RemoteException {
        EntityTransaction et = null;

        User usersaved;

        try {

            et = EM.getTransaction();
            et.begin();
            EM.persist(u);
            EM.flush();
            et.commit();
            usersaved = u;
        } catch (Exception ex) {
            if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion user " + ex.getMessage());
            throw ex;
        }

        return usersaved;
    }

    @Override
    public List<User> allUser() throws RemoteException {
        List<User> userList = null;
        try {
            userList = EM.createNamedQuery("User.findAll", User.class)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des employes : " + e.getMessage());
            throw e;
        }
        return userList;
    }

    @Override
    public User getConnexion(String login) {
        User user = null;

        try {
            user = EM.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", login)
                    .getSingleResult();
        } catch (Exception ex) {
            System.err.println("Erreur lors de la recuperation de l'utilisateur : " + ex.getMessage());
            return user;
        }
        return user;
    }

    @Override
    public User getUserMail(String email) throws RemoteException {
        User user = null;

        try {
            user = EM.createNamedQuery("User.findByEmail", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            System.err.println("Erreur lors de la recuperation de l'utilisateur : " + ex.getMessage());
            return user;
        }
        return user;
    }

    @Override
    public User updateUser(User e) throws RemoteException {
        EntityTransaction et = null;

        User userUpdate;

        try {

            et = EM.getTransaction();
            et.begin();
            userUpdate = EM.merge(e);

            EM.flush();
            et.commit();
            userUpdate = e;
        } catch (Exception ex) {
            if (et == null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de l'insertion user " + ex.getMessage());
            throw ex;
        }

        return userUpdate;
    }

    @Override
    public void deleteUser(int id) throws RemoteException {
        EntityTransaction et = null;

        try {
            et = EM.getTransaction();
            et.begin();
            User employeToDelete = EM.find(User.class, id);
            if (employeToDelete != null) {
                EM.remove(employeToDelete);
                EM.flush();
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.err.println("Erreur lors de la suppression de l'utilisateur " + ex.getMessage());
            throw new RemoteException("Erreur lors de la suppression de l'utilisateur", ex);
        }
    }
}
