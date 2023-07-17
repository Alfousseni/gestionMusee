/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import conf.MyFonction;
import conf.Utils;
import java.awt.Color;
import java.awt.Cursor;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Artiste;
import models.Billet;
import models.Employe;
import models.Exposition;
import models.Oeuvre;
import models.OeuvresExposition;
import models.User;
import models.Visiteur;
import utils.UtilsFonction;

/**
 *
 * @author couly
 */
public class App extends javax.swing.JFrame {

    private User user;
    List<Artiste> artisteList = new ArrayList<>();
    List<Exposition> expositionList = new ArrayList<>();
    List<Exposition> expositionListD = new ArrayList<>();
    List<Billet> billetList = new ArrayList<>();
    List<Employe> employeList = new ArrayList<>();
    List<Oeuvre> oeuvreList = new ArrayList<>();
    List<Visiteur> visiteurList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<OeuvresExposition> oeuvreexpositionList = new ArrayList<>();

    /**
     * Creates new form App
     */
    public void loadExpositionD() {
        try {
            exposition_cbx.removeAllItems();

            expositionListD = Utils.getiExposition().allExpositionDispo();

            for (Exposition exposition : expositionListD) {
                exposition_cbx.addItem(exposition.getNom());

            }
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void loadExposition() {
        try {
            expositiona_cbx.removeAllItems();

            expositionList = Utils.getiExposition().allExposition();

            for (Exposition exposition : expositionList) {

                expositiona_cbx.addItem(exposition.getNom());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void loadOeuvre() {
        try {

            oeuvresa_cbx.removeAllItems();
            oeuvreList = Utils.getiOeuvre().allOeuvre();

            for (Oeuvre oeuvre : oeuvreList) {
                oeuvresa_cbx.addItem(oeuvre.getNom());

            }
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void affichageOeuvre() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");
        elementOmit.add("oeuvresExpositionList");
        elementOmit.add("expositionList");
        elementOmit.add("visiteurList");
        elementOmit.add("artisteList");
        elementOmit.add("oeuvreList");
        elementOmit.add("id");

        try {
            oeuvreList = Utils.getiOeuvre().allOeuvre();

            UtilsFonction.displayDataInTable(oeuvreList, oeuvre_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageArtiste() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");
        elementOmit.add("oeuvreList");

        try {
            artisteList = Utils.getiArtiste().allAtriste();
            UtilsFonction.displayDataInTable(artisteList, artistes_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageVisiteur() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");
        elementOmit.add("oeuvreList");
        try {
            visiteurList = Utils.getiVisiteur().allVisiteur();
            UtilsFonction.displayDataInTable(visiteurList, visiteurs_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageEmploye() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");

        try {
            employeList = Utils.getiEmploye().allEmploye();
            UtilsFonction.displayDataInTable(employeList, employe_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageExposition() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");
        elementOmit.add("billetList");
        elementOmit.add("oeuvresExpositionList");

        try {
            expositionList = Utils.getiExposition().allExposition();
            UtilsFonction.displayDataInTable(expositionList, exposition_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageTicket() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");

        try {
            billetList = Utils.getiBillet().allBillet();
            UtilsFonction.displayDataInTable(billetList, billetTableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageOeuvreExposition() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");

        try {
            oeuvreexpositionList = Utils.getiOeuvreExposition().allOeuvreExposition();
            UtilsFonction.displayDataInTable(oeuvreexpositionList, affectation_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affichageUser() {
        List<String> elementOmit = new ArrayList<>();
        elementOmit.add("id");
        elementOmit.add("oeuvresExpositionList");
        elementOmit.add("expositionList");
        elementOmit.add("visiteurList");
        elementOmit.add("artisteList");
        elementOmit.add("oeuvreList");
        elementOmit.add("id");

        try {
            userList = Utils.getiUser().allUser();
            UtilsFonction.displayDataInTable(userList, utilisateur_tableau, elementOmit);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public App(User user) {
        initComponents();
        setLocationRelativeTo(null);

        content_panel.setVisible(false);
        this.user = user;
        Utils.init();
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        usernaame_labele.setText(user.getUsername());
        if (user.getRole().equalsIgnoreCase("EMPLOYE")) {
            oeuvreh_btn.setVisible(false);
            employeh_btn.setVisible(false);
            hemploye_pn.setVisible(false);
            houeuvre_pn.setVisible(false);
        }

        montant_txt.setEnabled(false);

    }

    public App() {
        initComponents();
        content_panel.setVisible(false);
        Utils.init();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_panel = new javax.swing.JPanel();
        aacceuil_pn = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        oeuvreh_btn = new javax.swing.JLabel();
        expositionh_btn = new javax.swing.JLabel();
        employeh_btn = new javax.swing.JLabel();
        billeth_btn = new javax.swing.JLabel();
        aartisteh_btn = new javax.swing.JLabel();
        visiteurh_btn = new javax.swing.JLabel();
        content_panel = new javax.swing.JPanel();
        artiste_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        artistes_tableau = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        visiteur_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        visiteurs_tableau = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        exposition_panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        exposition_tableau = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nomExposition_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        debut_date = new com.toedter.calendar.JDateChooser();
        fin_date = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        description_txt = new javax.swing.JTextArea();
        prixVip_txt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        prix_classique_txt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        heureDebut_txt = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        heureFin_txt = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        annuleExposition_btn = new javax.swing.JLabel();
        addExposition_btn = new javax.swing.JLabel();
        aff_btn = new javax.swing.JButton();
        oeuvre_panel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        artisteNom_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        nationlite_cbx = new javax.swing.JComboBox<>();
        artistedate_txt = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        biographie_txt = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        oeuvreNom_txt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        oueuvreDescription_txt = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        dateOeuvre_txt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        prix_txt = new javax.swing.JTextField();
        artisteEmail_txt = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        annuleOeuvre_btn = new javax.swing.JLabel();
        addOeuvre_btn = new javax.swing.JLabel();
        listOeuvre_btn = new javax.swing.JButton();
        billet_panel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        clientNom_txt = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        typeBillet_cbx = new javax.swing.JComboBox<>();
        client_date = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        montant_txt = new javax.swing.JTextField();
        clientEmail_txt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        clientPrenom_txt = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        exposition_cbx = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        billetTableau = new javax.swing.JTable();
        annuleBillet_btn = new javax.swing.JLabel();
        addBillet_btn = new javax.swing.JLabel();
        employe_panel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        employeNom_txt = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        poste_txt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        employePrenom_txt = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        employe_tableau = new javax.swing.JTable();
        salaire_txt = new javax.swing.JTextField();
        tel_txt = new javax.swing.JTextField();
        adresse_txt = new javax.swing.JTextField();
        annuleEmployee_btn = new javax.swing.JLabel();
        addEmployee_btn = new javax.swing.JLabel();
        user_panel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        userName_txt = new javax.swing.JTextField();
        userRole_txt = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        userEmail_txt = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        utilisateur_tableau = new javax.swing.JTable();
        supprimerUser_btn = new javax.swing.JLabel();
        heaader = new javax.swing.JPanel();
        hclient_pn = new javax.swing.JLabel();
        huser_pn = new javax.swing.JLabel();
        hemploye_pn = new javax.swing.JLabel();
        hexposition_pn = new javax.swing.JLabel();
        hticket_pn = new javax.swing.JLabel();
        hartiste_pn = new javax.swing.JLabel();
        houeuvre_pn = new javax.swing.JLabel();
        deconnexion_pn = new javax.swing.JLabel();
        usernaame_labele = new javax.swing.JLabel();
        affectation_panel = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        affectation_tableau = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        expositiona_cbx = new javax.swing.JComboBox<>();
        oeuvresa_cbx = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        add_affectation = new javax.swing.JButton();
        listeOeuvre_paanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        oeuvre_tableau = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();

        home_panel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aacceuil_pn.setBackground(new java.awt.Color(0, 0, 0));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("BIENVENUIE SUR MUSEE_GEST");

        oeuvreh_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        oeuvreh_btn.setForeground(new java.awt.Color(255, 255, 255));
        oeuvreh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/3d-construction-abstract-composition-with-human-silhouette.png"))); // NOI18N
        oeuvreh_btn.setText("OEUVRES");
        oeuvreh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oeuvreh_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oeuvreh_btnMouseEntered(evt);
            }
        });

        expositionh_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        expositionh_btn.setForeground(new java.awt.Color(255, 255, 255));
        expositionh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/haze-digital-illustrator-workplace-1.png"))); // NOI18N
        expositionh_btn.setText("EXPOSITIONS ");
        expositionh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expositionh_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expositionh_btnMouseEntered(evt);
            }
        });

        employeh_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeh_btn.setForeground(new java.awt.Color(255, 255, 255));
        employeh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/3d-casual-life-group-of-young-people-discussing-something-while-working.png"))); // NOI18N
        employeh_btn.setText("EMPLOYE");
        employeh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeh_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeh_btnMouseEntered(evt);
            }
        });

        billeth_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        billeth_btn.setForeground(new java.awt.Color(255, 255, 255));
        billeth_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/haze-museum-building-and-exhibits-1.png"))); // NOI18N
        billeth_btn.setText("BILLETS");
        billeth_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billeth_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                billeth_btnMouseEntered(evt);
            }
        });

        aartisteh_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aartisteh_btn.setForeground(new java.awt.Color(255, 255, 255));
        aartisteh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/3d-casual-life-black-girl-painting.png"))); // NOI18N
        aartisteh_btn.setText("ARTISTES");
        aartisteh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aartisteh_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aartisteh_btnMouseEntered(evt);
            }
        });

        visiteurh_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        visiteurh_btn.setForeground(new java.awt.Color(255, 255, 255));
        visiteurh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/3d-business-young-women-students-smiling.png"))); // NOI18N
        visiteurh_btn.setText("VISITEURS");
        visiteurh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visiteurh_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visiteurh_btnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout aacceuil_pnLayout = new javax.swing.GroupLayout(aacceuil_pn);
        aacceuil_pn.setLayout(aacceuil_pnLayout);
        aacceuil_pnLayout.setHorizontalGroup(
            aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aacceuil_pnLayout.createSequentialGroup()
                .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aacceuil_pnLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(aartisteh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aacceuil_pnLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(oeuvreh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aacceuil_pnLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(aacceuil_pnLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(employeh_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visiteurh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expositionh_btn)
                    .addComponent(billeth_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        aacceuil_pnLayout.setVerticalGroup(
            aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aacceuil_pnLayout.createSequentialGroup()
                .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aacceuil_pnLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oeuvreh_btn)
                            .addComponent(aartisteh_btn)
                            .addComponent(expositionh_btn)))
                    .addGroup(aacceuil_pnLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billeth_btn)
                    .addGroup(aacceuil_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeh_btn)
                        .addComponent(visiteurh_btn)))
                .addContainerGap(316, Short.MAX_VALUE))
        );

        artiste_panel.setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("LISTE DES ARTISTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 40));

        artistes_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(artistes_tableau);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 540, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-casual-life-black-girl-painting.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 260, 420));

        javax.swing.GroupLayout artiste_panelLayout = new javax.swing.GroupLayout(artiste_panel);
        artiste_panel.setLayout(artiste_panelLayout);
        artiste_panelLayout.setHorizontalGroup(
            artiste_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        artiste_panelLayout.setVerticalGroup(
            artiste_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        visiteur_panel.setBackground(new java.awt.Color(51, 255, 0));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("LISTE DES VISITEURS");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 40));

        visiteurs_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(visiteurs_tableau);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 540, 400));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-business-young-women-students-smiling.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 260, 420));

        javax.swing.GroupLayout visiteur_panelLayout = new javax.swing.GroupLayout(visiteur_panel);
        visiteur_panel.setLayout(visiteur_panelLayout);
        visiteur_panelLayout.setHorizontalGroup(
            visiteur_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        visiteur_panelLayout.setVerticalGroup(
            visiteur_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        exposition_panel.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("EXPOSITIONS ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 170, 40));

        exposition_tableau.setBackground(new java.awt.Color(102, 255, 255));
        exposition_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(exposition_tableau);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 590, 240));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/haze-digital-illustrator-workplace-1.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 220, 240));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        nomExposition_txt.setBackground(new java.awt.Color(255, 255, 255));
        nomExposition_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NOM");
        jLabel7.setToolTipText("");

        debut_date.setBackground(new java.awt.Color(255, 255, 255));
        debut_date.setForeground(new java.awt.Color(0, 0, 0));

        fin_date.setBackground(new java.awt.Color(255, 255, 255));
        fin_date.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FIN");
        jLabel10.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DEBUT");
        jLabel9.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCRIPTION");
        jLabel11.setToolTipText("");

        description_txt.setBackground(new java.awt.Color(255, 255, 255));
        description_txt.setColumns(20);
        description_txt.setForeground(new java.awt.Color(0, 0, 0));
        description_txt.setRows(5);
        jScrollPane5.setViewportView(description_txt);

        prixVip_txt.setBackground(new java.awt.Color(255, 255, 255));
        prixVip_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("PRIX VIP");
        jLabel27.setToolTipText("");

        prix_classique_txt.setBackground(new java.awt.Color(255, 255, 255));
        prix_classique_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("PRIX CLASSIQUE");
        jLabel33.setToolTipText("");

        heureDebut_txt.setBackground(new java.awt.Color(255, 255, 255));
        heureDebut_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("HEURE DEBUT");
        jLabel55.setToolTipText("");

        heureFin_txt.setBackground(new java.awt.Color(255, 255, 255));
        heureFin_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("HEURE FIN");
        jLabel56.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(prix_classique_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prixVip_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel55)
                                        .addGap(18, 18, 18)
                                        .addComponent(heureDebut_txt))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomExposition_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel9)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(debut_date, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fin_date, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(jLabel56)
                                        .addGap(18, 18, 18)
                                        .addComponent(heureFin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nomExposition_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9)))
                        .addComponent(debut_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(fin_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55)
                        .addComponent(heureDebut_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel56)
                        .addComponent(heureFin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prixVip_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(prix_classique_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 300));

        annuleExposition_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_undelete_48px.png"))); // NOI18N
        jPanel3.add(annuleExposition_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 50, 50));

        addExposition_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_Plus_48px_1.png"))); // NOI18N
        addExposition_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addExposition_btnMouseClicked(evt);
            }
        });
        jPanel3.add(addExposition_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 50, 60));

        aff_btn.setBackground(new java.awt.Color(0, 204, 255));
        aff_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aff_btn.setForeground(new java.awt.Color(0, 0, 0));
        aff_btn.setText("AFFECTATION");
        aff_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aff_btnActionPerformed(evt);
            }
        });
        jPanel3.add(aff_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 110, -1));

        javax.swing.GroupLayout exposition_panelLayout = new javax.swing.GroupLayout(exposition_panel);
        exposition_panel.setLayout(exposition_panelLayout);
        exposition_panelLayout.setHorizontalGroup(
            exposition_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        exposition_panelLayout.setVerticalGroup(
            exposition_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        oeuvre_panel.setBackground(new java.awt.Color(51, 51, 0));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("OEUVRES");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 170, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/haze-digital-illustrator-workplace-1.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 240, 250));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NOM");
        jLabel13.setToolTipText("");

        artisteNom_txt.setBackground(new java.awt.Color(255, 255, 255));
        artisteNom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("NATIONALITE");
        jLabel15.setToolTipText("");

        nationlite_cbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Afrique du Sud", "Albanie", "Algérie", "Allemagne", "Andorre", "Angola", "Antigua-et-Barbuda", "Arabie Saoudite", "Argentine", "Arménie", "Australie", "Autriche", "Azerbaïdjan", "Bahamas", "Bahreïn", "Bangladesh", "Barbade", "Belgique", "Belize", "Bénin", "Bhoutan", "Biélorussie", "Birmanie", "Bolivie", "Bosnie-Herzégovine", "Botswana", "Brésil", "Brunei", "Bulgarie", "Burkina Faso", "Burundi", "Cambodge", "Cameroun", "Canada", "Cap-Vert", "Chili", "Chine", "Chypre", "Colombie", "Comores", "Congo", "Corée du Nord", "Corée du Sud", "Costa Rica", "Côte d'Ivoire", "Croatie", "Cuba", "Danemark", "Djibouti", "Dominique", "Égypte", "Émirats arabes unis", "Équateur", "Érythrée", "Espagne", "Estonie", "États-Unis", "Éthiopie", "Fidji", "Finlande", "France", "Gabon", "Gambie", "Géorgie", "Ghana", "Grèce", "Grenade", "Guatemala", "Guinée", "Guinée-Bissau", "Guinée équatoriale", "Guyana", "Haïti", "Honduras", "Hongrie", "Îles Marshall", "Îles Salomon", "Inde", "Indonésie", "Irak", "Iran", "Irlande", "Islande", "Israël", "Italie", "Jamaïque", "Japon", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati", "Koweït", "Laos", "Lesotho", "Lettonie", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie", "Luxembourg", "Macédoine", "Madagascar", "Malaisie", "Malawi", "Maldives", "Mali", "Malte", "Maroc", "Maurice", "Mauritanie", "Mexique", "Micronésie", "Moldavie", "Monaco", "Mongolie", "Monténégro", "Mozambique", "Namibie", "Nauru", "Népal", "Nicaragua", "Niger", "Nigeria", "Niue", "Norvège", "Nouvelle-Zélande", "Oman", "Ouganda", "Ouzbékistan", "Pakistan", "Palaos", "Palestine", "Panama", "Papouasie-Nouvelle-Guinée", "Paraguay", "Pays-Bas", "Pérou", "Philippines", "Pologne", "Portugal", "Qatar", "République centrafricaine", "République démocratique du Congo", "République dominicaine", "République tchèque", "Roumanie", "Royaume-Uni", "Russie", "Rwanda", "Saint-Christophe-et-Niévès", "Sainte-Lucie", "Saint-Marin", "Saint-Siège", "Saint-Vincent-et-les-Grenadines", "Salvador", "Samoa", "Sao Tomé-et-Principe", "Sénégal", "Serbie", "Seychelles", "Sierra Leone", "Singapour", "Slovaquie", "Slovénie", "Somalie", "Soudan", "Soudan du Sud", "Sri Lanka", "Suède", "Suisse", "Suriname", "Swaziland" }));

        artistedate_txt.setBackground(new java.awt.Color(255, 255, 255));
        artistedate_txt.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DATE NAISSANCE");
        jLabel17.setToolTipText("");

        biographie_txt.setBackground(new java.awt.Color(255, 255, 255));
        biographie_txt.setColumns(1);
        biographie_txt.setForeground(new java.awt.Color(0, 0, 0));
        biographie_txt.setLineWrap(true);
        biographie_txt.setRows(5);
        jScrollPane4.setViewportView(biographie_txt);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("BIOGRAPHIE");
        jLabel16.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NOM");
        jLabel14.setToolTipText("");

        oeuvreNom_txt.setBackground(new java.awt.Color(255, 255, 255));
        oeuvreNom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("DATE ");
        jLabel18.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DESCRIPTION");
        jLabel20.setToolTipText("");

        oueuvreDescription_txt.setBackground(new java.awt.Color(255, 255, 255));
        oueuvreDescription_txt.setColumns(20);
        oueuvreDescription_txt.setForeground(new java.awt.Color(0, 0, 0));
        oueuvreDescription_txt.setLineWrap(true);
        oueuvreDescription_txt.setRows(5);
        jScrollPane6.setViewportView(oueuvreDescription_txt);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("OEUVRE");
        jLabel45.setToolTipText("");

        dateOeuvre_txt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Prix");
        jLabel21.setToolTipText("");

        prix_txt.setBackground(new java.awt.Color(255, 255, 255));

        artisteEmail_txt.setBackground(new java.awt.Color(255, 255, 255));
        artisteEmail_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Email");
        jLabel54.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)
                                .addComponent(artisteNom_txt)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(artistedate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prix_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nationlite_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel54)
                                .addGap(12, 12, 12)
                                .addComponent(artisteEmail_txt)
                                .addGap(43, 43, 43)))
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oeuvreNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateOeuvre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(313, 313, 313))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(artisteNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(artistedate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(nationlite_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(artisteEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(oeuvreNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(dateOeuvre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(prix_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 460));

        annuleOeuvre_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_undelete_48px.png"))); // NOI18N
        jPanel5.add(annuleOeuvre_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 50, 50));

        addOeuvre_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_Plus_48px_1.png"))); // NOI18N
        addOeuvre_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOeuvre_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addOeuvre_btnMouseEntered(evt);
            }
        });
        jPanel5.add(addOeuvre_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 50, 60));

        listOeuvre_btn.setBackground(new java.awt.Color(0, 204, 255));
        listOeuvre_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listOeuvre_btn.setForeground(new java.awt.Color(0, 0, 0));
        listOeuvre_btn.setText("Liste");
        listOeuvre_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOeuvre_btnActionPerformed(evt);
            }
        });
        jPanel5.add(listOeuvre_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 110, -1));

        javax.swing.GroupLayout oeuvre_panelLayout = new javax.swing.GroupLayout(oeuvre_panel);
        oeuvre_panel.setLayout(oeuvre_panelLayout);
        oeuvre_panelLayout.setHorizontalGroup(
            oeuvre_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        oeuvre_panelLayout.setVerticalGroup(
            oeuvre_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        billet_panel.setBackground(new java.awt.Color(102, 0, 102));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("BILLETS");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 170, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/haze-museum-building-and-exhibits-1.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 270));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NOM");
        jLabel24.setToolTipText("");

        clientNom_txt.setBackground(new java.awt.Color(255, 255, 255));
        clientNom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("TYPES");
        jLabel25.setToolTipText("");

        typeBillet_cbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLASSIQUE", "VIP" }));
        typeBillet_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeBillet_cbxActionPerformed(evt);
            }
        });

        client_date.setBackground(new java.awt.Color(255, 255, 255));
        client_date.setForeground(new java.awt.Color(0, 0, 0));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("DATE NAISSAANCE");
        jLabel26.setToolTipText("");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("MONTANT");
        jLabel28.setToolTipText("");

        montant_txt.setBackground(new java.awt.Color(255, 255, 255));
        montant_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        clientEmail_txt.setBackground(new java.awt.Color(255, 255, 255));
        clientEmail_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("EMAIL");
        jLabel32.setToolTipText("");

        clientPrenom_txt.setBackground(new java.awt.Color(255, 255, 255));
        clientPrenom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("PRENOM");
        jLabel34.setToolTipText("");

        exposition_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exposition_cbxActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("EXPOSITION");
        jLabel35.setToolTipText("");

        billetTableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(billetTableau);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(12, 12, 12)
                                .addComponent(clientNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientPrenom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(typeBillet_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(clientEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(client_date, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel35)
                                        .addGap(18, 18, 18)
                                        .addComponent(exposition_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montant_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(clientNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(clientPrenom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(clientEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addComponent(client_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeBillet_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)
                        .addComponent(exposition_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 460));

        annuleBillet_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_undelete_48px.png"))); // NOI18N
        jPanel8.add(annuleBillet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 50, 50));

        addBillet_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_Plus_48px_1.png"))); // NOI18N
        addBillet_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBillet_btnMouseClicked(evt);
            }
        });
        jPanel8.add(addBillet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 50, 60));

        javax.swing.GroupLayout billet_panelLayout = new javax.swing.GroupLayout(billet_panel);
        billet_panel.setLayout(billet_panelLayout);
        billet_panelLayout.setHorizontalGroup(
            billet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        billet_panelLayout.setVerticalGroup(
            billet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billet_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        employe_panel.setBackground(new java.awt.Color(0, 102, 153));

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("EMPLOYEE");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 170, 40));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-business-man-and-woman-at-work.png"))); // NOI18N
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 270));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("NOM");
        jLabel31.setToolTipText("");

        employeNom_txt.setBackground(new java.awt.Color(255, 255, 255));
        employeNom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Tel");
        jLabel36.setToolTipText("");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("SALAIRE");
        jLabel37.setToolTipText("");

        poste_txt.setBackground(new java.awt.Color(255, 255, 255));
        poste_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("POSTE");
        jLabel39.setToolTipText("");

        employePrenom_txt.setBackground(new java.awt.Color(255, 255, 255));
        employePrenom_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("PRENOM");
        jLabel40.setToolTipText("");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("ADRESSE");
        jLabel41.setToolTipText("");

        employe_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(employe_tableau);

        salaire_txt.setBackground(new java.awt.Color(255, 255, 255));
        salaire_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        tel_txt.setBackground(new java.awt.Color(255, 255, 255));
        tel_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        adresse_txt.setBackground(new java.awt.Color(255, 255, 255));
        adresse_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tel_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(poste_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salaire_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adresse_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addGap(18, 18, 18)
                            .addComponent(employeNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel40)
                            .addGap(24, 24, 24)
                            .addComponent(employePrenom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(employeNom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(employePrenom_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(poste_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(salaire_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(tel_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addComponent(adresse_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 460));

        annuleEmployee_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_undelete_48px.png"))); // NOI18N
        jPanel11.add(annuleEmployee_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 50, 50));

        addEmployee_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_Plus_48px_1.png"))); // NOI18N
        addEmployee_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEmployee_btnMouseClicked(evt);
            }
        });
        jPanel11.add(addEmployee_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 50, 60));

        javax.swing.GroupLayout employe_panelLayout = new javax.swing.GroupLayout(employe_panel);
        employe_panel.setLayout(employe_panelLayout);
        employe_panelLayout.setHorizontalGroup(
            employe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        employe_panelLayout.setVerticalGroup(
            employe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        user_panel.setBackground(new java.awt.Color(0, 51, 51));

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("UTILISATEUR");
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 170, 40));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-casual-life-group-of-young-people-discussing-something-while-working.png"))); // NOI18N
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 270));

        jPanel15.setBackground(new java.awt.Color(0, 102, 102));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("USER");
        jLabel43.setToolTipText("");

        userName_txt.setBackground(new java.awt.Color(255, 255, 255));
        userName_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        userRole_txt.setBackground(new java.awt.Color(255, 255, 255));
        userRole_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ROLE");
        jLabel46.setToolTipText("");

        userEmail_txt.setBackground(new java.awt.Color(255, 255, 255));
        userEmail_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("EMAIL");
        jLabel47.setToolTipText("");

        utilisateur_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(utilisateur_tableau);

        supprimerUser_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_undelete_48px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(userName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addGap(24, 24, 24)
                        .addComponent(userEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(userRole_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(supprimerUser_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(userName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(userEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(userRole_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(supprimerUser_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 460));

        javax.swing.GroupLayout user_panelLayout = new javax.swing.GroupLayout(user_panel);
        user_panel.setLayout(user_panelLayout);
        user_panelLayout.setHorizontalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        user_panelLayout.setVerticalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        heaader.setBackground(new java.awt.Color(0, 102, 102));

        hclient_pn.setForeground(new java.awt.Color(51, 255, 51));
        hclient_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/6009864.png"))); // NOI18N
        hclient_pn.setText("jLabel44");
        hclient_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hclient_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hclient_pnMouseEntered(evt);
            }
        });

        huser_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/user.png"))); // NOI18N
        huser_pn.setText("jLabel44");
        huser_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huser_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                huser_pnMouseEntered(evt);
            }
        });

        hemploye_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/912267.png"))); // NOI18N
        hemploye_pn.setText("jLabel44");
        hemploye_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hemploye_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hemploye_pnMouseEntered(evt);
            }
        });

        hexposition_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/28579.png"))); // NOI18N
        hexposition_pn.setText("bel44");
        hexposition_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hexposition_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hexposition_pnMouseEntered(evt);
            }
        });

        hticket_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/1085269.png"))); // NOI18N
        hticket_pn.setText("jLabel44");
        hticket_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hticket_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hticket_pnMouseEntered(evt);
            }
        });

        hartiste_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/171womanartist1_101013.png"))); // NOI18N
        hartiste_pn.setText("jLabel44");
        hartiste_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hartiste_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hartiste_pnMouseEntered(evt);
            }
        });

        houeuvre_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/2156081.png"))); // NOI18N
        houeuvre_pn.setText("jLabel44");
        houeuvre_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                houeuvre_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                houeuvre_pnMouseEntered(evt);
            }
        });

        deconnexion_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/i/icons8_export_40px.png"))); // NOI18N
        deconnexion_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexion_pnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deconnexion_pnMouseEntered(evt);
            }
        });

        usernaame_labele.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usernaame_labele.setForeground(new java.awt.Color(0, 0, 0));
        usernaame_labele.setText("jLabel44");

        javax.swing.GroupLayout heaaderLayout = new javax.swing.GroupLayout(heaader);
        heaader.setLayout(heaaderLayout);
        heaaderLayout.setHorizontalGroup(
            heaaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heaaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(hclient_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(hemploye_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(hexposition_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(hticket_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hartiste_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(houeuvre_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(huser_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(heaaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(heaaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deconnexion_pn))
                    .addComponent(usernaame_labele, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
        );
        heaaderLayout.setVerticalGroup(
            heaaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heaaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(heaaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hclient_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(huser_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hemploye_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hexposition_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hticket_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hartiste_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(houeuvre_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(heaaderLayout.createSequentialGroup()
                .addComponent(deconnexion_pn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernaame_labele, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        affectation_panel.setBackground(new java.awt.Color(0, 204, 204));

        jPanel17.setBackground(new java.awt.Color(0, 204, 204));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Affecter des oeuvre a une exposition");
        jPanel17.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 440, 40));

        affectation_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(affectation_tableau);

        jPanel17.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 580, 340));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-construction-abstract-different-floating-shapes.png"))); // NOI18N
        jLabel49.setText("jLabel2");
        jPanel17.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 330, 430));

        jPanel17.add(expositiona_cbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, -1));

        jPanel17.add(oeuvresa_cbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 150, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Expositions");
        jPanel17.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Oeuvres");
        jPanel17.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        add_affectation.setText("Ajouter");
        add_affectation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_affectationActionPerformed(evt);
            }
        });
        jPanel17.add(add_affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 100, -1));

        javax.swing.GroupLayout affectation_panelLayout = new javax.swing.GroupLayout(affectation_panel);
        affectation_panel.setLayout(affectation_panelLayout);
        affectation_panelLayout.setHorizontalGroup(
            affectation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        affectation_panelLayout.setVerticalGroup(
            affectation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        listeOeuvre_paanel.setBackground(new java.awt.Color(0, 204, 204));

        jPanel18.setBackground(new java.awt.Color(0, 204, 204));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("LISTE DES Oeuvres");
        jPanel18.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 40));

        oeuvre_tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(oeuvre_tableau);

        jPanel18.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 630, 540));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3d-casual-life-black-girl-painting.png"))); // NOI18N
        jLabel53.setText("jLabel2");
        jPanel18.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 260, 420));

        javax.swing.GroupLayout listeOeuvre_paanelLayout = new javax.swing.GroupLayout(listeOeuvre_paanel);
        listeOeuvre_paanel.setLayout(listeOeuvre_paanelLayout);
        listeOeuvre_paanelLayout.setHorizontalGroup(
            listeOeuvre_paanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeOeuvre_paanelLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        listeOeuvre_paanelLayout.setVerticalGroup(
            listeOeuvre_paanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeOeuvre_paanelLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout content_panelLayout = new javax.swing.GroupLayout(content_panel);
        content_panel.setLayout(content_panelLayout);
        content_panelLayout.setHorizontalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(heaader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(artiste_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(content_panelLayout.createSequentialGroup()
                    .addComponent(visiteur_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(exposition_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(oeuvre_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(billet_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(employe_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(user_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(content_panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(affectation_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(listeOeuvre_paanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        content_panelLayout.setVerticalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content_panelLayout.createSequentialGroup()
                .addComponent(heaader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 679, Short.MAX_VALUE))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 87, Short.MAX_VALUE)
                    .addComponent(artiste_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 88, Short.MAX_VALUE)
                    .addComponent(visiteur_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 86, Short.MAX_VALUE)
                    .addComponent(exposition_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 87, Short.MAX_VALUE)
                    .addComponent(oeuvre_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 86, Short.MAX_VALUE)
                    .addComponent(billet_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 87, Short.MAX_VALUE)
                    .addComponent(employe_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addGap(0, 87, Short.MAX_VALUE)
                    .addComponent(user_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(affectation_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
            .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(content_panelLayout.createSequentialGroup()
                    .addComponent(listeOeuvre_paanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1033, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(aacceuil_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(content_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(aacceuil_pn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // GESTION DU MOUVEMENT DE LAA SOURIS:-------------------------------------------------------------------------------------------------------------------------------
    private void hclient_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hclient_pnMouseEntered
        // TODO add your handling code here:
        hclient_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hclient_pnMouseEntered

    private void hemploye_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hemploye_pnMouseEntered
        hemploye_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_hemploye_pnMouseEntered

    private void hexposition_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hexposition_pnMouseEntered

        hexposition_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hexposition_pnMouseEntered

    private void hticket_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hticket_pnMouseEntered
        // TODO add your handling code here:
        hticket_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hticket_pnMouseEntered

    private void hartiste_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hartiste_pnMouseEntered
        // TODO add your handling code here:
        hartiste_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hartiste_pnMouseEntered

    private void houeuvre_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_houeuvre_pnMouseEntered
        // TODO add your handling code here:
        houeuvre_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_houeuvre_pnMouseEntered

    private void huser_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huser_pnMouseEntered
        // TODO add your handling code here:
        huser_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


    }//GEN-LAST:event_huser_pnMouseEntered

    private void deconnexion_pnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexion_pnMouseEntered
        // TODO add your handling code here:
        deconnexion_pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_deconnexion_pnMouseEntered

    private void hclient_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hclient_pnMouseClicked
        // TODO add your handling code here:

        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(true);
        listeOeuvre_paanel.setVisible(false);

        affectation_panel.setVisible(false);


    }//GEN-LAST:event_hclient_pnMouseClicked

    private void hemploye_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hemploye_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(true);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_hemploye_pnMouseClicked

    private void hexposition_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hexposition_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(true);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_hexposition_pnMouseClicked

    private void hticket_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hticket_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(true);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_hticket_pnMouseClicked

    private void hartiste_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hartiste_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(true);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_hartiste_pnMouseClicked

    private void houeuvre_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_houeuvre_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(true);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_houeuvre_pnMouseClicked

    private void huser_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huser_pnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(true);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_huser_pnMouseClicked

    private void deconnexion_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexion_pnMouseClicked
        // TODO add your handling code here:

        new Login().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_deconnexion_pnMouseClicked

    private void oeuvreh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oeuvreh_btnMouseEntered
        // TODO add your handling code here:
        oeuvreh_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_oeuvreh_btnMouseEntered

    private void expositionh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expositionh_btnMouseEntered
        // TODO add your handling code here:
        expositionh_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_expositionh_btnMouseEntered

    private void employeh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeh_btnMouseEntered
        // TODO add your handling code here:
        employeh_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_employeh_btnMouseEntered

    private void billeth_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billeth_btnMouseEntered
        // TODO add your handling code here:
        billeth_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_billeth_btnMouseEntered

    private void aartisteh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aartisteh_btnMouseEntered
        // TODO add your handling code here:
        aartisteh_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_aartisteh_btnMouseEntered

    private void visiteurh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiteurh_btnMouseEntered
        // TODO add your handling code here:
        visiteurh_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_visiteurh_btnMouseEntered

    private void aartisteh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aartisteh_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(true);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_aartisteh_btnMouseClicked

    private void oeuvreh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oeuvreh_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(true);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_oeuvreh_btnMouseClicked

    private void expositionh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expositionh_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(true);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_expositionh_btnMouseClicked

    private void employeh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeh_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(true);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);

        affectation_panel.setVisible(false);

    }//GEN-LAST:event_employeh_btnMouseClicked

    private void visiteurh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiteurh_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(true);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_visiteurh_btnMouseClicked

    private void billeth_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billeth_btnMouseClicked
        // TODO add your handling code here:
        affichageArtiste();
        affichageOeuvre();
        affichageEmploye();
        affichageTicket();
        affichageExposition();
        affichageVisiteur();
        affichageUser();
        loadExposition();
        loadExpositionD();
        loadOeuvre();
        affichageOeuvreExposition();

        employeh_btn.setBackground(new Color(60, 63, 65));
        billeth_btn.setBackground(Color.white);
        visiteurh_btn.setBackground(new Color(60, 63, 65));
        expositionh_btn.setBackground(new Color(60, 63, 65));
        oeuvreh_btn.setBackground(new Color(60, 63, 65));
        aartisteh_btn.setBackground(new Color(60, 63, 65));

        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(true);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(false);


    }//GEN-LAST:event_billeth_btnMouseClicked

    private void addOeuvre_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOeuvre_btnMouseEntered
        // TODO add your handling code here:
        addOeuvre_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_addOeuvre_btnMouseEntered

    private void addOeuvre_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOeuvre_btnMouseClicked
        // TODO add your handling code here:
        try {
            String nom_artiste = artisteNom_txt.getText();
//            String email_artiste = email_txt.getText();
            String biographie = biographie_txt.getText();
            String nationalite = nationlite_cbx.getSelectedItem().toString();
            Date date_naissance = artistedate_txt.getDate();
            String email = artisteEmail_txt.getText();
            String oeuvre_nom = oeuvreNom_txt.getText();
            String oeuvre_description = oueuvreDescription_txt.getText();
            int oeuvre_date = Integer.parseInt(dateOeuvre_txt.getText());
            float prix;

            try {
                prix = Float.parseFloat(prix_txt.getText());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisire des nombres");

                return;
            }

            if (MyFonction.testFields(nom_artiste, biographie, nationalite, oeuvre_nom, oeuvre_description, prix_txt.getText(), dateOeuvre_txt.getText())) {
                JOptionPane.showMessageDialog(null, "Veuillez remplire tout les champs ou verifier la taille des texts");
                return;
            }

            Artiste artiste = Utils.getiArtiste().findByEmail(email);
            if (artiste == null) {
                artiste = new Artiste(nom_artiste, email, date_naissance, nationalite, biographie, user);
                Artiste addArtiste = Utils.getiArtiste().addArtiste(artiste);
                Oeuvre oeuvre = new Oeuvre(oeuvre_nom, oeuvre_date, oeuvre_description, prix, addArtiste, user);
                Oeuvre addOeuvre = Utils.getiOeuvre().addOeuvre(oeuvre);
                if (addOeuvre.getId() != null) {
                    MyFonction.clearFormFields(oeuvreNom_txt, artisteNom_txt, prix_txt, prix_txt, artisteEmail_txt, dateOeuvre_txt);
                    oueuvreDescription_txt.setText("");
                    biographie_txt.setText("");
                    artistedate_txt.setDate(null);
                    nationlite_cbx.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Oeuvre a ete ajouter avec succes");
                    affichageOeuvre();
                }

            } else {
                Oeuvre oeuvre = new Oeuvre(oeuvre_nom, oeuvre_date, oeuvre_description, prix, artiste, user);
                Oeuvre addOeuvre = Utils.getiOeuvre().addOeuvre(oeuvre);
                if (addOeuvre.getId() != null) {
                    MyFonction.clearFormFields(oeuvreNom_txt, artisteNom_txt, prix_txt, prix_txt, artisteEmail_txt, dateOeuvre_txt);
                    oueuvreDescription_txt.setText("");
                    biographie_txt.setText("");
                    artistedate_txt.setDate(null);

                    nationlite_cbx.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Cette artiste est deja enregistrer dans notre musee!!");
                    JOptionPane.showMessageDialog(null, "Oeuvre a ete ajouter avec succes");
                    affichageOeuvre();
                }

            }

        } catch (RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Une erreur c'est produit veuillez controler vis saisie et resayer");

        }
    }//GEN-LAST:event_addOeuvre_btnMouseClicked

    private void addExposition_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addExposition_btnMouseClicked
        // TODO add your handling code here:

        try {
            String nomExposition = nomExposition_txt.getText();
            Date date_debut = debut_date.getDate();
            Date date_fin = fin_date.getDate();
            float prix_vip;
            float prix_classique;
            String description = description_txt.getText();
            String heureDebut = heureDebut_txt.getText();
            String heureFin = heureFin_txt.getText();
                    

            if (date_debut.before(new Date()) || date_fin.before(date_debut)) {
                JOptionPane.showMessageDialog(null, "incoherence de date");
                return;

            }

            try {
                prix_vip = Float.parseFloat(prixVip_txt.getText());
                prix_classique = Float.parseFloat(prix_classique_txt.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisire des nombres");

                return;
            }
            if (!MyFonction.isValidTime(heureDebut) || !MyFonction.isValidTime(heureFin)) {
                JOptionPane.showMessageDialog(null, "Heure au format invalide. Exemple : 09:05");
                return; // ou utilisez "return;" pour terminer la méthode sans valeur de retour
            }


            if (MyFonction.testFields(nomExposition, description, prixVip_txt.getText(), prix_classique_txt.getText())) {
                JOptionPane.showMessageDialog(null, "Veuillez remplire tout les champs ou verifier la taille des textes");
                return;
            }
            Exposition exp = new Exposition(nomExposition,heureDebut, heureFin, date_debut, date_fin, description, prix_vip, prix_classique, user);
            Exposition expadd = Utils.getiExposition().addExposition(exp);

            if (expadd != null) {
                MyFonction.clearFormExposition(nomExposition_txt, prixVip_txt, prix_classique_txt, description_txt, fin_date, debut_date);
                JOptionPane.showMessageDialog(null, "Exposition a ete ajouter avec succes");
                affichageExposition();
            }

        } catch (RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Une erreur c'est produit veuillez controler vis saisie et resayer");

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addExposition_btnMouseClicked

    private void addEmployee_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployee_btnMouseClicked
        // TODO add your handling code here:
        try {
            String nomEmp = employeNom_txt.getText();
            String prenomEmp = employePrenom_txt.getText();
            String telEmp = tel_txt.getText();
            String adresse = adresse_txt.getText();
            String poste = poste_txt.getText();
            float salaire;

            try {
                salaire = Float.parseFloat(salaire_txt.getText());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisire des nombres");

                return;
            }

            if (MyFonction.controleTel(telEmp)) {
                JOptionPane.showMessageDialog(null, "format du numero telephone est incorecte ");
                return;
            }

            if (MyFonction.testFields(nomEmp, prenomEmp, telEmp, adresse, poste, salaire_txt.getText())) {
                JOptionPane.showMessageDialog(null, "Veuillez remplire tout les champs ou verifier la taille des textes");
                return;
            }

            Employe emp = new Employe(nomEmp, prenomEmp, poste, adresse, telEmp, salaire);
            Employe addEmp = Utils.getiEmploye().addEmploye(emp);

            if (addEmp != null) {
                MyFonction.clearFormEmployer(employeNom_txt, employePrenom_txt, tel_txt, adresse_txt, poste_txt, salaire_txt);
                JOptionPane.showMessageDialog(null, "Employe a ete ajouter avec succes");
                affichageEmploye();
            }

        } catch (RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Une erreur c'est produit veuillez controler vis saisie et resayer");

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addEmployee_btnMouseClicked

    private void addBillet_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBillet_btnMouseClicked
        // TODO add your handling code here:       
        try {

            String nomVisiteur = clientNom_txt.getText();
            String prenomVisiteur = clientPrenom_txt.getText();
            String emailVisiteur = clientEmail_txt.getText();
            Date dateClient = client_date.getDate();
            String typeBillet = typeBillet_cbx.getSelectedItem().toString();
            String exponame = exposition_cbx.getSelectedItem().toString();

            Exposition ex = Utils.getiExposition().findExpositionByname(exponame);

            if (MyFonction.testFields(nomVisiteur, prenomVisiteur, emailVisiteur)) {
                JOptionPane.showMessageDialog(null, "Veuillez remplire tout les champs ou verifier la taille des textes");
                return;
            }

            if (MyFonction.validerEmail(emailVisiteur)) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un email valide");
                return;
            }
            Date dateActuelle = new Date();

            Visiteur v = new Visiteur(nomVisiteur, prenomVisiteur, emailVisiteur, dateClient, user);
            Visiteur adv = Utils.getiVisiteur().addVisiteur(v);

            Billet b = new Billet(dateActuelle, typeBillet, adv, ex, user);
            Billet adb = Utils.getiBillet().addBillet(b);

            if (adb != null) {
                MyFonction.clearBillet(clientNom_txt, clientPrenom_txt, clientEmail_txt, adresse_txt, exposition_cbx, client_date);
                //JOptionPane.showMessageDialog(null, "billet a ete ajouter avec succes");
                new generateBillet(adb).setVisible(true);
                affichageTicket();
            }

        } catch (RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Une erreur c'est produit veuillez controler vis saisie et resayer");

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBillet_btnMouseClicked

    private void aff_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aff_btnActionPerformed
        // TODO add your handling code here:
        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(true);
        listeOeuvre_paanel.setVisible(false);

    }//GEN-LAST:event_aff_btnActionPerformed

    private void listOeuvre_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOeuvre_btnActionPerformed
        // TODO add your handling code here:
        content_panel.setVisible(true);
        aacceuil_pn.setVisible(false);
        artiste_panel.setVisible(false);
        billet_panel.setVisible(false);
        employe_panel.setVisible(false);
        exposition_panel.setVisible(false);
        user_panel.setVisible(false);
        oeuvre_panel.setVisible(false);
        visiteur_panel.setVisible(false);
        affectation_panel.setVisible(false);
        listeOeuvre_paanel.setVisible(true);

    }//GEN-LAST:event_listOeuvre_btnActionPerformed

    private void add_affectationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_affectationActionPerformed
        // TODO add your handling code here:
        try {
            String exponame = expositiona_cbx.getSelectedItem().toString();
            Exposition ea = Utils.getiExposition().findExpositionByname(exponame);

            String oeuvrename = oeuvresa_cbx.getSelectedItem().toString();
            Oeuvre oe = Utils.getiOeuvre().findOeuvreByname(oeuvrename);

            OeuvresExposition addoe = new OeuvresExposition(oe, ea);

            OeuvresExposition ajoutoe = Utils.getiOeuvreExposition().addOeuvreExposition(addoe);

            if (ajoutoe != null) {
                MyFonction.clearBillet(clientNom_txt, clientPrenom_txt, clientEmail_txt, adresse_txt, exposition_cbx, client_date);
                JOptionPane.showMessageDialog(null, "Affectation effectuée avec succès");
                affichageOeuvreExposition();
            }
        } catch (RemoteException ex) {
            System.err.println("Erreur : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite. Veuillez vérifier votre saisie et réessayer.");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_affectationActionPerformed

    private void exposition_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exposition_cbxActionPerformed
        // TODO add your handling code here:
        if (exposition_cbx.getSelectedItem() != null) {
            try {
                montant_txt.setEnabled(true);

                montant_txt.setText("");

                String exponame = exposition_cbx.getSelectedItem().toString();
                Exposition ea = Utils.getiExposition().findExpositionByname(exponame);
                

                if (typeBillet_cbx.getSelectedItem().toString().equalsIgnoreCase("CLASSIQUE")) {
                    montant_txt.setText(String.valueOf(ea.getPrix_clssique()));
                } else {
                    montant_txt.setText(String.valueOf(ea.getPrix_vip()));

                }
            } catch (RemoteException ex) {
                System.err.println("Erreur : " + ex.getMessage());

                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        montant_txt.setEnabled(false);


    }//GEN-LAST:event_exposition_cbxActionPerformed

    private void typeBillet_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeBillet_cbxActionPerformed
        // TODO add your handling code here:
        if (exposition_cbx.getSelectedItem() != null) {
            try {
                montant_txt.setEnabled(true);

                montant_txt.setText("");

                String exponame = exposition_cbx.getSelectedItem().toString();
                Exposition ea = Utils.getiExposition().findExpositionByname(exponame);
               

                if (typeBillet_cbx.getSelectedItem().toString().equalsIgnoreCase("CLASSIQUE")) {
                    montant_txt.setText(String.valueOf(ea.getPrix_clssique()));
                } else {
                    montant_txt.setText(String.valueOf(ea.getPrix_vip()));

                }
            } catch (RemoteException ex) {
                System.err.println("Erreur : " + ex.getMessage());

                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        montant_txt.setEnabled(false);

    }//GEN-LAST:event_typeBillet_cbxActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aacceuil_pn;
    private javax.swing.JLabel aartisteh_btn;
    private javax.swing.JLabel addBillet_btn;
    private javax.swing.JLabel addEmployee_btn;
    private javax.swing.JLabel addExposition_btn;
    private javax.swing.JLabel addOeuvre_btn;
    private javax.swing.JButton add_affectation;
    private javax.swing.JTextField adresse_txt;
    private javax.swing.JButton aff_btn;
    private javax.swing.JPanel affectation_panel;
    private javax.swing.JTable affectation_tableau;
    private javax.swing.JLabel annuleBillet_btn;
    private javax.swing.JLabel annuleEmployee_btn;
    private javax.swing.JLabel annuleExposition_btn;
    private javax.swing.JLabel annuleOeuvre_btn;
    private javax.swing.JTextField artisteEmail_txt;
    private javax.swing.JTextField artisteNom_txt;
    private javax.swing.JPanel artiste_panel;
    private com.toedter.calendar.JDateChooser artistedate_txt;
    private javax.swing.JTable artistes_tableau;
    private javax.swing.JTable billetTableau;
    private javax.swing.JPanel billet_panel;
    private javax.swing.JLabel billeth_btn;
    private javax.swing.JTextArea biographie_txt;
    private javax.swing.JTextField clientEmail_txt;
    private javax.swing.JTextField clientNom_txt;
    private javax.swing.JTextField clientPrenom_txt;
    private com.toedter.calendar.JDateChooser client_date;
    private javax.swing.JPanel content_panel;
    private javax.swing.JTextField dateOeuvre_txt;
    private com.toedter.calendar.JDateChooser debut_date;
    private javax.swing.JLabel deconnexion_pn;
    private javax.swing.JTextArea description_txt;
    private javax.swing.JTextField employeNom_txt;
    private javax.swing.JTextField employePrenom_txt;
    private javax.swing.JPanel employe_panel;
    private javax.swing.JTable employe_tableau;
    private javax.swing.JLabel employeh_btn;
    private javax.swing.JComboBox<String> exposition_cbx;
    private javax.swing.JPanel exposition_panel;
    private javax.swing.JTable exposition_tableau;
    private javax.swing.JComboBox<String> expositiona_cbx;
    private javax.swing.JLabel expositionh_btn;
    private com.toedter.calendar.JDateChooser fin_date;
    private javax.swing.JLabel hartiste_pn;
    private javax.swing.JLabel hclient_pn;
    private javax.swing.JPanel heaader;
    private javax.swing.JLabel hemploye_pn;
    private javax.swing.JTextField heureDebut_txt;
    private javax.swing.JTextField heureFin_txt;
    private javax.swing.JLabel hexposition_pn;
    private javax.swing.JPanel home_panel;
    private javax.swing.JLabel houeuvre_pn;
    private javax.swing.JLabel hticket_pn;
    private javax.swing.JLabel huser_pn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton listOeuvre_btn;
    private javax.swing.JPanel listeOeuvre_paanel;
    private javax.swing.JTextField montant_txt;
    private javax.swing.JComboBox<String> nationlite_cbx;
    private javax.swing.JTextField nomExposition_txt;
    private javax.swing.JTextField oeuvreNom_txt;
    private javax.swing.JPanel oeuvre_panel;
    private javax.swing.JTable oeuvre_tableau;
    private javax.swing.JLabel oeuvreh_btn;
    private javax.swing.JComboBox<String> oeuvresa_cbx;
    private javax.swing.JTextArea oueuvreDescription_txt;
    private javax.swing.JTextField poste_txt;
    private javax.swing.JTextField prixVip_txt;
    private javax.swing.JTextField prix_classique_txt;
    private javax.swing.JTextField prix_txt;
    private javax.swing.JTextField salaire_txt;
    private javax.swing.JLabel supprimerUser_btn;
    private javax.swing.JTextField tel_txt;
    private javax.swing.JComboBox<String> typeBillet_cbx;
    private javax.swing.JTextField userEmail_txt;
    private javax.swing.JTextField userName_txt;
    private javax.swing.JTextField userRole_txt;
    private javax.swing.JPanel user_panel;
    private javax.swing.JLabel usernaame_labele;
    private javax.swing.JTable utilisateur_tableau;
    private javax.swing.JPanel visiteur_panel;
    private javax.swing.JLabel visiteurh_btn;
    private javax.swing.JTable visiteurs_tableau;
    // End of variables declaration//GEN-END:variables
}
