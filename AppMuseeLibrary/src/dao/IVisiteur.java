/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Visiteur;

/**
 *
 * @author couly
 */
public interface IVisiteur extends  Remote {
    
    Visiteur addVisiteur(Visiteur v) throws RemoteException;
    List<Visiteur> allVisiteur() throws RemoteException;
}
