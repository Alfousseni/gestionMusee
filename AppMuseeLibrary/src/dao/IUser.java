/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Employe;
import models.User;

/**
 *
 * @author couly
 */
public interface IUser extends Remote {

    User addUser(User u) throws RemoteException;

    List<User> allUser() throws RemoteException;

    User getConnexion(String login) throws RemoteException;

    User getUserMail(String email) throws RemoteException;

}
