/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialapp;

import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Chinnmay
 */
public class bookingFirst extends javax.swing.JFrame {

    /**
     * Creates new form bookingFirst
     */
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
         static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
    public bookingFirst() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        newOrder = new javax.swing.JButton();
        trackOrder = new javax.swing.JButton();
        invoice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 60)); // NOI18N
        jLabel1.setText("BOOKING   PORTAL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 60, 580, 100);

        newOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        newOrder.setText("NEW ORDER");
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderActionPerformed(evt);
            }
        });
        getContentPane().add(newOrder);
        newOrder.setBounds(530, 240, 280, 40);

        trackOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        trackOrder.setText("TRACK ORDER");
        trackOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackOrderActionPerformed(evt);
            }
        });
        getContentPane().add(trackOrder);
        trackOrder.setBounds(530, 350, 280, 40);

        invoice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        invoice.setText("VIEW INVOICES");
        invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceActionPerformed(evt);
            }
        });
        getContentPane().add(invoice);
        invoice.setBounds(530, 460, 280, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(530, 560, 280, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/bookportalback_1366x768.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trackOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackOrderActionPerformed


        tracking obj=new tracking();
        obj.setTitle("TRACKING DETAILS");
        obj.setVisible(true);
    }//GEN-LAST:event_trackOrderActionPerformed

    private void invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceActionPerformed

        JFileChooser fileChooser = new JFileChooser();
fileChooser.setCurrentDirectory(new File("C:\\Users\\ROHIT\\Documents\\NetBeansProjects\\trialapp\\Invoices"));
int result = fileChooser.showOpenDialog(this);
if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    Desktop d=getDesktop();
            try {
                d.open(selectedFile);
            } catch (IOException ex) {
                Logger.getLogger(bookingFirst.class.getName()).log(Level.SEVERE, null, ex);
            }
    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
}
    }//GEN-LAST:event_invoiceActionPerformed

    private void newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderActionPerformed
        this.dispose();
        Sender obj=new Sender();
        obj.setVisible(true);
        obj.setTitle("USER DETAILS PAGE");
    }//GEN-LAST:event_newOrderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
              Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();        
        String query="DROP TABLE booking";
        stmt.executeUpdate(query);
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookingFirst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookingFirst.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         mainFrame obj=new  mainFrame();
         obj.setTitle("LOGIN PAGE");
         obj.setVisible(true);

         
         
         this.dispose();
            
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(bookingFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookingFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookingFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookingFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new bookingFirst().setVisible(true);
                bookingFirst obj=new bookingFirst();
                obj.setVisible(true);
                obj.setTitle("BOOKING PORTAL");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton invoice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton trackOrder;
    // End of variables declaration//GEN-END:variables
}
