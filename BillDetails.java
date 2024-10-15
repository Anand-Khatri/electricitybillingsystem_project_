package electricity_bill;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    JTable t1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        setSize(700,650);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t1 = new JTable(y,x);
        
        try{
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebill", "root", "Khatri@1234");
                st = conn.createStatement();
            String s1 = "select * from bill where meter = " + meter;
            
            rs = st.executeQuery(s1);
             t1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
    }
    
    public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }
    
}
