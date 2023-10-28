
package healtify.ultimate.health.app;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.Random;

public class SignupH extends JFrame  implements ActionListener {
    JTextField tfname, tfc, tfe, ifadd;
    JPasswordField tfp, tfcp;
    JButton signup, back ;
    public static String id;
    
    SignupH(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(190, 60, 1200, 700);
        
        JLabel head = new JLabel("Register to Healthify");
        head.setBounds(20, 50, 500,35);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        JLabel ho = new JLabel("Hospital Registration");
        ho.setBounds(20, 120, 500,35);
        ho.setFont(new Font("Arial", Font.BOLD,30));
        add(ho);
        
        JLabel lname = new JLabel ("Hospital Name :");
        lname.setBounds(20,200,300,30);
        lname.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 200, 300, 30);
        add(tfname);
        
        
        JLabel lcon = new JLabel ("Contact :");
        lcon.setBounds(20,260,200,30);
        lcon.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lcon);
        
        tfc = new JTextField();
        tfc.setBounds(200, 260, 300, 30);
        add(tfc);
        
        JLabel lem = new JLabel ("Email id :");
        lem.setBounds(20,320,200,30);
        lem.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lem);
        
        tfe = new JTextField();
        tfe.setBounds(200, 320, 300, 30);
        add(tfe);
        
        JLabel lpas = new JLabel ("Password :");
        lpas.setBounds(20,370,300,30);
        lpas.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lpas);
        
        tfp = new JPasswordField();
        tfp.setBounds(200,370,200,30);
        add(tfp);
        
        JLabel lcpas = new JLabel ("Confirm Password :");
        lcpas.setBounds(20,420,300,30);
        lcpas.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lcpas);
        
        tfcp = new JPasswordField();
        tfcp.setBounds(290,420,300,30);
        add(tfcp);
        
      
        
        JLabel ladd = new JLabel ("Address :");
        ladd.setBounds(20,490,200,30);
        ladd.setFont(new Font("Arial", Font.PLAIN, 30));
        add(ladd);
        
        ifadd = new JTextField();
        ifadd.setBounds(170, 490, 330, 30);
        add(ifadd);
        

        
        signup = new JButton();
        JLabel h = new JLabel("    Sign Up");
        h.setBounds(60, 600,200, 50);
        h.setFont(new Font("Arial", Font.PLAIN,20));
        h.setForeground(Color.black);
        signup.add(h);
        signup.setBackground(Color.green);
        signup.setForeground(Color.white);
        signup.setBounds(60, 570, 150,35);
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
        back.setBounds(240, 570, 150,35);
        add(back);
        back.addActionListener(this);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 150, 450, 370);   // 450 to 370 in width this is cropping the image
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
            if(phone.length()<10 || x>0 || phone.length()>14){
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
        
        
        
        String address = ifadd.getText();
        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "The Address cannot be empty");
            return;
        }
        
        Random rand = new Random();
        int y = rand.nextInt(10000);
        String s = "HCC";
        String t = ""+y;
        id = s+t;
        
        
        try{
            Conn c = new Conn();
            String query = "insert into Hospital values ('"+name+"','"+phone+"','"+email+"','"+pass+"','"+cpass+"','"+address+"','"+id+"')";
            c.s.executeUpdate(query); 
            JOptionPane.showMessageDialog(null, "Registered succesfully");
            JOptionPane.showMessageDialog(null, "Check Email for Hospital ID");
            setVisible(false);
            new Login();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        }
        

    }
    
    public static void main (String args[]){
        new SignupH();
    }
}
