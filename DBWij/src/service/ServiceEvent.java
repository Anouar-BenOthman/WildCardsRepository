/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.dbConnection;

/**
 *
 * @author WIJ
 */

    public class ServiceEvent {
    public Connection con = dbConnection.getInstance().getConnection() ;
    public Statement ste;
    
    public ServiceEvent(){
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterEvent(Evenement e) throws SQLException{
        String req="INSERT INTO event (idEvent,titre,date,description,coverImage,gallerie,lieu,prix,categorie,emailOwner,numTelephoneOwner,nomOwner) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
       pre.setInt(1, e.getIdEvent());
        pre.setString(2,e.getTitre());
        pre.setDate(3,(Date) e.getDate());
        pre.setString(4, e.getDescription());
        pre.setString(5, e.getCoverImage());
        pre.setString(6, e.getGallerie());
        pre.setString(7, e.getLieu());
        pre.setString(8, e.getPrix());
        pre.setString(9, e.getCategorie());
        pre.setString(10, e.getEmailOwner());
        pre.setInt(11, e.getNumTelephoneOwner());
        pre.setString(12, e.getNomOwner());
       
        pre.executeUpdate();
        System.out.println("Event ajoutée");
    }
    
    public void modifierEvent(Evenement e,int id){
        try {
            String req;
            req = "UPDATE event SET `idEvent`=?,`titre`=?,`date`=?,`description`=?,`coverImage`=?,`gallerie`=?,`lieu`=?,`prix`=?,`categorie`=?,`emailOwner`=?,`numTelephoneOwner`=?,`nomOwner`=? WHERE idEvent="+id;
            PreparedStatement pre=con.prepareStatement(req);
            pre.setInt(1, id);
           /* e.setNom(req);
            Date date = null;
            e.setDate(date);
            e.setDescription(req);
            e.setImage(req);
            e.setImage(req);
            e.setLieu(req);
            e.setPrix(req);
            */
        pre.setString(2,e.getTitre());
        pre.setDate(3,(Date) e.getDate());
        pre.setString(4, e.getDescription());
        pre.setString(5, e.getCoverImage());
        pre.setString(6, e.getGallerie());
        pre.setString(7, e.getLieu());
        pre.setString(8, e.getPrix());
        pre.setString(9, e.getCategorie());
        pre.setString(10, e.getEmailOwner());
        pre.setInt(11, e.getNumTelephoneOwner());
        pre.setString(12, e.getNomOwner());
            pre.executeUpdate();
            System.out.println(pre.execute());
            System.out.println("Modification avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     public void supprimerEvent(int id){

        try {
            String req = "DELETE FROM event WHERE idEvent=?";
            PreparedStatement ste1=con.prepareStatement(req);
            ste1.setInt(1, id);
            ste1.executeUpdate();
            System.out.println(ste1.execute());
         System.out.println("suppression avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
     }   
    
}
