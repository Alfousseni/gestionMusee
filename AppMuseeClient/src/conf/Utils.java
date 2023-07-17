/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;


import dao.IArtiste;
import dao.IBillet;
import dao.IEmploye;
import dao.IExposition;
import dao.IOeuvre;
import dao.IOeuvreExposition;
import dao.IUser;
import dao.IVisiteur;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author couly
 */
public class Utils {
    
    
    private static IUser iUser;
    private static IArtiste iArtiste;
    private static IOeuvre iOeuvre;
    private static IExposition iExposition;
    private static IEmploye iEmploye;
    private static IBillet iBillet;
    private static IVisiteur iVisiteur;
    private static IOeuvreExposition iOeuvreExposition;

    public static final int PORT = 2000;
    private static final String USER_REMOTE = "USER_REMOTE";
    private static final String ARTISTE_REMOTE = "ARTISTE_REMOTE";
    private static final String OEUVRE_REMOTE = "OEUVRE_REMOTE";
    private static final String EXPOSITION_REMOTE = "EXPOSITION_REMOTE";
    private static final String EMPLOYE_REMOTE = "EMPLOYE_REMOTE";
    private static final String BILLET_REMOTE = "BILLET_REMOTE";
    private static final String VISITEUR_REMOTE = "VISITEUR_REMOTE";
    private static final String OEUVREEXPOSITION_REMOTE = "OEUVREEXPOSITION_REMOTE";
    



    
    
   
   

 
    
    private Utils(){
        
    }
    
    public static IUser getiUser(){
    return iUser;
    }

    public static IVisiteur getiVisiteur() {
        return iVisiteur;
    }

    public static IOeuvreExposition getiOeuvreExposition() {
        return iOeuvreExposition;
    }
    
    
    

    public static IArtiste getiArtiste() {
        return iArtiste;
    }
    
    public static IBillet getiBillet(){
        return iBillet;
    }

    public static IOeuvre getiOeuvre() {
        return iOeuvre;
    }
    
    public static IExposition getiExposition() {
        return iExposition;
    }
    
    public static IEmploye getiEmploye(){
        return iEmploye;
    }
    
    
    

   
    
    public static void init(){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",PORT);
            iUser = (IUser) registry.lookup(USER_REMOTE);
            iArtiste = (IArtiste) registry.lookup(ARTISTE_REMOTE);
            iOeuvre = (IOeuvre) registry.lookup(OEUVRE_REMOTE); 
            iExposition =(IExposition) registry.lookup(EXPOSITION_REMOTE);
            iEmploye = (IEmploye) registry.lookup(EMPLOYE_REMOTE);
            iBillet = (IBillet) registry.lookup(BILLET_REMOTE);
            iVisiteur = (IVisiteur) registry.lookup(VISITEUR_REMOTE);
            iOeuvreExposition = (IOeuvreExposition) registry.lookup(OEUVREEXPOSITION_REMOTE);
   
        } catch (NotBoundException | RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
