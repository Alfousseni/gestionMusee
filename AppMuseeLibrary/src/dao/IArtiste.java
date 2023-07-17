/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Artiste;

/**
 *
 * @author couly
 */
public interface IArtiste extends Remote {

    Artiste addArtiste(Artiste a) throws RemoteException;

    Artiste findByEmail(String a) throws RemoteException;

    List<Artiste> allAtriste() throws RemoteException;

}
