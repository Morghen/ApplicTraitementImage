/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Morghen
 */
public class AppWindow extends javax.swing.JFrame {

    public Image imageDep;
    public Image imageRes;
    public File fichierSource;
    
    public AppWindow() {
        initComponents();
        imageDep = null;
        imageRes = null;
        fichierSource = null;
        fermerImage.setEnabled(false);
        sauverImage.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageDepSP = new javax.swing.JScrollPane();
        imageDepPanel = new javax.swing.JPanel();
        imageResSP = new javax.swing.JScrollPane();
        imageResPanel = new javax.swing.JPanel();
        menuPrincipal = new javax.swing.JMenuBar();
        fichierMenu = new javax.swing.JMenu();
        ouvrirImage = new javax.swing.JMenuItem();
        fermerImage = new javax.swing.JMenuItem();
        sauverImage = new javax.swing.JMenuItem();
        quitterApp = new javax.swing.JMenuItem();
        editionMenu = new javax.swing.JMenu();
        aproposMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application traitement d'image - HEPL");
        setLocation(new java.awt.Point(0, 0));
        setName("mainWindow"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 720));
        setSize(new java.awt.Dimension(1024, 720));

        imageDepPanel.setLayout(new java.awt.BorderLayout());
        imageDepSP.setViewportView(imageDepPanel);

        imageResPanel.setLayout(new java.awt.BorderLayout());
        imageResSP.setViewportView(imageResPanel);

        fichierMenu.setText("Fichier");

        ouvrirImage.setText("Ouvrir...");
        ouvrirImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirImageActionPerformed(evt);
            }
        });
        fichierMenu.add(ouvrirImage);

        fermerImage.setText("Fermer image");
        fermerImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerImageActionPerformed(evt);
            }
        });
        fichierMenu.add(fermerImage);

        sauverImage.setText("Sauver image destination");
        fichierMenu.add(sauverImage);

        quitterApp.setText("Quitter");
        quitterApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterAppActionPerformed(evt);
            }
        });
        fichierMenu.add(quitterApp);

        menuPrincipal.add(fichierMenu);

        editionMenu.setText("Edition");
        menuPrincipal.add(editionMenu);

        aproposMenu.setText("A propos");
        menuPrincipal.add(aproposMenu);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imageDepSP, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageResSP, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageDepSP, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addComponent(imageResSP)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    APPEL : quand un utilisateur clique sur le boutton Quitter du menu Fichier
    FONCTION : permet de quitter le programme proprement tout en demandant à l'utilisateur s'il veut sauvegarder son travail
    */
    private void quitterAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterAppActionPerformed
        if(fichierSource == null)
            System.exit(0);
        else
        {
            int choixDialog = JOptionPane.showConfirmDialog(null,"Votre travail peut être perdu, voulez-vous sauvegarder le résultat ?","Avertissement",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(choixDialog == JOptionPane.YES_OPTION)   // Si OUI
            {
                // Sauvegarder l'image résultat
                System.exit(0);
            }
            if(choixDialog == JOptionPane.NO_OPTION)    // Si NON
            {
                System.exit(0);
            }        
            // Rien ne se passe si Annuler
        }
    }//GEN-LAST:event_quitterAppActionPerformed
    
    /*
    APPEL : quand un utilisateur clique sur le boutton Ouvrir... du menu Fichier
    FONCTION : permet d'ouvrir une image provenant de son disque dur
    */
    private void ouvrirImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirImageActionPerformed
        // VERIFIER QU'IL N'Y A PAS D'IMAGE AVANT !!!
        
        
        fichierSource = ouvrirImage();
        if(fichierSource != null)
        {
            afficherImageInit();
            fermerImage.setEnabled(true);
            sauverImage.setEnabled(true);
        }          
        else
            JOptionPane.showMessageDialog(null, "Aucune image chargée", "Avertissement", JOptionPane.WARNING_MESSAGE);
 
    }//GEN-LAST:event_ouvrirImageActionPerformed
    
    /*
    APPEL : quand un utilisateur clique sur le boutton Fermer du menu Fichier
    FONCTION : permet de fermer l'image ouverte et de clean les variables membres
    */
    private void fermerImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerImageActionPerformed
        int choixDialog = JOptionPane.showConfirmDialog(null,"Votre travail peut être perdu, voulez-vous sauvegarder le résultat ?","Avertissement",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if(choixDialog == JOptionPane.YES_OPTION)   // Si OUI
        {
            // Sauvegarder l'image résultat
            cleanVariables();
            fermerImage.setEnabled(false);
            sauverImage.setEnabled(false);
        }
        if(choixDialog == JOptionPane.NO_OPTION)    // Si NON
        {
            cleanVariables();
            fermerImage.setEnabled(false);
            sauverImage.setEnabled(false);
        }        
        // Rien ne se passe si Annuler
       
    }//GEN-LAST:event_fermerImageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppWindow().setVisible(true);
            }
        });
    }

    /*
    APPEL : quand un utilisateur veut ouvrir une image
    FONCTION : permet à l'utilsateur de choisir l'image et de renvoyer le descripteur dans la variable membre
    */
    public File ouvrirImage() {
        
        JFileChooser openPic = new JFileChooser();  // Selection de fichier
        openPic.setAcceptAllFileFilterUsed(false);  // Cacher "Tous les fichier"
        openPic.setFileFilter(new FileNameExtensionFilter("Images (gif,jpg,png)","gif","jpg","png"));   // Filtrer uniquement sur certaines extension
        openPic.setCurrentDirectory(new File(System.getProperty("user.home"))); // Dossier de départ : home
        int resultat = openPic.showOpenDialog(null);    // Dialogue Ouvrir...
        if(resultat == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File fich = openPic.getSelectedFile();
                return fich;
            }  
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return fichierSource;
    }
    
    /*
    APPEL : quand un utilisateur a selectionné une image
    FONCTION : permet a la JVM d'afficher l'image départ et résultat (les mêmes au début) dans les panel appropriés
    */
    public void afficherImageInit() {
        
        try
        {
                imageDep = ImageIO.read(fichierSource);
                imageRes = ImageIO.read(fichierSource);
                ImageIcon imgG = new ImageIcon(imageDep);
                ImageIcon imgD = new ImageIcon(imageRes);
                JLabel imageLabelG = new JLabel("",imgG,JLabel.CENTER);
                JLabel imageLabelD = new JLabel("",imgD,JLabel.CENTER);
                imageDepPanel.add(imageLabelG,BorderLayout.CENTER);
                imageResPanel.add(imageLabelD,BorderLayout.CENTER);               
                this.validate();                            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /*
    APPEL : quand un utilisateur veut quitter le programme ou fermer l'image
    FONCTION : permet de nettoyer les variables pour le Garbage Collector
    */
    public void cleanVariables() {
        
        imageDepPanel.removeAll();
        imageResPanel.removeAll();
        fichierSource = null;
        imageDep = null;
        imageRes = null;
        this.validate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aproposMenu;
    private javax.swing.JMenu editionMenu;
    private javax.swing.JMenuItem fermerImage;
    private javax.swing.JMenu fichierMenu;
    private javax.swing.JPanel imageDepPanel;
    private javax.swing.JScrollPane imageDepSP;
    private javax.swing.JPanel imageResPanel;
    private javax.swing.JScrollPane imageResSP;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem ouvrirImage;
    private javax.swing.JMenuItem quitterApp;
    private javax.swing.JMenuItem sauverImage;
    // End of variables declaration//GEN-END:variables
}
