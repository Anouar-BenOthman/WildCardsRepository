/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class ImgService implements IImgService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public ImgService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }

    @Override
    public boolean ajouterImg(String url, int id) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `imageprop`( `url`, `id_prop`) VALUES (?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,url);
        pste.setInt(2,id);
        pste.executeUpdate();
        return true;
    }

    @Override
    public ResultSet afficherImg(int idp) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT `url` FROM `imageprop` WHERE `id_prop` = ?";
        pste=cnx.prepareStatement(req);
        pste.setInt(1,idp);
        rs=ste.executeQuery(req);
        while(rs.next()){
            System.out.println(rs.getInt("url"));
        }
        return rs;
    }

    @Override
    public boolean supprimerImg(int idPropriete) throws SQLException {
       Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `imageprop` WHERE `id_prop` ="+idPropriete;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        return true;
    }
    
}
