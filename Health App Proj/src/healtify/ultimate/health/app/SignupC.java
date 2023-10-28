
package healtify.ultimate.health.app;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class SignupC extends JFrame  implements ActionListener {
    JTextField tfname, tfc, tfe, ifadd, tfg, tfec;
    JPasswordField tfp, tfcp;
    JButton signup, back;
    SignupC(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(190, 60, 1200, 700);
        
        JLabel head = new JLabel("Register to Healthify");
        head.setBounds(20, 30, 500,35);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        JLabel ho = new JLabel("Chemist SignUp");
        ho.setBounds(20, 80, 500,25);
        ho.setFont(new Font("Arial", Font.BOLD,20));
        add(ho);
        
        JLabel lname = new JLabel ("Name :");
        lname.setBounds(20,150,200,30);
        lname.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 300, 30);
        add(tfname);
        
        
        
        JLabel lcon = new JLabel ("Contact :");
        lcon.setBounds(20,220,200,30);
        lcon.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lcon);
        
        tfc = new JTextField();
        tfc.setBounds(200, 220, 300, 30);
        add(tfc);
        
        JLabel lem = new JLabel ("Email id :");
        lem.setBounds(20,280,200,30);
        lem.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lem);
        
        tfe = new JTextField();
        tfe.setBounds(200, 280, 300, 30);
        add(tfe);
        
        JLabel lpas = new JLabel ("Password :");
        lpas.setBounds(20,330,200,30);
        lpas.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lpas);
        
        tfp = new JPasswordField();
        tfp.setBounds(200,330,300,30);
        add(tfp);
        
        JLabel lcpas = new JLabel ("Confirm Password :");
        lcpas.setBounds(20,380,300,30);
        lcpas.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lcpas);
        
        tfcp = new JPasswordField();
        tfcp.setBounds(290,380,300,30);
        add(tfcp);
        
        JLabel lid = new JLabel ("GST-ID :");
        lid.setBounds(20,430,200,30);
        lid.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lid);
        
        tfg = new JTextField();
        tfg.setBounds(200, 430, 300, 30);
        add(tfg);
        
        JLabel ladd = new JLabel ("Address :");
        ladd.setBounds(20,480,200,30);
        ladd.setFont(new Font("Arial", Font.PLAIN, 30));
        add(ladd);
        
        ifadd = new JTextField();
        ifadd.setBounds(200, 480, 300, 30);
        add(ifadd);
        
        JLabel lec = new JLabel ("Emergency Contact :");
        lec.setBounds(20,530,300,30);
        lec.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lec);
        
        tfec = new JTextField();
        tfec.setBounds(320, 530, 300, 30);
        add(tfec);
        
       
        
        
        signup = new JButton();
        JLabel h = new JLabel("    Sign Up");
        h.setBounds(60, 6000,200, 50);
        h.setFont(new Font("Arial", Font.PLAIN,20));
        h.setForeground(Color.black);
        signup.add(h);
        signup.setBackground(Color.green);
        signup.setForeground(Color.white);
        signup.setBounds(60, 600, 150,35);
        add(signup);
        signup.addActionListener(this);
        
        back = new JButton();
        JLabel b = new JLabel("    Back");
        b.setBounds(60, 600,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        back.add(b);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(240, 600, 150,35);
        add(back);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 150, 450, 370);   
        add(image);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Signup();
        }
        
        else if(ae.getSource() == signup){
            
        String name = tfname.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "The name cannot be empty");
            return;
        }
        
        String phone = tfc.getText();
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
            
        String email = tfe.getText();
        if((email.contains("@")&& email.contains(".com") && !email.equals("")) || 
                email.contains("@")&& email.contains(".in") && !email.equals("")){
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Email");
            return;
        }
        
        String pass = tfp.getText();
        String cpass = tfcp.getText();
        
        if(!pass.equals(cpass)){
            JOptionPane.showMessageDialog(null, "Password Not Matching");
            return;
        }
        
        if(!pass.contains("@") || pass.length()<8){
            JOptionPane.showMessageDialog(null, "Weak Password");
            JOptionPane.showMessageDialog(null, "Must Contain @ and min 8 characters");
            return;
        }
        
        
        String gst = tfg.getText();
        if(gst.equals("")){
            JOptionPane.showMessageDialog(null, "GST ID cannot be empty");
            return;
        }
        
        String address = ifadd.getText();
        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "The Address cannot be empty");
            return;
        }
        
        String emphone = tfec.getText();
        

        
        try{
            Conn c = new Conn();
            String query = "insert into chemist values ('"+name+"','"+phone+"','"+email+"','"+pass+"','"+cpass+"','"+gst+"','"+address+"','"+emphone+"')";
            c.s.executeUpdate(query); 
            JOptionPane.showMessageDialog(null, "Registered succesfully");
            JOptionPane.showMessageDialog(null, "Login To Continue");
            setVisible(false);
            new Login();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        }
    }
    
    public static void main (String args[]){
        new SignupC();
    }
}
