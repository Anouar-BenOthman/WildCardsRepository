/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Propriete;
import entity.ReseauSocial;
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
public class ReseauSocialService implements IReseauSocialService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public ReseauSocialService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }


    @Override
    public boolean ajouterReseau(ReseauSocial r,int i) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `reseausocial`( `reseau`, `url`, `id_prop`) VALUES (?,?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,r.getReseau());
        pste.setString(2,r.getUrl());
        pste.setInt(3,i);
        pste.executeUpdate();
        return true;
    }

    @Override
    public boolean modifierReseau(ReseauSocial r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet afficherReseau(int idp) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT * FROM reseausocial WHERE `id_prop` ="+idp;
       ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        
        return rs;
    }

    @Override
    public boolean supprimerPropriete(int idPropriete) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `reseausocial` WHERE `id_prop` ="+idPropriete;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        
        return true;
    }
    
}
