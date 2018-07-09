/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialapp;

/**
 *
 * @author ROHIT
 */
import java.awt.Component;
import javax.mail.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class mainFrame extends javax.swing.JFrame {
    
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
   ArrayList<String>userList=new ArrayList<String>();
   ArrayList<String>passList=new ArrayList<String>();
   ArrayList<String>cityList=new ArrayList<String>();
   ArrayList<String>nameList=new ArrayList<String>();
   ArrayList<String>numberList=new ArrayList<String>();
   

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        
        Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="drop table if exists booking";
         stmt.executeUpdate(query);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        passLabel = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        userType = new javax.swing.JLabel();
        typeBox = new javax.swing.JComboBox<>();
        messageText = new javax.swing.JLabel();
        userErrorLabel = new javax.swing.JLabel();
        passErrorLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        forgotButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRONT PAGE");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(61, 13, 22));
        setForeground(getBackground());
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        passLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("PASSWORD:-");
        getContentPane().add(passLabel);
        passLabel.setBounds(460, 340, 110, 40);
        passLabel.getAccessibleContext().setAccessibleName("userLabel");

        userText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userTextFocusLost(evt);
            }
        });
        userText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextActionPerformed(evt);
            }
        });
        getContentPane().add(userText);
        userText.setBounds(690, 270, 210, 40);

        userLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel1.setText("USERNAME:-");
        getContentPane().add(userLabel1);
        userLabel1.setBounds(460, 270, 110, 40);

        passText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passTextFocusLost(evt);
            }
        });
        passText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextActionPerformed(evt);
            }
        });
        getContentPane().add(passText);
        passText.setBounds(690, 340, 210, 40);

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(750, 470, 110, 50);

        userType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userType.setText("SELECT TYPE OF USER:- ");
        getContentPane().add(userType);
        userType.setBounds(460, 200, 180, 50);

        typeBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "BOOKING", "MANAGEMENT", "DELIVERY" }));
        typeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeBoxActionPerformed(evt);
            }
        });
        getContentPane().add(typeBox);
        typeBox.setBounds(710, 210, 160, 30);

        messageText.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        messageText.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(messageText);
        messageText.setBounds(960, 470, 210, 50);

        userErrorLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        userErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(userErrorLabel);
        userErrorLabel.setBounds(940, 270, 170, 40);

        passErrorLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        passErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(passErrorLabel);
        passErrorLabel.setBounds(940, 340, 170, 40);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 90, 250, 80);

        forgotButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forgotButton.setText("FORGOT PASSWORD");
        forgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotButtonActionPerformed(evt);
            }
        });
        getContentPane().add(forgotButton);
        forgotButton.setBounds(473, 470, 200, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/backfirst_1366x768.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTextActionPerformed

    public void getData(char c)
    {
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String query="SELECT *FROM hr where type='"+c+"'";
          rs=stmt.executeQuery(query);
         
          userList.clear();
          passList.clear();
          nameList.clear();
          numberList.clear();
          cityList.clear();
         while(rs.next())
         {
             
             userList.add(rs.getString("username"));
             passList.add(rs.getString("password"));
             nameList.add(rs.getString("name"));
             numberList.add(rs.getString("number"));
             cityList.add(rs.getString("city"));
             
             
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
    
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        String username=userText.getText();
        String password=String.valueOf(passText.getPassword());
        String type=(String) typeBox.getSelectedItem();
        
        int flag=0;
        getData(type.charAt(0));
        System.out.println(userList.size());
        
        for(int i=0;i<userList.size();i++)
        {
            System.out.println(userList.get(i));
        }
        
        for(int i=0,j=0;i<userList.size()&&j<passList.size();i++,j++)
        {
            if(userList.get(i).equals(username))
            {
                if(passList.get(i).equals(password))
                {
                    flag=1;
                    if(type.equals("BOOKING"))
                    {
                        Connection conn = null;
                Statement stmt = null;
                ResultSet rs=null;
                try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
                stmt=conn.createStatement();
                
                String query;
                query="Create table booking (name varchar(15),username varchar(15),number varchar(15),city varchar(15))";
                stmt.executeUpdate(query);
                query="Insert into booking values('"+nameList.get(i)+"','"+username+"','"+numberList.get(i)+"','"+cityList.get(i)+"')";
                stmt.executeUpdate(query);
                }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                 this.dispose();
                bookingFirst d=new bookingFirst();
                d.setVisible(true);
                d.setTitle("BOOKING LANDING PAGE");
                break;
                    }
                    else if(type.equals("MANAGEMENT"))
                    {
                        this.dispose();
                        managementFront obj=new managementFront();
                        obj.setVisible(true);
                        obj.setTitle("MANAGEMENT LANDING PAGE");
                        break;
                    }
                    else if(type.equals("DELIVERY"))
                    {
                        Connection conn = null;
                Statement stmt = null;
                ResultSet rs=null;
                try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
                stmt=conn.createStatement();
                
                String query;
                query="Create table delivery (name varchar(15),username varchar(15),number varchar(15),city varchar(15))";
                stmt.executeUpdate(query);
                query="Insert into delivery values('"+nameList.get(i)+"','"+username+"','"+numberList.get(i)+"','"+cityList.get(i)+"')";
                stmt.executeUpdate(query);
                }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                 this.dispose();
                Delivery d=new Delivery();
                d.setVisible(true);
                d.setTitle("DELIVERY PAGE");
                    }
                    
                }
                else
                {
                    flag=1;
                     messageText.setText("Password does not match!");

                }
            }  
            
        }
        
        if(flag==0)
            messageText.setText("User does not exist!");         
        
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextActionPerformed

    public int send_email( String reciever_email)
        {
            Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         String reciver_password="";
              
         try{
         
             
             Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         
         String query="select * from hr where email='"+reciever_email+"'";
        rs=stmt.executeQuery(query);
        if(!rs.next())
            return 1;
        reciver_password=rs.getString("password");
                
         } catch (SQLException | ClassNotFoundException ex) {}
             
         //System.out.println("check5");
            
            final String sender_username = "thelogisticsteam@gmail.com"; // enter your mail id
		final String password = "logistics";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session;
         session = Session.getInstance(props,
                 new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(sender_username, password);
                     }
                 });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender_username)); // same email id
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(reciever_email));// whome u have to send mails that person id
			message.setSubject("Confidential::Sending Of Password");
			message.setText("Dear, User"
				+ "\n\n your password is ::->>"+reciver_password);

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        return 0;
        }

    
    
    
    
    private void typeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeBoxActionPerformed

        String type=(String) typeBox.getSelectedItem();
        
        if(type.equals("BOOKING"))
        {
            Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String b;
                b = "'B'";
         String query="SELECT *FROM hr WHERE type="+b;
          rs=stmt.executeQuery(query);
         
         while(rs.next())
         {
             
             userList.add(rs.getString("username"));
             passList.add(rs.getString("password"));
         }

        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
      }
         }
        }
        
        else if(type.equals("MANAGEMENT"))
        {
            
            Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String m;
                m = "'M'";
         String query="SELECT *FROM hr WHERE type="+m;
          rs=stmt.executeQuery(query);
         
         while(rs.next())
         {
             
             userList.add(rs.getString("username"));
             passList.add(rs.getString("password"));
         }

        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
      }
         }
        }
        
        
        else if(type.equals("DELIVERY"))
        {
            Connection conn = null;
         Statement stmt = null;
         ResultSet rs=null;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         stmt=conn.createStatement();
         String d;
                d = "'D'";
         String query="SELECT *FROM hr WHERE type="+d;
          rs=stmt.executeQuery(query);
         
         while(rs.next())
         {
             
             userList.add(rs.getString("username"));
             passList.add(rs.getString("password"));
             cityList.add(rs.getString("city"));
             nameList.add(rs.getString("name"));
             numberList.add(rs.getString("number"));
         }
        

        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
      }
         }
        
        }
            
    }//GEN-LAST:event_typeBoxActionPerformed

    private void userTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFocusLost

        if(userText.getText().equals(""))
        {
            userErrorLabel.setText("*Enter Username");
            
        }
        else
        {
            userErrorLabel.setText("");
            
        }
        
    }//GEN-LAST:event_userTextFocusLost

    private void userTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFocusGained

    }//GEN-LAST:event_userTextFocusGained

    private void passTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTextFocusLost
        // TODO add your handling code here:
        
        
        if(String.valueOf(passText.getPassword()).equals(""))
        {
            passErrorLabel.setText("*Enter Password");
            
        }
        else
        {
            passErrorLabel.setText("");
            
        }
    }//GEN-LAST:event_passTextFocusLost

    private void forgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotButtonActionPerformed

      String forgotemail=JOptionPane.showInputDialog("Enter your E-mail id to send password");
      int res=send_email(forgotemail);
      
      if(res==0)
          JOptionPane.showMessageDialog(null,"Your password has been sent to your E-mail id");
      else if(res==1)
          JOptionPane.showMessageDialog(null,"ERROR OCCOURED IN SENDING E-MAIL");
    }//GEN-LAST:event_forgotButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                 mainFrame mf=new mainFrame();
                 mf.setTitle("FRONT PAGE");
                 mf.setVisible(true);
                 
            }
       });
    }
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel messageText;
    private javax.swing.JLabel passErrorLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passText;
    private javax.swing.JComboBox<String> typeBox;
    private javax.swing.JLabel userErrorLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JTextField userText;
    private javax.swing.JLabel userType;
    // End of variables declaration//GEN-END:variables
}