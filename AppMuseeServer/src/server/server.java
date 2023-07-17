/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import dao.IArtiste;
import dao.IBillet;
import dao.IEmploye;
import dao.IExposition;
import dao.IOeuvre;
import dao.IOeuvreExposition;
import dao.IUser;
import dao.IVisiteur;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import services.ArtisteService;
import services.BilletService;
import services.EmployeService;
import services.OeuvreService;
import services.UserService;
import services.ExpositionService;
import services.OeuvreExpositionService;
import services.VisiteurService;

/**
 *
 * @author couly
 */
public class server {  
     private static final int PORT = 2000;
    private static final String USER_REMOTE = "USER_REMOTE";
    
    
    private static final String ARTISTE_REMOTE = "ARTISTE_REMOTE";
    private static final String EXPOSITION_REMOTE = "EXPOSITION_REMOTE";

    private static final String OEUVRE_REMOTE = "OEUVRE_REMOTE";
    private static final String EMPLOYE_REMOTE = "EMPLOYE_REMOTE";
    private static final String BILLET_REMOTE = "BILLET_REMOTE";
    private static final String VISITEUR_REMOTE = "VISITEUR_REMOTE";
        private static final String OEUVREEXPOSITION_REMOTE = "OEUVREEXPOSITION_REMOTE";

     

    public static void main(String[] args) {
        try {
            System.setSecurityManager(new SecurityManager());
            Registry registry = LocateRegistry.createRegistry(PORT);
            
            IUser iUser = new UserService();
            IArtiste iArtiste = new ArtisteService();
            IOeuvre iOeuvre = new OeuvreService();
            IExposition iExposition = new ExpositionService();
            IEmploye iEmploye = new EmployeService();
            IBillet iBillet = new BilletService();
            IVisiteur iVisiteur = new VisiteurService();
            IOeuvreExposition iOeuvreExposition = new OeuvreExpositionService();
           
            
            registry.bind(USER_REMOTE, (Remote) iUser);
            registry.bind(ARTISTE_REMOTE,(Remote) iArtiste);
            registry.bind(OEUVRE_REMOTE, (Remote) iOeuvre);
            registry.bind(EXPOSITION_REMOTE, (Remote) iExposition);
            registry.bind(EMPLOYE_REMOTE,(Remote) iEmploye);
            registry.bind(BILLET_REMOTE,(Remote) iBillet);
            registry.bind(VISITEUR_REMOTE,(Remote) iVisiteur);
            registry.bind(OEUVREEXPOSITION_REMOTE,(Remote) iOeuvreExposition);

            System.out.println("serveur lancé sur le port " + PORT);
        } catch (RemoteException | AlreadyBoundException ex) {
            System.err.println("Notre message d'erreur : " + ex.getMessage());
        }
    }
    
}
