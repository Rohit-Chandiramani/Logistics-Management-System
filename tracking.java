package trialapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author girish
 */

import java.awt.Component;
import static java.lang.Math.round;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import trialapp.mainFrame;
public class tracking extends javax.swing.JFrame{

    /**
     * Creates new form tracking
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
   ArrayList<String>userList=new ArrayList<String>();
   ArrayList<String>passList=new ArrayList<String>();
   String orderdate,sendern,receivern,senderc,receiverc,timec;
   double timegraph,hrs;
   public static int days,time_in_sec;
   
   
    public tracking() {
        initComponents();
    }
     private void getData() throws ParseException
    {
        
        String orderi=Orderid.getText();
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="SELECT product_id,sender.name,reciever.name,cost,date_of_order,delivery_status from sender,reciever,orders where sender.number=sender_number and reciever.number=reciever_number and order_id="+orderi+";";
          rs=stmt.executeQuery(query);
         
         while(rs.next())
         {
             
             productid.setText(rs.getString("product_id"));
             sendern=rs.getString("sender.name");
        sendername.setText(sendern);
        receivern=rs.getString("reciever.name");
         receivername.setText(receivern);
        cost.setText(rs.getString("cost"));
        orderdate=rs.getString("date_of_order");
         dateoforder.setText(orderdate);
        
         if(rs.getString("delivery_status")=="d")
             status_label.setText("delivered");
         else
             status_label.setText("not delivered");
             
         }
       query="select city from sender where name='"+sendern+"';";
       rs=stmt.executeQuery(query);
       while(rs.next())
       {
           senderc=rs.getString("city");
       }
       query="select city from reciever where name='"+receivern+"';";
       rs=stmt.executeQuery(query);
       while(rs.next())
       {
           receiverc=rs.getString("city");
       }
         query="select "+receiverc+" from time_graph where city_name='"+senderc+"';";
       rs=stmt.executeQuery(query);
       while(rs.next())
       {
           
           timegraph=rs.getDouble(receiverc);
       }
       days=(int) round(timegraph);
       hrs=timegraph-days;
       hrs*=100;
       hrs+=days*24;
       query="select adddate('"+orderdate+"',INTERVAL "+hrs+" hour);";
       rs=stmt.executeQuery(query);
       
       while(rs.next())
       {
           orderdate=rs.getString("adddate('"+orderdate+"',INTERVAL "+hrs+" hour)");
       }
      
           query="select timediff('"+orderdate+"',now());";
       rs=stmt.executeQuery(query);
       while(rs.next())
       {
           try
           {
               timec=rs.getString("timediff('"+orderdate+"',now())");
                time.setText(timec);
                
           }catch(SQLException e)
           {
               time.setText("Delayed! Will be delivered shortly!");
              
           }           
       }
      query="select time_to_sec('"+timec+"');";
      rs=stmt.executeQuery(query);
      while(rs.next())
      {
          time_in_sec=rs.getInt("time_to_sec('"+timec+"')");
      }
       
       
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Orderid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        productid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sendername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        receivername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateoforder = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        status_label = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Enter order ID:-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 190, 120, 30);

        Orderid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderidActionPerformed(evt);
            }
        });
        getContentPane().add(Orderid);
        Orderid.setBounds(540, 190, 120, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(750, 180, 160, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product_id:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 260, 100, 30);

        productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productidActionPerformed(evt);
            }
        });
        getContentPane().add(productid);
        productid.setBounds(540, 260, 120, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Sender Name:-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 320, 110, 30);

        sendername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendernameActionPerformed(evt);
            }
        });
        getContentPane().add(sendername);
        sendername.setBounds(540, 320, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Receiver Name:-");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 380, 120, 30);

        receivername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivernameActionPerformed(evt);
            }
        });
        getContentPane().add(receivername);
        receivername.setBounds(540, 380, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cost:-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 450, 80, 30);

        cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costActionPerformed(evt);
            }
        });
        getContentPane().add(cost);
        cost.setBounds(540, 450, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Date of order:-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 510, 110, 30);

        dateoforder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateoforderActionPerformed(evt);
            }
        });
        getContentPane().add(dateoforder);
        dateoforder.setBounds(540, 510, 180, 30);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel7.setText("TRACKING DETAILS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 50, 420, 40);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(920, 120, 140, 20);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Time remaining for delivery");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(720, 280, 310, 40);

        status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status.setText("Delivery Status:-");
        getContentPane().add(status);
        status.setBounds(400, 570, 120, 30);
        getContentPane().add(status_label);
        status_label.setBounds(540, 570, 150, 30);
        getContentPane().add(time);
        time.setBounds(750, 360, 220, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("BACK TO BOOKING LANDING PAGE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(530, 620, 370, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/freelance-strategie-digitale_1366x768 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productidActionPerformed

    private void sendernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendernameActionPerformed

    private void dateoforderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateoforderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateoforderActionPerformed

    private void OrderidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            getData();
        } catch (ParseException ex) {
            Logger.getLogger(tracking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        //new NewJFrame();
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void receivernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receivernameActionPerformed

    private void costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

      this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tracking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Orderid;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField dateoforder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField productid;
    private javax.swing.JTextField receivername;
    private javax.swing.JTextField sendername;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status_label;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}