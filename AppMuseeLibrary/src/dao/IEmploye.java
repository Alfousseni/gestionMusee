/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Employe;

/**
 *
 * @author couly
 */
public interface IEmploye extends Remote {
    Employe addEmploye(Employe e) throws RemoteException;
    List<Employe> allEmploye() throws RemoteException;
    
}
