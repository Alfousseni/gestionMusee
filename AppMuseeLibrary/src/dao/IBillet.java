/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Billet;

/**
 *
 * @author couly
 */
public interface IBillet extends Remote {
    Billet addBillet(Billet b) throws RemoteException;
    List<Billet> allBillet() throws RemoteException;
    
}
