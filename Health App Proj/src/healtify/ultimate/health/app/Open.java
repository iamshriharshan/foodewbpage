
package healtify.ultimate.health.app;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class Open extends JFrame implements ActionListener{
    JButton close, register, login;
    Open(){
        setLayout(null);
        
        setBounds(500,200,600,300);
        
        JLabel head = new JLabel("Welcome to Healthify");
        head.setFont(new Font("Arial", Font.BOLD, 20));
        head.setBounds(30, 40, 200, 30);
        add(head);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(350, 40, 200, 200);
        add(image);
        
        login = new JButton();
        JLabel b = new JLabel("Login to Healthify");
        b.setBounds(30, 120,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,18));
        b.setForeground(Color.WHITE);
        login.add(b);
        login.setBounds(30, 100, 200, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);
        login.addActionListener(this);
        
        register = new JButton();
        JLabel c = new JLabel("Regsiter to Healthify");
        c.setBounds(30, 80,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,18));
        c.setForeground(Color.WHITE);
        register.add(c);
        register.setBounds(30, 150, 200, 30);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
        add(register);
        register.addActionListener(this);
        
        close = new JButton();
        JLabel h = new JLabel("Close");
        h.setBounds(30, 80,200, 50);
        h.setFont(new Font("Arial", Font.PLAIN,18));
        h.setForeground(Color.WHITE);
        close.add(h);
        close.setBounds(30, 200, 100, 30);
        close.setBackground(Color.black);
        close.setForeground(Color.white);
        add(close);
        close.addActionListener(this);
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == close){
            System.exit(0);
        }
        
        else if(ae.getSource() == login){
            setVisible(false);
            new Login();
        }
        
        else if(ae.getSource() == register){
            setVisible(false);
            new Signup();
        }
    }
    
    public static void main (String args[]){
        new Open();
    }
}
