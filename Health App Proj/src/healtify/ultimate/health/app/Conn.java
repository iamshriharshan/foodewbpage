
package healtify.ultimate.health.app;

import java.sql.*;


public class Conn {
    
    Connection c;
    
    Statement s;
    
    Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthify", "root", "Nunune@12");
            s = c.createStatement();
            
        } 
        catch(Exception e){
            e.printStackTrace();
    }
        
    }
}
