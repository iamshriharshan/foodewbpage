
package healtify.ultimate.health.app;

import javax.swing.*;

import java.awt.*;

import com.toedter.calendar.JDateChooser;


import java.awt.event.*;
import java.sql.ResultSet;

public class AppointmentForm extends JFrame implements ActionListener {
    
    JButton fetch, submit;
    JTextField name, age, disease, email, contact;
    JLabel hname, hcontact;
    JComboBox time;
    JDateChooser prevdate;
    String selectedname = AllHospitals.hosname;
    String username = LoginU.usern;
    
    AppointmentForm(){
        
        setLayout(null);
        
        setBounds(50, 50, 1450, 700);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/appbookjpeg.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(700,70,600,500);
        add(image);
        
        JLabel head = new JLabel ("Appointment Application");
        head.setBounds(450, 50, 1400, 50 );
        head.setFont(new Font("Tahoma", Font.BOLD, 46));
        add(head);
        
        JLabel ptname = new JLabel ("Patient Name :");
        ptname.setFont(new Font("Arial", Font.PLAIN, 25));
        ptname.setBounds(60, 150, 200, 30);
        add(ptname);
        
        name = new JTextField("");
        name.setBounds(280, 150, 400, 30);
        add(name);
        
        JLabel ptage = new JLabel ("Patient Age :");
        ptage.setFont(new Font("Arial", Font.PLAIN, 25));
        ptage.setBounds(60, 200, 200, 30);
        add(ptage);
        
        age = new JTextField("");
        age.setBounds(280, 200, 400, 30);
        add(age);
        
        JLabel ptprob = new JLabel ("Patient Disease :");
        ptprob.setFont(new Font("Arial", Font.PLAIN, 25));
        ptprob.setBounds(60, 250, 200, 30);
        add(ptprob);
        
        disease = new JTextField("");
        disease.setBounds(280, 250, 400, 30);
        add(disease);
        
        JLabel ptemail = new JLabel ("Patient Email :");
        ptemail.setFont(new Font("Arial", Font.PLAIN, 25));
        ptemail.setBounds(60, 300, 200, 30);
        add(ptemail);
        
        email = new JTextField("");
        email.setBounds(280, 300, 400, 30);
        add(email);
        
        JLabel ptcon = new JLabel ("Patient Contact :");
        ptcon.setFont(new Font("Arial", Font.PLAIN, 25));
        ptcon.setBounds(60, 350, 200, 30);
        add(ptcon);
        
        contact = new JTextField("");
        contact.setBounds(280, 350, 400, 30);
        add(contact);
        
        JLabel ptdate = new JLabel ("Preferred Date :");
        ptdate.setFont(new Font("Arial", Font.PLAIN, 25));
        ptdate.setBounds(60, 400, 200, 30);
        add(ptdate);
        
        prevdate = new JDateChooser();
        prevdate.setBounds(280, 400, 400, 30);
        add(prevdate);
        
        
        JLabel pttime = new JLabel ("Preferred Time :");
        pttime.setFont(new Font("Arial", Font.PLAIN, 25));
        pttime.setBounds(60, 450, 200, 30);
        add(pttime);
        
        String id [] = {" 9.00 AM to 11.00 AM ", "12.00 PM to 2.00 PM", "3.00 PM to 5.00 PM " };
        time = new JComboBox(id);
        time.setBounds(280, 450, 400, 30);
        time.setBackground(Color.white);
        add(time);
        
        JLabel pthn = new JLabel ("Hospital Name :");
        pthn.setFont(new Font("Arial", Font.PLAIN, 25));
        pthn.setBounds(60, 500, 200, 30);
        add(pthn);
        
        hname = new JLabel("");
        hname.setBounds(280, 500, 200, 30);
        add(hname);
        
        JLabel pthco = new JLabel ("Hospital Contact :");
        pthco.setFont(new Font("Arial", Font.PLAIN, 25));
        pthco.setBounds(60, 550, 200, 30);
        add(pthco);
        
        hcontact = new JLabel("");
        hcontact.setBounds(280, 550, 200, 30);
        add(hcontact);
        
        fetch = new JButton();
        JLabel a = new JLabel("Check your Info");
        a.setBounds(600, 680,200, 50);
        a.setFont(new Font("Arial", Font.PLAIN,20));
        a.setForeground(Color.WHITE);
        fetch.add(a);
        fetch.setBounds(900, 580, 180, 50);
        fetch.setBackground(Color.black);
        fetch.setForeground(Color.white);
        add(fetch);
        fetch.addActionListener(this);
        
        submit = new JButton();
        JLabel b = new JLabel("Book Now");
        b.setBounds(1150, 580,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,30));
        b.setForeground(Color.WHITE);
        submit.add(b);
        submit.setBounds(1150, 580, 180, 50);
        submit.setBackground(Color.red);
        submit.setForeground(Color.white);
        add(submit);
        submit.addActionListener(this);
        
   
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetch){
                try{
                Conn c = new Conn();
                String query = "select Name, Age, Email, Contact from user where Name = '"+username+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    name.setText(rs.getString("Name"));
                    age.setText(rs.getString("Age"));
                    email.setText(rs.getString("Email"));
                    contact.setText(rs.getString("Contact"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select Hospital_Name, Contact from Hospital where Hospital_Name = '"+selectedname+"'");
                while(rs2.next()){
                    hname.setText(rs2.getString("Hospital_Name"));
                    hcontact.setText(rs2.getString("Contact"));
                    
                }
            } 
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == submit){

            String tname = name.getText();
            if(tname.equals("")){
                JOptionPane.showMessageDialog(null, "The name cannot be empty");
                return;
            }

            String tage = age.getText();
            if(tage.equals("")){
                JOptionPane.showMessageDialog(null, "The age cannot be empty");
                return;
            }
            
            String date = prevdate.getDateFormatString();
            if(date.equals("")){
            JOptionPane.showMessageDialog(null, "The Choose the date");
                return;
            }

            String phone = contact.getText();
            int x = 0;
            for(int i = 0; i<phone.length();i++){
                if(Character.isLetter(phone.charAt(i))|| !Character.isDigit(phone.charAt(i)) || Character.isWhitespace(phone.charAt(i))){
                    x++;
                }
            }
            if(phone.length()<10 || x>0 || phone.length()>10){
                JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                return;
            }


            String temail = email.getText();
            if((temail.contains("@")&& temail.contains(".com") && !temail.equals("")) ||
                    temail.contains("@")&& temail.contains(".in") && !temail.equals("")){
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Email");
                return;
            }

            String hphone = hcontact.getText();
            if(hphone.equals("")){
                JOptionPane.showMessageDialog(null, "Hospital Contact Cannot be empty");
                return;
            }
            
            String htname = selectedname;
            if(htname.equals("")){
                JOptionPane.showMessageDialog(null, "Hospital Name Cnnot be Empty");
                return;
            }

            String tdisease = disease.getText();
            if (tdisease.equals("")){
                JOptionPane.showMessageDialog(null, "Disease Can not be Empty");
            }
            
            String t = (String)time.getSelectedItem();
            
            try{
            Conn c = new Conn();
            String query = "insert into Appointments values ('"+tname+"','"+tage+"','"+phone+"','"+temail+"','"+tdisease+"','"+htname+"','"+hphone+"','"+date+"','"+t+"')";
            c.s.executeUpdate(query); 
            JOptionPane.showMessageDialog(null, "Appointment booked succesfully");
            JOptionPane.showMessageDialog(null, "Thank You");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }



        }
    
    
    }
    
    public static void main(String args[]){
        new AppointmentForm();
    }
}
