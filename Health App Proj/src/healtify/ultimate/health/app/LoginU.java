
package healtify.ultimate.health.app;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

public class LoginU extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login;
    JButton cancel;
    JButton clear;
    
    public static String usern;
    
    LoginU(){
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(500,200,600,300);
        
        setLayout(null); 
        

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        

        password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        
        cancel = new JButton("Back");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        

        clear = new JButton("Clear");
        clear.setBounds(120,185,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        
        
        setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login ){
            usern = username.getText();
            String pass = password.getText();
            
            try{
                Conn c = new Conn();
                String query = "select Name, password from user where Name = '" + usern + "' and password = '" + pass +"' ";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }
                else{

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    password.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login();
            
        }
        
        else if(ae.getSource() == clear){
            username.setText("");
                    password.setText("");
        }
    }
    
    public static void main (String args[]){
        new LoginU();
    }
}
