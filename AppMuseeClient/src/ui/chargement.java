/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;
import models.User;

/**
 *
 * @author couly
 */
public class chargement extends javax.swing.JFrame {
        private static User user;


    /**
     * Creates new form chargement
     */
    
   
    public chargement(User user) throws InterruptedException {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        startLoading();
       
  
 
    }
      
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 650, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Chargement...");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pngtree-museum-cartoon-illustration-png-image_9141124.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 570, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pexels-codioful-(formerly-gradienta)-7135069.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 917, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]){
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(chargement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(chargement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(chargement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(chargement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new chargement(user).setVisible(true);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(chargement.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//            
//       
//
//    }
    
     // ... Votre code pour l'interface graphique ...

    // Supposons que c'est la méthode que vous appelez lorsque vous souhaitez commencer le chargement
    public void startLoading() {
       
        LoadingWorker loadingWorker = new LoadingWorker(progressBar);
        progressBar.setStringPainted(true); // Pour afficher le pourcentage de progression
        loadingWorker.execute();
    }

    public class LoadingWorker extends SwingWorker<Void, Integer> {

        private JProgressBar progressBar;

        public LoadingWorker(JProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int progress = 0; progress <= 100; progress++) {
                Thread.sleep(50);
                publish(progress);
            }
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            int progress = chunks.get(chunks.size() - 1);
            progressBar.setValue(progress);
            
        }

        @Override
        protected void done() {
            new App(user).setVisible(true);
            dispose();
        }
    }
    
    // Supposons que c'est la méthode que vous appelez lorsque vous souhaitez commencer le chargement




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}