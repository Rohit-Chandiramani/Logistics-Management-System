/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialapp;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import static trialapp.Manager_hr.JDBC_DRIVER;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Chinnmay
 */
public class Manager_order extends javax.swing.JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/logistics";
    /**
     * Creates new form Manager_order
     */
    public Manager_order() {
        initComponents();
        display_all();
        
    }
    
    
    public void display_all()
    {
        Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         String query="select * from orders";
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         jTable_order.setModel(DbUtils.resultSetToTableModel(rs));
         
         } catch(ClassNotFoundException | SQLException e)
         {JOptionPane.showMessageDialog(null, e);}
    }
    public String fetch_cities()
    {
         Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         String cities="";
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         
         if(pune.isSelected())
            cities=add_city("'pune'",cities);
         if(mumbai.isSelected())
            cities=add_city("'mumbai'",cities);
         if(jaipur.isSelected())
            cities=add_city("'jaipur'",cities);
         if(hyderabad.isSelected())
            cities=add_city("'hyderabad'",cities);
         if(delhi.isSelected())
            cities=add_city("'delhi'",cities);
         if(kolkata.isSelected())
            cities=add_city("'kolkata'",cities);
         if(jammu.isSelected())
            cities=add_city("'jammu'",cities);
         if(bengaluru.isSelected())
            cities=add_city("'bengaluru'",cities);
         cities=cities.substring(0, cities.length()-1);
         cities="("+cities+")";
         //result.setText(cities);
        
        
        
         
        
         
         } catch(ClassNotFoundException | SQLException e)
         {JOptionPane.showMessageDialog(null, e);}
         return cities;
        
    }
    public String fetch_from_date()
    {
        
        String date = from.getDate().toString();
        String final_date=date.substring(24,28)+"-"+get_month(date)+"-"+date.substring(8,10)+" 00:00:00"; 
        return final_date;
    }
    public String fetch_to_date()
    {
        String date = to.getDate().toString();
        String final_date=date.substring(24,28)+"-"+get_month(date)+"-"+date.substring(8,10)+" 00:00:00"; 
        return final_date;
    }
    public String get_month(String full)
    {
        String month=full.substring(4,7);
        switch(month)
        {
            case "Jan":
                return "01";
            case "Feb":
                return "02";                
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";                
            case "Dec":
                return "12";                
            default:
                return "";
                
                
                
                
                
        }
        
        
        
    }
    public String add_city(String a,String cities)
    {
        String temp=cities+a+",";
        return temp;
    }
    void apply_no_of_orders()
    {
        
        Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         String query="select count(order_id),r.city from orders o,reciever r where o.reciever_number=r.number and r.city in "+fetch_cities()+" and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"') group by r.city";                                                                       
         
         
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         jTable_order.setModel(DbUtils.resultSetToTableModel(rs));
         
         } catch(ClassNotFoundException | SQLException e)
         {JOptionPane.showMessageDialog(null, e);}
        
    }
    public void apply_undelivered()
    {
        Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         String query="select o.order_id,r.city,o.date_of_order from orders o,reciever r where o.reciever_number=r.number and delivery_status='n' and r.city in "+fetch_cities()+" and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"')";          
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         jTable_order.setModel(DbUtils.resultSetToTableModel(rs));
         
         } catch(ClassNotFoundException | SQLException e)
         {JOptionPane.showMessageDialog(null, e);}
    }
    public void apply_cost()
    {
        Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         String query="select o.order_id,o.cost,r.city,o.date_of_order from orders o,reciever r where o.reciever_number=r.number and r.city in "+fetch_cities()+"and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"')" ;
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         jTable_order.setModel(DbUtils.resultSetToTableModel(rs));
         
         } catch(ClassNotFoundException | SQLException e)
         {JOptionPane.showMessageDialog(null, e);}
    }
            
    
    void select_function()
    {
        if(no_of_orders.isSelected())
            apply_no_of_orders();
        else if(undelivered.isSelected())
            apply_undelivered();
        else if(cost_profit.isSelected())
            apply_cost();
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_order = new javax.swing.JTable();
        jammu = new javax.swing.JRadioButton();
        pune = new javax.swing.JRadioButton();
        mumbai = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        hyderabad = new javax.swing.JRadioButton();
        delhi = new javax.swing.JRadioButton();
        kolkata = new javax.swing.JRadioButton();
        jaipur = new javax.swing.JRadioButton();
        bengaluru = new javax.swing.JRadioButton();
        no_of_orders = new javax.swing.JRadioButton();
        cost_profit = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        undelivered = new javax.swing.JRadioButton();
        jButton_apply = new javax.swing.JButton();
        from = new com.toedter.calendar.JDateChooser();
        to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jTable_order.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_order.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_order);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 200, 980, 400);

        jammu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jammu.setText("Jammu");
        jammu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jammuActionPerformed(evt);
            }
        });
        getContentPane().add(jammu);
        jammu.setBounds(40, 460, 133, 25);

        pune.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pune.setText("Pune");
        getContentPane().add(pune);
        pune.setBounds(40, 280, 60, 25);

        mumbai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mumbai.setText("Mumbai");
        mumbai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mumbaiActionPerformed(evt);
            }
        });
        getContentPane().add(mumbai);
        mumbai.setBounds(40, 250, 133, 25);

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton4.setText("Mumbai");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(40, 250, 133, 25);

        hyderabad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hyderabad.setText("Hyderabad");
        hyderabad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyderabadActionPerformed(evt);
            }
        });
        getContentPane().add(hyderabad);
        hyderabad.setBounds(40, 310, 133, 25);

        delhi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delhi.setText("Delhi");
        delhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delhiActionPerformed(evt);
            }
        });
        getContentPane().add(delhi);
        delhi.setBounds(40, 340, 133, 25);

        kolkata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kolkata.setText("Kolkata");
        kolkata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolkataActionPerformed(evt);
            }
        });
        getContentPane().add(kolkata);
        kolkata.setBounds(40, 370, 133, 25);

        jaipur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jaipur.setText("Jaipur");
        jaipur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaipurActionPerformed(evt);
            }
        });
        getContentPane().add(jaipur);
        jaipur.setBounds(40, 400, 133, 25);

        bengaluru.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bengaluru.setText("Bengaluru");
        bengaluru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bengaluruActionPerformed(evt);
            }
        });
        getContentPane().add(bengaluru);
        bengaluru.setBounds(40, 430, 133, 25);

        no_of_orders.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        no_of_orders.setText("Number of Orders");
        no_of_orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_of_ordersActionPerformed(evt);
            }
        });
        getContentPane().add(no_of_orders);
        no_of_orders.setBounds(180, 120, 140, 40);

        cost_profit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cost_profit.setText("Sales");
        cost_profit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cost_profitActionPerformed(evt);
            }
        });
        getContentPane().add(cost_profit);
        cost_profit.setBounds(330, 120, 120, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FROM:-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(690, 120, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(910, 120, 30, 30);

        undelivered.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        undelivered.setText("Undelivered");
        undelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undeliveredActionPerformed(evt);
            }
        });
        getContentPane().add(undelivered);
        undelivered.setBounds(470, 120, 110, 40);

        jButton_apply.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_apply.setText("APPLY");
        jButton_apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_applyActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_apply);
        jButton_apply.setBounds(1100, 110, 120, 50);

        from.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(from);
        from.setBounds(767, 120, 130, 30);

        to.setDateFormatString("yyyy MM dd");
        getContentPane().add(to);
        to.setBounds(950, 120, 120, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("SORT BY:-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 130, 130, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("CITIES:-");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 210, 120, 29);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel5.setText("ORDERS MANAGEMENT");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 10, 530, 90);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("BACK TO MANAGEMENT PORTAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(740, 630, 280, 50);

        graphButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        graphButton.setText("VISUALIZE DATA");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });
        getContentPane().add(graphButton);
        graphButton.setBounds(500, 630, 190, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trialapp/manageorderback_1366x768.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1366, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jammuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jammuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jammuActionPerformed

    private void mumbaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mumbaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mumbaiActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void hyderabadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyderabadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hyderabadActionPerformed

    private void delhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delhiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delhiActionPerformed

    private void kolkataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolkataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolkataActionPerformed

    private void jaipurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaipurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaipurActionPerformed

    private void bengaluruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bengaluruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bengaluruActionPerformed

    private void jButton_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_applyActionPerformed

        int flag=0;
        if(!(mumbai.isSelected()||pune.isSelected()||hyderabad.isSelected()||delhi.isSelected()||kolkata.isSelected()||jaipur.isSelected()||bengaluru.isSelected()||jammu.isSelected()))
        {
            flag=1;
            JOptionPane.showMessageDialog(null,"Select atleast one city");
        }
            
        if(!(no_of_orders.isSelected()||cost_profit.isSelected()||undelivered.isSelected()))
        {
            flag=1;
            JOptionPane.showMessageDialog(null,"Select ONE sort by attribute");
        }
        if(from.getDate()==null)
        {
            flag=1;
            JOptionPane.showMessageDialog(null,"Select FROM date");
        }
        if(to.getDate()==null)
        {
            flag=1;
            JOptionPane.showMessageDialog(null,"Select TO date");

        }

        
            
        if(flag==0)
        {
        select_function();
        }
        
    }//GEN-LAST:event_jButton_applyActionPerformed

    private void cost_profitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cost_profitActionPerformed
        // TODO add your handling code here:
        if(no_of_orders.isSelected())
            no_of_orders.setSelected(false);
        if(undelivered.isSelected())
            undelivered.setSelected(false);
    }//GEN-LAST:event_cost_profitActionPerformed

    private void no_of_ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_of_ordersActionPerformed
        // TODO add your handling code here:
        if(cost_profit.isSelected())
            cost_profit.setSelected(false);
        if(undelivered.isSelected())
            undelivered.setSelected(false);
        
    }//GEN-LAST:event_no_of_ordersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        managementFront obj=new managementFront();
        this.dispose();
        obj.setVisible(true);
        obj.setTitle("MANAGEMENT PORTAL");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed

        
        if(!(no_of_orders.isSelected()||cost_profit.isSelected()||undelivered.isSelected()))
            JOptionPane.showMessageDialog(null,"Select ONE Sort By attribute");
        else if(no_of_orders.isSelected())
        {
            Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         
         String query="select count(order_id),r.city from orders o,reciever r where o.reciever_number=r.number and r.city in "+fetch_cities()+" and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"') group by r.city";                                                                       
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         DefaultPieDataset piedataset=new DefaultPieDataset();
         while(rs.next())
         {
             piedataset.setValue(rs.getString("city"),new Integer(rs.getString("count(order_id)")));
         }
         JFreeChart chart=ChartFactory.createPieChart("ORDERS VS CITY", piedataset,true, true, true);
         PiePlot p=(PiePlot)chart.getPlot();
         ChartFrame frame=new ChartFrame("ORDERS VS CITY",chart);
         frame.setVisible(true);
         frame.setSize(600,600);
         
         
         ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
         File f=new File("C:\\Users\\ROHIT\\Documents\\NetBeansProjects\\trialapp\\Charts\\ORDERS VS CITY.png");
         ChartUtilities.saveChartAsPNG(f, chart, 700, 700, info);
         
         JOptionPane.showMessageDialog(null,"Chart Saved as .png");
         
         
         

            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(cost_profit.isSelected())
        {
            
             Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
          String query="select o.order_id,sum(cost),r.city,o.date_of_order from orders o,reciever r where o.reciever_number=r.number and r.city in "+fetch_cities()+"and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"') group by r.city" ;                                                                                                                                        
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         DefaultCategoryDataset bardataset=new DefaultCategoryDataset();
         while(rs.next())
         {
             bardataset.setValue(new Double(rs.getString("sum(cost)")),"SALES VS CITY",rs.getString("city"));
         }
         JFreeChart chart=ChartFactory.createBarChart("SALES VS CITY","CITY NAME","SALE VALUE (in ₹)",bardataset,PlotOrientation.VERTICAL,false,true,false);
         CategoryPlot p=chart.getCategoryPlot();
         p.setRangeGridlinePaint(Color.BLACK);
         ChartFrame frame=new ChartFrame("SALES VS CITY",chart);
         frame.setVisible(true);
         frame.setSize(600,600);
         
         ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
         File f=new File("C:\\Users\\ROHIT\\Documents\\NetBeansProjects\\trialapp\\Charts\\SALES VS CITY.png");
         ChartUtilities.saveChartAsPNG(f, chart, 700, 700, info);
         
         JOptionPane.showMessageDialog(null,"Chart Saved as .png");
            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(undelivered.isSelected())
        {
            Connection conn = null;
         PreparedStatement pst = null;
         ResultSet rs=null;
         try{
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,"root","R30101997c");
         String query="select count(order_id),r.city from orders o,reciever r where o.reciever_number=r.number and delivery_status='n' and r.city in "+fetch_cities()+" and (o.date_of_order between '"+fetch_from_date()+"'and '"+fetch_to_date()+"') group by r.city";                                                                                                         
         pst=conn.prepareStatement(query);
         rs=pst.executeQuery();
         
         DefaultCategoryDataset linedataset=new DefaultCategoryDataset();
         while(rs.next())
         {
             linedataset.setValue(new Double(rs.getString("count(order_id)")),"UNDELIVERED",rs.getString("city"));
         }
         JFreeChart chart=ChartFactory.createLineChart("UNDELIVERED ORDERS VS CITY","CITY NAME","UNDELIVERED",linedataset,PlotOrientation.VERTICAL,false,true,false);
         CategoryPlot p=chart.getCategoryPlot();
         p.setRangeGridlinePaint(Color.BLACK);
         ChartFrame frame=new ChartFrame("UNDELIVERED ORDERS VS CITY",chart);
         frame.setVisible(true);
         frame.setSize(600,600);
         
         ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
         File f=new File("C:\\Users\\ROHIT\\Documents\\NetBeansProjects\\trialapp\\Charts\\UNDELIVERED ORDERS VS CITY.png");
         ChartUtilities.saveChartAsPNG(f, chart, 700, 700, info);
         
         JOptionPane.showMessageDialog(null,"Chart Saved as .png");
            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Manager_order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_graphButtonActionPerformed

    private void undeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undeliveredActionPerformed
        // TODO add your handling code here:
        if(cost_profit.isSelected())
            cost_profit.setSelected(false);
        if(no_of_orders.isSelected())
            no_of_orders.setSelected(false);
    }//GEN-LAST:event_undeliveredActionPerformed

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
            java.util.logging.Logger.getLogger(Manager_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Manager_order obj=new Manager_order();
                obj.setVisible(true);
                obj.setTitle("ORDERS MANAGEMENT");
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bengaluru;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JRadioButton cost_profit;
    private javax.swing.JRadioButton delhi;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JButton graphButton;
    private javax.swing.JRadioButton hyderabad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_apply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_order;
    private javax.swing.JRadioButton jaipur;
    private javax.swing.JRadioButton jammu;
    private javax.swing.JRadioButton kolkata;
    private javax.swing.JRadioButton mumbai;
    private javax.swing.JRadioButton no_of_orders;
    private javax.swing.JRadioButton pune;
    private com.toedter.calendar.JDateChooser to;
    private javax.swing.JRadioButton undelivered;
    // End of variables declaration//GEN-END:variables
}
