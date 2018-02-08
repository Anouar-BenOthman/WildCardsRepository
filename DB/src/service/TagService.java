/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
import entity.Tag;
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
public class TagService implements ITagService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public TagService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }

    @Override
    public boolean ajouterTag(Tag t, int i) throws SQLException {
         Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `tag`( `nom`, `id_prop`) VALUES (?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,t.getNom());
        pste.setInt(2,i);
        pste.executeUpdate();
        return true;
    }

    @Override
    public boolean modifierTag(Tag t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet afficherTag(int idp) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT `nom` FROM `tag` WHERE `id_prop` ="+idp;
         ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        
        return rs;
    }

    @Override
    public boolean supprimerTag(int idPropriete) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `tag` WHERE `id_prop` ="+idPropriete;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        return true;
    }
    
}
