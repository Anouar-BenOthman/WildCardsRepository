/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Horaire;
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
public class HoraireService implements IHoraireService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;

    public HoraireService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }

    @Override
    public boolean ajouterHoraire(Horaire h,int i) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `horaire`( `jour`, `ouverture`, `fermeture`, `on_off`, `id_prop`) VALUES (?,?,?,?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setString(1,h.getJour());
        pste.setString(2,h.getOuverture());
        pste.setString(3,h.getFermeture());
        pste.setBoolean(4,h.isState());
        pste.setInt(5,i);
        pste.executeUpdate();
        return true;
    }

    @Override
    public boolean modifierHoraire(Horaire h) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet afficherHoraire() throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT * FROM horaire WHERE 1";
        ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        
        return rs;
    }

    @Override
    public boolean supprimerHoraire(int idProp) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="DELETE FROM `horaire` WHERE `id_prop` ="+idProp;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        return true;
    }

   
}
