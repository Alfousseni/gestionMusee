/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.OeuvresExposition;

/**
 *
 * @author couly
 */
public interface IOeuvreExposition extends Remote {
    OeuvresExposition addOeuvreExposition(OeuvresExposition u) throws RemoteException;
    List<OeuvresExposition> allOeuvreExposition() throws RemoteException;
}
