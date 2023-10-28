
package healtify.ultimate.health.app;

import javax.swing.*;

import java.awt.*;




import java.awt.event.*;
import java.sql.ResultSet;

public class DashboardH extends JFrame implements ActionListener {
    JButton appointment, addmedi, chemist,  panic ,govt;
    String username = LoginH.usernh;
    public static String use = "";
    
    
    DashboardH(){
                
     try{
                Conn c = new Conn();
                String query = "select Hospital_Name from Hospital where Hospital_ID = '"+username+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    use = (rs.getString("Hospital_Name"));
                    
                }
   }catch(Exception e){
                e.printStackTrace();
            }
        
        setLayout(null);
        
        setBounds(-7,0,1920,1080);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-7,35,1920,1080);
        add(image);
        
        

        
        JLabel head = new JLabel ("Hello " + use + " welcome to Healthify App");
        head.setBounds(30, 50,1800, 70);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Tahoma", Font.BOLD, 30));
        image.add(head);  
         
        JLabel appoint = new JLabel ("Appointments Pending");
        appoint.setBounds(50, 180, 500, 50);
        appoint.setFont(new Font("Arial", Font.PLAIN,40));
        appoint.setForeground(Color.WHITE);
        image.add(appoint);
        
        
        appointment = new JButton();
        JLabel c = new JLabel("Click Here");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,30));
        c.setForeground(Color.WHITE);
        appointment.add(c);
        appointment.setBounds(600, 180, 180, 50);
        appointment.setBackground(Color.black);
        appointment.setForeground(Color.white);
        image.add(appointment);
        appointment.addActionListener(this);
        
        JLabel addmed = new JLabel ("Chnage Status");
        addmed.setBounds(50, 280, 500, 50);
        addmed.setFont(new Font("Arial", Font.PLAIN,40));
        addmed.setForeground(Color.WHITE);
        image.add(addmed);
        
        addmedi = new JButton();
        JLabel a = new JLabel("Change");
        a.setBounds(600, 280,200, 50);
        a.setFont(new Font("Arial", Font.PLAIN,30));
        a.setForeground(Color.WHITE);
        addmedi.add(a);
        addmedi.setBounds(600, 280, 180, 50);
        addmedi.setBackground(Color.black);
        addmedi.setForeground(Color.white);
        image.add(addmedi);
        addmedi.addActionListener(this);
        
        JLabel chem= new JLabel ("Update Hospital Info");
        chem.setBounds(50, 380, 550, 50);
        chem.setFont(new Font("Arial", Font.PLAIN,40));
        chem.setForeground(Color.WHITE);
        image.add(chem);
        
        chemist = new JButton();
        JLabel b = new JLabel("Update");
        b.setBounds(600, 380,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,30));
        b.setForeground(Color.WHITE);
        chemist.add(b);
        chemist.setBounds(600, 380, 180, 50);
        chemist.setBackground(Color.black);
        chemist.setForeground(Color.white);
        image.add(chemist);
        chemist.addActionListener(this);
        
        
        
        
        panic = new JButton();
        JLabel p = new JLabel("Logout");
        p.setLayout(null);
        p.setBounds(250, 680,200, 50);
        p.setFont(new Font("Arial", Font.PLAIN,30));
        p.setForeground(Color.WHITE);
        panic.add(p);
        panic.setBounds(200, 680, 130, 50);
        panic.setBackground(Color.red);
        panic.setForeground(Color.WHITE);
        image.add(panic);
        panic.addActionListener(this);
        
        JLabel infos = new JLabel ("Update Appointment Status");
        infos.setBounds(50, 480, 500, 50);
        infos.setFont(new Font("Arial", Font.PLAIN,40));
        infos.setForeground(Color.WHITE);
        image.add(infos);
        
        govt = new JButton();
        JLabel g = new JLabel("Update Now");
        g.setBounds(600, 480,200, 50);
        g.setFont(new Font("Arial", Font.PLAIN,30));
        g.setForeground(Color.WHITE);
        govt.add(g);
        govt.setBounds(600, 480, 180, 50);
        govt.setBackground(Color.black);
        govt.setForeground(Color.white);
        image.add(govt);
        govt.addActionListener(this);
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == appointment ){
            new AllAppointments();
        }
        
        else if(ae.getSource() == addmedi ){
            new ChangeHStatus();
        }
        
        else if(ae.getSource() == chemist ){
            new Chemistt();
        }
        
        
        else if(ae.getSource() == panic ){
            setVisible(false);
            new Login();
        }

        
    }
    
    public static void main(String args[]){
        new DashboardH();
}
}    
