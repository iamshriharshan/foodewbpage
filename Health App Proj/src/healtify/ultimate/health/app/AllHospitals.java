
package healtify.ultimate.health.app;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;


public class AllHospitals extends JFrame implements ActionListener {
    
    JTable table;
    JScrollPane js;
    JButton select, back;
    Choice hos;
    public static String hosname ;    
    
    AllHospitals(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(450, 30, 800, 750);
        
        JLabel head = new JLabel("All Hopitals Available to You");
        head.setBounds(200, 30, 600, 30);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        table = new JTable();
        table.setBounds(5, 100, 775, 530);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
        
        js = new JScrollPane(table);      
        js.setBounds(5, 100, 775, 530);
        js.setBackground(Color.white);
        add(js);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select Hospital_Name, Contact, Email, Address, Status  from Hospital;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setAutoCreateRowSorter(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        hos = new Choice();
        hos.setBounds(10, 640, 650, 30);
        add(hos);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Hospital where Status = 'Available' ");
            while(rs.next()){
                hos.add(rs.getString("Hospital_Name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        select = new JButton();
        JLabel c = new JLabel(" Select Hospital");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.black);
        select.add(c);
        select.setBounds(400, 670, 180, 30);
        select.setBackground(Color.green);
        select.setForeground(Color.white);
        add(select);
        select.addActionListener(this);
        
        back = new JButton();
        JLabel b = new JLabel("   Back");
        b.setBounds(600, 180,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        back.add(b);
        back.setBounds(600, 670, 130, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==  back ){
            setVisible(false);
            
        }
        
        else if(ae.getSource() == select){
            hosname = hos.getSelectedItem();
            setVisible(false);
            new AppointmentForm();
            
        }
    }
    
    public static void main (String args[]){
        new AllHospitals();
    }
}
