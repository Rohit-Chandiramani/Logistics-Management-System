package trialapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//package logy;

/**
 *
 * @author Chinnmay
 */
public class Sender extends javax.swing.JFrame {

    /** Creates new form Sender */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
         static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
         ArrayList<String>sender_details=new ArrayList<String>();
         ArrayList<String>reciever_details=new ArrayList<String>();
    public Sender() {
        initComponents();
    }
    public int return_index_of_city(String s)
    {
        switch (s)
        {
            case "Pune":
                return 0;
            case "Mumbai":
                return 1;
            case "Hyderabad":
                return 2;
            case "Delhi":
                return 3;
            case "Kolkata":
                return 4;
            case "Jaipur":
                return 5;
            case "Bengaluru":
                return 6;
            case "Jammu":
              return 7;                 
        }
        return -1;

    }

    public void fetch_sender()
    {
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
        String name=textName.getText();
        String no=sender_number.getText();
        String email=textEmail.getText();
        String city=sender_city.getSelectedItem().toString();
        String pin=textPincode.getText();
        int loyalty=0;
        String query="select * from sender where number='"+sender_number.getText()+"'";
        rs=stmt.executeQuery(query);
        if(rs.next())
            return;
        
        query="INSERT INTO sender VALUES("+"'"+name+"'" +","+"'"+no+"'"+","+"'"+email+"'"+","+"'"+city+"'"+","+"'"+pin+"'"+","+loyalty+")";
        if(!"".equals(name))  
        {
            stmt.executeUpdate(query);
             
        }
        else
            error.setText("PLEASE FILL ALL FIELDS WITH *");
            
         } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void fetch_reciever()
    {
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         String a=name.getText();
        String b=contact.getText();
        String c=emailId.getText();
        String d=reciever_city.getSelectedItem().toString();
        String e=pincode.getText();
        String f=address.getText();
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="select * from reciever where number='"+contact.getText()+"'";
        rs=stmt.executeQuery(query);
        if(rs.next())
            return;
        query="INSERT INTO reciever VALUES"+"("+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+d+"'"+","+"'"+e+"'"+","+"'"+f+"'"+")";
          stmt.executeUpdate(query);
         } catch (SQLException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    public void create_product_id()
    {
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="INSERT INTO product VALUES"+"("+"null"+","+"null"+","+"null"+","+"null"+","+"null"+")";
          stmt.executeUpdate(query);
         } catch (SQLException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public int fetch_product_id()
    {
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
        int maxi = 0; 
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="select max(product_id) from product";
         rs =stmt.executeQuery(query);
         while(rs.next())
         {
             String s = rs.getString("max(product_id)");
             maxi=Integer.parseInt(s);
             
         }
         
         
         } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        System.out.println(maxi);
        return maxi;
        
    }
    public void update_order_id()
    {
        int product_id=fetch_product_id();
        String reciver_no=contact.getText();
        String sender_no=sender_number.getText();
        int cost=1;
        char order_type;
        if(fast.isSelected())
            order_type='f';
        else
            order_type='n';
        char delivery_status='n';
        float delivery_time=0;         ///////////////to-do
        int discount=0;
        
        
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String get_time="select "+sender_city.getSelectedItem().toString()+" from time_graph where city_name='"+reciever_city.getSelectedItem().toString()+"'";
         rs=stmt.executeQuery(get_time);
         while(rs.next())
         {
             
             String s = rs.getString(sender_city.getSelectedItem().toString());
             delivery_time=Float.parseFloat(s);
             
         }
         String query="INSERT INTO orders VALUES"+"("+"null"+",'"+sender_no+"','"+reciver_no+"',"+cost+",'"+order_type+"','"+delivery_status+"',"+delivery_time+","+discount+","+product_id+",now())";                                                                   
         stmt.executeUpdate(query);
         } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sender_number = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textPincode = new javax.swing.JTextField();
        search_reciever = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        emailId = new javax.swing.JTextField();
        pincode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        normal = new javax.swing.JRadioButton();
        fast = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        search_sender = new javax.swing.JButton();
        sender_city = new javax.swing.JComboBox<>();
        reciever_city = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SENDER DETAILS");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 20, 430, 40);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setText("Contact:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 170, 150, 47);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setText("E-mail:-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 130, 47);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setText("City:-");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 370, 90, 47);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel5.setText("Pincode:-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 450, 150, 47);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel6.setText("Name:-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 90, 120, 47);

        sender_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sender_numberActionPerformed(evt);
            }
        });
        sender_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sender_numberKeyTyped(evt);
            }
        });
        getContentPane().add(sender_number);
        sender_number.setBounds(190, 180, 290, 40);

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        getContentPane().add(textEmail);
        textEmail.setBounds(190, 280, 290, 40);

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });
        textName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNameKeyTyped(evt);
            }
        });
        getContentPane().add(textName);
        textName.setBounds(190, 90, 290, 40);

        textPincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPincodeKeyTyped(evt);
            }
        });
        getContentPane().add(textPincode);
        textPincode.setBounds(200, 460, 290, 40);

        search_reciever.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        search_reciever.setText("Search");
        search_reciever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_recieverActionPerformed(evt);
            }
        });
        getContentPane().add(search_reciever);
        search_reciever.setBounds(1180, 180, 110, 40);

        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("      ");
        getContentPane().add(error);
        error.setBounds(140, 450, 290, 14);

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(870, 90, 290, 40);

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactKeyTyped(evt);
            }
        });
        getContentPane().add(contact);
        contact.setBounds(870, 180, 290, 40);

        emailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIdActionPerformed(evt);
            }
        });
        getContentPane().add(emailId);
        emailId.setBounds(870, 280, 290, 40);

        pincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pincodeKeyTyped(evt);
            }
        });
        getContentPane().add(pincode);
        pincode.setBounds(880, 460, 280, 40);

        address.setColumns(20);
        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(880, 530, 350, 80);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel7.setText("RECEIVER DETAILS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(790, 10, 410, 60);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText(" Name:-");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(700, 90, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setText(" Contact:-");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(700, 180, 160, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setText(" E-mail:-");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(700, 280, 140, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setText(" City:-");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(720, 370, 130, 50);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setText(" Pincode:-");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(710, 460, 170, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setText(" Address:-");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(710, 540, 170, 44);

        normal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        normal.setText("Normal");
        normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalActionPerformed(evt);
            }
        });
        getContentPane().add(normal);
        normal.setBounds(370, 580, 133, 37);

        fast.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fast.setText("Fast");
        fast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastActionPerformed(evt);
            }
        });
        getContentPane().add(fast);
        fast.setBounds(250, 580, 80, 37);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setText("Order Type:-");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 570, 210, 50);

        next.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        next.setText("NEXT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(1070, 640, 180, 50);

        search_sender.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        search_sender.setText("Search");
        search_sender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_senderActionPerformed(evt);
            }
        });
        getContentPane().add(search_sender);
        search_sender.setBounds(510, 180, 110, 40);

        sender_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sender_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Mumbai", "Hyderabad", "Delhi", "Kolkata", "Jaipur", "Bengaluru", "Jammu" }));
        sender_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sender_cityActionPerformed(evt);
            }
        });
        getContentPane().add(sender_city);
        sender_city.setBounds(210, 370, 260, 40);

        reciever_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reciever_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Mumbai", "Hyderabad", "Delhi", "Kolkata", "Jaipur", "Bengaluru", "Jammu" }));
        reciever_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciever_cityActionPerformed(evt);
            }
        });
        getContentPane().add(reciever_city);
        reciever_city.setBounds(890, 380, 260, 40);

        backButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(800, 640, 180, 50);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/Foreign-Parcel_1366x768.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 1370, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void search_recieverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_recieverActionPerformed

         Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="select * from reciever where number='"+contact.getText()+"'";
         rs=stmt.executeQuery(query);
         if(rs.next())
         {
            
             for (int i = 1; i <=6; i++) 
                reciever_details.add(rs.getString(i));
             Iterator itr = reciever_details.iterator();
        name.setText(itr.next().toString());
        contact.setText(itr.next().toString());
        emailId.setText(itr.next().toString());
        //itr.next();
//sender_city.setSelectedIndex(itr.next().toString());
        String temp=itr.next().toString();
        reciever_city.setSelectedIndex(return_index_of_city(temp));
        pincode.setText(itr.next().toString());
        address.setText(itr.next().toString());
             
         }
         else
         {
             JOptionPane.showMessageDialog(null, "Reciever Does not Exist!");
             
         }
         
         
         } catch (SQLException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_search_recieverActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalActionPerformed
        if(fast.isSelected())
            fast.setSelected(false);
    }//GEN-LAST:event_normalActionPerformed

    private void fastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastActionPerformed
        if(normal.isSelected())
            normal.setSelected(false);
    }//GEN-LAST:event_fastActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        int flag=0;
        
        if(textName.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Sender Name");
        }
        if(name.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Receiver Name");
        }
        if(sender_number.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Sender Number");
        }
        if(contact.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Receiver Number");
        }
        if(textEmail.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Sender E-mail");
        }
        if(emailId.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Receiver E-mail");
        }
        if(textPincode.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Sender Pincode");
        }
        if(pincode.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Receiver Pincode");
        }
        if(address.getText().equals(""))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Enter Receiver Address");
        }
        
        if(!(fast.isSelected()||normal.isSelected()))
        {
            flag=1;
            JOptionPane.showMessageDialog(null, "Select ONE delivery type");  
        }
        
        if(flag==0)
        {
        fetch_sender();
         fetch_reciever();
         
         create_product_id();
         update_order_id();
         
         
         this.dispose();
         productFrame obj=new productFrame();
         obj.setVisible(true);
         obj.setTitle("PRODUCT DETAILS");
        }
    }//GEN-LAST:event_nextActionPerformed

    private void search_senderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_senderActionPerformed
        
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="select * from sender where number='"+sender_number.getText()+"'";
         rs=stmt.executeQuery(query);
         if(rs.next())
         {
            
             for (int i = 1; i <=5; i++) 
                sender_details.add(rs.getString(i));
             Iterator itr = sender_details.iterator();
            textName.setText(itr.next().toString());
            sender_number.setText(itr.next().toString());
            textEmail.setText(itr.next().toString());
        //    itr.next();
//sender_city.setSelectedIndex(itr.next().toString());
String temp=itr.next().toString();
        sender_city.setSelectedIndex(return_index_of_city(temp));
            textPincode.setText(itr.next().toString());
             
         }
         
         else{
             JOptionPane.showMessageDialog(null, "Sender does not exist!");
         }
         
         
         } catch (SQLException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
         
    }//GEN-LAST:event_search_senderActionPerformed

    private void sender_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sender_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sender_numberActionPerformed

    private void emailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIdActionPerformed

    private void reciever_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciever_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reciever_cityActionPerformed

    private void sender_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sender_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sender_cityActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        this.dispose();
        bookingFirst obj=new bookingFirst();
        obj.setTitle("BOOKING LANDING PAGE");
        obj.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped

        char ch=evt.getKeyChar();
        if(!Character.isLetter(ch))
            evt.consume();
    }//GEN-LAST:event_nameKeyTyped

    private void textNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNameKeyTyped
        // TODO add your handling code here:
        char ch=evt.getKeyChar();
        if(!Character.isLetter(ch))
            evt.consume();
    }//GEN-LAST:event_textNameKeyTyped

    private void sender_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sender_numberKeyTyped
        char ch=evt.getKeyChar();
        if(!Character.isDigit(ch))
            evt.consume();
    }//GEN-LAST:event_sender_numberKeyTyped

    private void contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyTyped
        // TODO add your handling code here:
        char ch=evt.getKeyChar();
        if(!Character.isDigit(ch))
            evt.consume();
    }//GEN-LAST:event_contactKeyTyped

    private void textPincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPincodeKeyTyped
        // TODO add your handling code here:
        char ch=evt.getKeyChar();
        if(!Character.isDigit(ch))
            evt.consume();
    }//GEN-LAST:event_textPincodeKeyTyped

    private void pincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pincodeKeyTyped
        // TODO add your handling code here:
        char ch=evt.getKeyChar();
        if(!Character.isDigit(ch))
            evt.consume();
    }//GEN-LAST:event_pincodeKeyTyped

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
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sender obj=new Sender();
                obj.setVisible(true);
                obj.setTitle("CUSTOMER DETAILS");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField emailId;
    private javax.swing.JLabel error;
    private javax.swing.JRadioButton fast;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton next;
    private javax.swing.JRadioButton normal;
    private javax.swing.JTextField pincode;
    private javax.swing.JComboBox<String> reciever_city;
    private javax.swing.JButton search_reciever;
    private javax.swing.JButton search_sender;
    private javax.swing.JComboBox<String> sender_city;
    private javax.swing.JTextField sender_number;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPincode;
    // End of variables declaration//GEN-END:variables

}
