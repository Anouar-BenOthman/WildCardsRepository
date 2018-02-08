/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public class DBConnection {
  static String url="jdbc:mysql://localhost:3306/readytogo";
    static String login="root";
    static String password="";
   public static Connection cnx ;
   static DBConnection instanceBD;
  
    private DBConnection() {
      try {
         cnx = DriverManager.getConnection(url, login, password);
          System.out.println("connexion etablie !!");
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
          
      }
        
    }
    
    public static DBConnection  getInstanceBD(){
        if(instanceBD == null)
            instanceBD = new DBConnection();
        return instanceBD;
        
    }
    
    public Connection getConnection(){
        return cnx;
    }
    

    
}
