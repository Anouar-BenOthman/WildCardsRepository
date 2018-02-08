/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIJ
 */
public class dbConnection {
    private static dbConnection data;
    private Connection con;
    public String user="root";
    public String password="";
    public String url="jdbc:mysql://localhost:3306/readytogo";
    
    private dbConnection(){
        try {
            con=DriverManager.getConnection(url,user, password);
            System.out.println("Connection établie");
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static dbConnection getInstance(){
        if(data==null)
            data=new dbConnection();
        return data;
    }
    
    public Connection getConnection(){
        return con;
    }
}