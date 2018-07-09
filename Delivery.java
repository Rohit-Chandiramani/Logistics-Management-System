/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chetan Chauhan
 */
package trialapp;

import java.awt.Component;
import java.awt.PopupMenu;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
public class Delivery extends javax.swing.JFrame {
    
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
   

    /**
     * Creates new form Delivery
     */
    public Delivery() {
        initComponents();
        getdata();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Name = new javax.swing.JLabel();
        Number = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        City = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        order_ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        delivery_status = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1336, 768));
        setPreferredSize(new java.awt.Dimension(1336, 768));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("NAME:-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(570, 100, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("NUMBER:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 150, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText(" USERNAME:- ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(560, 200, 160, 40);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 52)); // NOI18N
        jLabel4.setText("DELIVERY DETAILS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 20, 450, 60);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("CITY:-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 250, 80, 30);

        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "ORDER_ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tableComponentAdded(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(600, 330, 160, 190);

        Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(Name);
        Name.setBounds(730, 100, 260, 40);

        Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(Number);
        Number.setBounds(730, 150, 190, 40);

        Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(Username);
        Username.setBounds(730, 200, 180, 40);

        City.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(City);
        City.setBounds(730, 240, 150, 40);

        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setText("BACK TO LOGIN");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(560, 640, 250, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("ORDER_ID:-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 560, 160, 50);

        order_ID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        order_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_IDActionPerformed(evt);
            }
        });
        getContentPane().add(order_ID);
        order_ID.setBounds(500, 570, 150, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("DELIVERED:-");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(690, 560, 150, 50);

        delivery_status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delivery_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivery_statusActionPerformed(evt);
            }
        });
        getContentPane().add(delivery_status);
        delivery_status.setBounds(850, 570, 20, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("APPLY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(930, 570, 110, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/21023543_l-1024x1024_1366x768.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1370, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int column = 0;
        int row = table.getSelectedRow();
        try{
        String value = table.getModel().getValueAt(row, column).toString();
        order_ID.setText(value);
        delivery_status.setSelected(rootPaneCheckingEnabled);
              
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tableComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tableComponentAdded

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
                stmt=conn.createStatement();
                
                String query;
                
                
                query="drop table delivery";
                stmt.executeUpdate(query);
          
                
                }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        mainFrame obj=new mainFrame();
        obj.setVisible(true);
        obj.setTitle("LOGIN PAGE");
        
        this.dispose();
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(delivery_status.isSelected())
        {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        int column = 0;
        int row = table.getSelectedRow();
        try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
                stmt=conn.createStatement();
                
                String value = table.getModel().getValueAt(row, column).toString();
                String query;
                
                query="Update orders set delivery_status='d' where order_id='"+value+"'";
                stmt.executeUpdate(query);
                
                query="Select order_id from orders,reciever where reciever_number=number and delivery_status='n' and reciever.city='"+city+"'";
                rs=stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                //query="drop table delivery";
                //stmt.executeUpdate(query);
                
                }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void delivery_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivery_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivery_statusActionPerformed

    private void order_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_IDActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        System.out.print("IN DELIVERY");
        Delivery d=new Delivery();
                d.setTitle("DELIVERY PAGE");
                d.setVisible(true);
                d.getdata();
    }
    String city="";
    
    private void getdata()
    {
        String username="";
        
        String number="";
        String name="";
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="SELECT *FROM DELIVERY";
          rs=stmt.executeQuery(query);
          while(rs.next())
          {
          city=rs.getString("city");  
          name=rs.getString("name");
          number=rs.getString("number");
          username=rs.getString("username");
          }
          System.out.print(name);
          City.setText(city);
          Name.setText(name);
          Number.setText(number);
          Username.setText(username);
         
          
          query="Select order_id from orders,reciever where reciever_number=number and delivery_status='n' and reciever.city='"+city+"'";
          rs=stmt.executeQuery(query);
          //int i=0;
          /*while(rs.next())
          {
             table.getModel().setValueAt(rs.getString("order_id"),i , 0);
             i++;
          }*/
          table.setModel(DbUtils.resultSetToTableModel(rs));
         
         } catch (SQLException ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
         
    }   

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel City;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Number;
    private javax.swing.JLabel Username;
    private javax.swing.JCheckBox delivery_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField order_ID;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
