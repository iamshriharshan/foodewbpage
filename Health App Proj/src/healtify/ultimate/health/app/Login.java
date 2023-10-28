
package healtify.ultimate.health.app;

import java.awt.Font;

import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class Login extends JFrame implements ActionListener {
    JButton chemist, user, hospital, back;
    
    Login(){
        
        setLayout(null);
        
        setBounds(500, 200, 700, 400);
        
        JLabel head = new JLabel ("Login to Healthify");
        head.setBounds(200, 5, 400, 50);
        head.setFont(new Font("Arial", Font.BOLD, 30));
        add(head);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(270, 50, 400, 300);
        add(image);
        
        JLabel as = new JLabel("Login As");
        as.setFont(new Font("Arial", Font.BOLD, 25));
        as.setBounds(30, 50, 150, 30);
        add(as);
        
        user = new JButton();
        JLabel b = new JLabel("User");
        b.setBounds(30, 120,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,30));
        b.setForeground(Color.black);
        user.add(b);
        user.setBounds(30, 100, 180, 50);
        user.setBackground(Color.green);
        user.setForeground(Color.white);
        add(user);
        user.addActionListener(this);
        
        chemist = new JButton();
        JLabel c = new JLabel("Chemist");
        c.setBounds(30, 80,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,30));
        c.setForeground(Color.black);
        chemist.add(c);
        chemist.setBounds(30, 180, 180, 50);
        chemist.setBackground(Color.green);
        chemist.setForeground(Color.white);
        add(chemist);
        chemist.addActionListener(this);
        
        hospital = new JButton();
        JLabel h = new JLabel("Hospital");
        h.setBounds(30, 80,200, 50);
        h.setFont(new Font("Arial", Font.PLAIN,30));
        h.setForeground(Color.black);
        hospital.add(h);
        hospital.setBounds(30, 260, 180, 50);
        hospital.setBackground(Color.green);
        hospital.setForeground(Color.white);
        add(hospital);
        hospital.addActionListener(this);
        
        back = new JButton();
        JLabel ba = new JLabel("Back");
        ba.setBounds(30, 80,200, 50);
        ba.setFont(new Font("Arial", Font.PLAIN,18));
        ba.setForeground(Color.WHITE);
        back.add(ba);
        back.setBounds(30, 330, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == chemist ){
            setVisible(false);
            new LoginC();
        }
        
        else if(ae.getSource() == user ){
            setVisible(false);
            new LoginU();
        }
        
        else if(ae.getSource() == hospital ){
            setVisible(false);
            new LoginH();
        }
        
        else if(ae.getSource() == back ){
            setVisible(false);
            new Open();
        }
    }
    
    public static void main (String args[]){
        new Login();
    }
}
