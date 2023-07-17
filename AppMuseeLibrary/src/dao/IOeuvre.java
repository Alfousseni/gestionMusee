/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Oeuvre;

/**
 *
 * @author couly
 */
public interface IOeuvre extends Remote {
    Oeuvre addOeuvre(Oeuvre o) throws RemoteException;
        Oeuvre findOeuvreByname(String o) throws RemoteException;

    List<Oeuvre> allOeuvre() throws RemoteException;
    
}
