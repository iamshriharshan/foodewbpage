package healtify.ultimate.health.app;

import javax.swing.*;

import java.awt.*;


import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener {
    JButton appointment, addmedi, chemist, addimpco, info, panic, govt, logout;
    String username = LoginU.usern;
    
    Dashboard(){
        
        setLayout(null);
        
        setBounds(-7,0,1920,1080);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-7,35,1920,1080);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1920, 40);
        mb.setBackground(Color.WHITE);
        add(mb);
        
        JMenu s = new JMenu("                                                                                                                                                                                                                                                                          ");
        mb.add(s);
        
        if(username == null){
            username = "User";
        }
        JMenu usrinofo = new JMenu(username);
        usrinofo.setFont(new Font("Arial", Font.PLAIN,25));
        usrinofo.setForeground(Color.BLUE);
        mb.add(usrinofo);
        
        JMenuItem usin = new JMenuItem("User Info");
        usin.setFont(new Font("Arial", Font.PLAIN,22));
        usrinofo.add(usin);
        usin.addActionListener(this);
        
        JMenuItem hos = new JMenuItem("Hospitals");
        hos.setFont(new Font("Arial", Font.PLAIN,22));
        usrinofo.add(hos);
        hos.addActionListener(this);
        
        JMenuItem conts = new JMenuItem("Inportant Contacts");
        conts.setFont(new Font("Arial", Font.PLAIN,22));
        usrinofo.add(conts);
        conts.addActionListener(this);
        
        JMenuItem apphis = new JMenuItem("Appointment History");
        apphis.setFont(new Font("Arial", Font.PLAIN,22));
        usrinofo.add(apphis);
        apphis.addActionListener(this);
        
        JMenuItem che = new JMenuItem("Chemist");
        che.setFont(new Font("Arial", Font.PLAIN,22));
        usrinofo.add(che);
        che.addActionListener(this);
        
        JMenu ss = new JMenu("          ");
        mb.add(ss);
        

        

        
        JLabel head = new JLabel ("Hello " + username + " welcome to Healthify App");
        head.setBounds(30, 50,1800, 70);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Tahoma", Font.BOLD, 30));
        image.add(head);  
         
        JLabel appoint = new JLabel ("Book your appointment now");
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
        
        JLabel addmed = new JLabel ("Add your medicines now");
        addmed.setBounds(50, 280, 500, 50);
        addmed.setFont(new Font("Arial", Font.PLAIN,40));
        addmed.setForeground(Color.WHITE);
        image.add(addmed);
        
        addmedi = new JButton();
        JLabel a = new JLabel("Add Here");
        a.setBounds(600, 280,200, 50);
        a.setFont(new Font("Arial", Font.PLAIN,30));
        a.setForeground(Color.WHITE);
        addmedi.add(a);
        addmedi.setBounds(600, 280, 180, 50);
        addmedi.setBackground(Color.black);
        addmedi.setForeground(Color.white);
        image.add(addmedi);
        addmedi.addActionListener(this);
        
        JLabel chem= new JLabel ("Order medicines from chemist");
        chem.setBounds(50, 380, 550, 50);
        chem.setFont(new Font("Arial", Font.PLAIN,40));
        chem.setForeground(Color.WHITE);
        image.add(chem);
        
        chemist = new JButton();
        JLabel b = new JLabel("Buy Here");
        b.setBounds(600, 380,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,30));
        b.setForeground(Color.WHITE);
        chemist.add(b);
        chemist.setBounds(600, 380, 180, 50);
        chemist.setBackground(Color.black);
        chemist.setForeground(Color.white);
        image.add(chemist);
        chemist.addActionListener(this);
        
        JLabel cons = new JLabel ("Add your important contacts");
        cons.setBounds(50, 480, 500, 50);
        cons.setFont(new Font("Arial", Font.PLAIN,40));
        cons.setForeground(Color.WHITE);
        image.add(cons);
        
        addimpco = new JButton();
        JLabel ad = new JLabel("Add Now");
        ad.setBounds(600, 480,200, 50);
        ad.setFont(new Font("Arial", Font.PLAIN,30));
        ad.setForeground(Color.WHITE);
        addimpco.add(ad);
        addimpco.setBounds(600, 480, 180, 50);
        addimpco.setBackground(Color.black);
        addimpco.setForeground(Color.white);
        image.add(addimpco);
        addimpco.addActionListener(this);
        
        JLabel infos = new JLabel ("Go to informational videos");
        infos.setBounds(50, 580, 500, 50);
        infos.setFont(new Font("Arial", Font.PLAIN,40));
        infos.setForeground(Color.WHITE);
        image.add(infos);
        
        info = new JButton();
        JLabel g = new JLabel("Go Now");
        g.setBounds(600, 580,200, 50);
        g.setFont(new Font("Arial", Font.PLAIN,30));
        g.setForeground(Color.WHITE);
        info.add(g);
        info.setBounds(600, 580, 180, 50);
        info.setBackground(Color.black);
        info.setForeground(Color.white);
        image.add(info);
        info.addActionListener(this);
        
        panic = new JButton();
        JLabel p = new JLabel("Panic");
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
        
        govt = new JButton();
        JLabel govtt = new JLabel("Government Schemes");
        govtt.setLayout(null);
        govtt.setBounds(250, 680,350, 50);
        govtt.setFont(new Font("Arial", Font.PLAIN,30));
        govtt.setForeground(Color.black);
        govt.add(govtt);
        govt.setBounds(450, 680, 350, 50);
        govt.setBackground(Color.GREEN);
        govt.setForeground(Color.white);
        image.add(govt);
        govt.addActionListener(this);
        
        logout = new JButton();
        JLabel l = new JLabel("Logout");
        l.setLayout(null);
        l.setBounds(850, 680,200, 50);
        l.setFont(new Font("Arial", Font.PLAIN,30));
        l.setForeground(Color.WHITE);
        logout.add(l);
        logout.setBounds(850, 680, 130, 50);
        logout.setBackground(Color.black);
        logout.setForeground(Color.WHITE);
        image.add(logout);
        logout.addActionListener(this);
        
        
        setVisible(true);
    }
    
    public void openWebPage(String url){
   try {         
     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
   }
   catch (java.io.IOException e) {
       System.out.println(e.getMessage());
   }
}
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("User Info")){
            new Userinfo();
        }
        
        else if(ae.getActionCommand().equals("Hospitals")){
            new Hospitals();
        }
        
        else if(ae.getActionCommand().equals("Inportant Contacts")){
            new Importantcontacts();
        }
        
        else if(ae.getActionCommand().equals("Appointment History")){
            new AppointmentHistory();
        }
        
        else if(ae.getActionCommand().equals("Chemist")){
            new Chemist();
        }
       
        
        else if(ae.getSource() == appointment ){
            new AllHospitals();
        }
        
        else if(ae.getSource() == addmedi ){
            new AddMedicines();
        }
        
        else if(ae.getSource() == chemist ){
            new Chemistt();
        }
        
        else if(ae.getSource() == addimpco ){
            new AddContacts();
        }
        
        else if(ae.getSource() == info ){
            openWebPage("https://healthifi.netlify.app/");
        }
        
        else if(ae.getSource() == panic ){
            new Panic();
        }
        
        else if(ae.getSource() == govt ){
            openWebPage("https://www.india.gov.in/my-government/schemes");
        }
        
        else if(ae.getSource() == logout ){
            setVisible(false);
            new Login();
        }
        
    }
    
    public static void main(String args[]){
        new Dashboard();
}
}    
