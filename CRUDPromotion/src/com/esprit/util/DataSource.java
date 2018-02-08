/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aziz
 */
public class DataSource {
    final   String url="jdbc:mysql://localhost:3306/esprit" ; 
    final String user="root" ; 
   final String password =""; 
   static DataSource instance;
    Connection connection ; 
    
    public Connection getConnection() {
    return this.connection;
    }
    public static DataSource getInstance(){
        if(instance==null){
            instance = new DataSource();
        }
        return instance;
    }
    
    private DataSource() {


      try { 
              Class.forName("com.mysql.jdbc.Driver");
          connection=DriverManager.getConnection(url, user, password) ;
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }
    
}
