/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chetan Chauhan
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver extends javax.swing.JFrame {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
   ArrayList<String>userList=new ArrayList<String>();
   ArrayList<String>passList=new ArrayList<String>();


    /**
     * Creates new form Receiver
     */
    public Receiver() {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTextField1 = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        emailId = new javax.swing.JTextField();
        city = new javax.swing.JComboBox<>();
        pincode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(name);
        name.setBounds(113, 121, 231, 20);

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        getContentPane().add(contact);
        contact.setBounds(113, 152, 182, 20);
        getContentPane().add(emailId);
        emailId.setBounds(113, 183, 203, 20);

        city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Mumbai", "Hyderabad", "Delhi", "Kolkata", "Jaipur", "Bengaluru", "Jammu" }));
        getContentPane().add(city);
        city.setBounds(113, 214, 78, 20);
        getContentPane().add(pincode);
        pincode.setBounds(113, 245, 109, 20);

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(113, 276, 213, 105);

        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(444, 378, 85, 32);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("    Receiver Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(238, 51, 174, 27);

        jLabel2.setText(" Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(42, 124, 34, 14);

        jLabel3.setText(" Contact:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 158, 45, 14);

        jLabel4.setText(" Email_Id:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(42, 186, 47, 14);

        jLabel5.setText(" City:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(42, 217, 26, 14);

        jLabel6.setText(" Pincode:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(42, 248, 44, 14);

        jLabel7.setText(" Address:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(42, 276, 46, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String a=name.getText();
        String b=contact.getText();
        String c=emailId.getText();
        String d=city.getSelectedItem().toString();
        String e=pincode.getText();
        String f=address.getText();
        insertData(a,b,c,d,e,f);
        
        
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
            java.util.logging.Logger.getLogger(Receiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receiver().setVisible(true);
            }
        });
    }
    
    public void insertData(String a,String b,String c,String d,String e,String f)
    {
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="INSERT INTO reciever VALUES"+"("+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+d+"'"+","+"'"+e+"'"+","+"'"+f+"'"+")";
          stmt.executeUpdate(query);
         } catch (SQLException ex) {
             Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JComboBox<String> city;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField emailId;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pincode;
    // End of variables declaration//GEN-END:variables
}
