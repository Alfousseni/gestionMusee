/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Exposition;

/**
 *
 * @author couly
 */
public interface IExposition extends Remote {
    Exposition addExposition(Exposition e) throws RemoteException;
    Exposition findExpositionByname(String name) throws RemoteException;
    List<Exposition> allExposition() throws RemoteException;
    List<Exposition> allExpositionDispo() throws RemoteException;

    
}
