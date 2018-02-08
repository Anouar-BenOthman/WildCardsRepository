/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
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
public class CategorieService implements ICategoriService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public CategorieService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }


    @Override
    public boolean ajouterCategorie(Categorie c,int i) throws SQLException {
         Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `categori`( `nom`, `id_prop`) VALUES (?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,c.getNom());
        pste.setInt(2,i);
        pste.executeUpdate();
        return true;
    }

    @Override
    public boolean modifierCategorie(Categorie c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet afficherCategorie(int idp) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT `nom` FROM `categori` WHERE `id_prop` ="+idp;
        ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        
        return rs;
    }

    @Override
    public boolean supprimerCategorie(int idPropriete) throws SQLException {
         Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `categori` WHERE `id_prop` = ? ";
        pste=cnx.prepareStatement(req);
        pste.setInt(1,idPropriete);
        pste.executeUpdate();
        return true;
    }
    
}
