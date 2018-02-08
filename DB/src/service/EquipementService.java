/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Equipement;
import entity.Propriete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DBConnection;

/**
 *
 * @author Nidhal
 */
public class EquipementService implements IEquipementService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public EquipementService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }

   
    @Override
    public boolean ajouterEquipement(Equipement e,int i) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `equipement`( `nom`, `id_prop`) VALUES (?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,e.getNom());
        pste.setInt(2,i);
        pste.executeUpdate();
        return true;
    }

   

    @Override
    public boolean modifierEquipement(Equipement e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet afficherEquipement() throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT nom FROM equipement WHERE 1";
        ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        while(rs.next()){
            System.out.println(rs.getString("nom"));
        }
        return rs;
    }

    @Override
    public boolean supprimerequipement(int idEquipement) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `equipement` WHERE `id_prop` ="+idEquipement;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        return true;
    }
    
}
