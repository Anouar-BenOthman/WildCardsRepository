/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
import entity.Equipement;
import entity.Horaire;
import entity.Propriete;
import entity.ReseauSocial;
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
public class ProprieteService implements IProprieteService{
    
    
    Statement ste;
    PreparedStatement pste;
    ResultSet rs;
    Connection cnx;
    
    
        EquipementService es = new EquipementService();
        HoraireService hs= new HoraireService();
        ReseauSocialService r= new ReseauSocialService();
        TagService ts =new TagService();
        ImgService is= new ImgService();
        CategorieService cs = new CategorieService();

    public ProprieteService() {
        this.cnx=(DBConnection.getInstanceBD()).getConnection();
    }

    @Override
    public boolean ajouterPropriete(Propriete p) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="INSERT INTO `propriete`( `id`,`email`, `titre`, "
                + "`slogan`, `description`, `logo`, `cover`, `emailowner`, "
                + "`numtel`, `siteweb`, `adresse`, `latitude`, `longitude`,"
                + " `id_user`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        pste=cnx.prepareStatement(req);
        pste.setInt(1,p.getId());
        pste.setString(2,p.getEmail());
        pste.setString(3,p.getTirte());
        pste.setString(4,p.getSlogan());
        pste.setString(5,p.getDescription());
        pste.setString(6,p.getLogo());
        pste.setString(7,p.getCover());
        pste.setString(8,p.getEmailOwner());
        pste.setString(9,p.getNumTel());
        pste.setString(10,p.getSiteWeb());
        pste.setString(11,p.getAdresse());
        pste.setFloat(12,p.getLatitude());
        pste.setFloat(13,p.getLongitude());
        pste.setInt(14,11);
        pste.executeUpdate();
        
        
        
        for(Categorie c :p.getCategorie()){
        cs.ajouterCategorie(c,p.getId());
        }
        
        for(Horaire h :p.getLshr()){
        hs.ajouterHoraire(h,p.getId());
        }

        for(Equipement e :p.getLsequi()){
        es.ajouterEquipement(e,p.getId());
        }

        for(Tag t :p.getLstag()){
        ts.ajouterTag(t,p.getId());
        }

        for(ReseauSocial re :p.getRs()){
        r.ajouterReseau(re,p.getId());
        }
        
        for(String s :p.getGallerie()){
        is.ajouterImg(s, 1);
        }
        
        return true;
    }

    @Override
    public ResultSet afficherPropriete() throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT * FROM propriete WHERE 1";
        ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        
        return rs;
    }


    @Override
    public ResultSet chercherPropriete(int idPropriete) throws SQLException {
        Connection cnx= DBConnection.cnx;
        String req="SELECT * FROM propriete WHERE `id` ="+idPropriete;
        ste=cnx.createStatement();
        rs=ste.executeQuery(req);
        while(rs.next()){
            System.out.println(rs.getInt("id")+" ; "+rs.getString("email")+" ; "+rs.getString("titre"));
        }
        return rs;
    }

    @Override
    public ResultSet chercherPropriete(String s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifierPropriete(Propriete p) throws SQLException {
        Connection cnx= DBConnection.cnx;
         cs.supprimerCategorie(p.getId());
       
        hs.supprimerHoraire(p.getId());

        es.supprimerequipement(p.getId());

        ts.supprimerTag(p.getId());

        r.supprimerPropriete(p.getId());

        is.supprimerImg(p.getId());
        
       String req=" UPDATE `propriete` SET `id`="+p.getId()+",`email`=\""+
               p.getEmail()+"\",`titre`=\""+p.getTirte()+"\",`slogan`=\""+p.getSlogan()+
               "\",`description`=\""+p.getDescription()+"\",`logo`=\""+p.getLogo()+
               "\",`cover`=\""+p.getCover()+"\",`emailowner`=\""+p.getEmailOwner()+
               "\",`numtel`=\""+p.getNumTel()+"\",`siteweb`=\""+p.getSiteWeb()+
               "\",`adresse`=\""+p.getAdresse()+"\",`latitude`=\""+p.getLatitude()+
               "\",`longitude`=\""+p.getLongitude()+"\",`id_user`="+12+
               " WHERE `id`="+p.getId();
       ste=cnx.createStatement();
        ste.executeUpdate(req);
        
        for(Categorie c :p.getCategorie()){
        cs.ajouterCategorie(c,p.getId());
        }
        
        for(Horaire h :p.getLshr()){
        hs.ajouterHoraire(h,p.getId());
        }

        for(Equipement e :p.getLsequi()){
        es.ajouterEquipement(e,p.getId());
        }

        for(Tag t :p.getLstag()){
        ts.ajouterTag(t,p.getId());
        }

        for(ReseauSocial re :p.getRs()){
        r.ajouterReseau(re,p.getId());
        }
        
        for(String s :p.getGallerie()){
        is.ajouterImg(s, 1);
        }
        
       return true;
    }

    @Override
    public boolean supprimerPropriete(int idPropriete) throws SQLException {
        Connection cnx= DBConnection.cnx;
        cs.supprimerCategorie(idPropriete);
       
        hs.supprimerHoraire(idPropriete);
        

        
        es.supprimerequipement(idPropriete);
        

    
        ts.supprimerTag(idPropriete);
        

        
        r.supprimerPropriete(idPropriete);
        
        
        
        is.supprimerImg(idPropriete);
        
        String req="DELETE FROM `propriete` WHERE `id` ="+idPropriete;
        ste=cnx.createStatement();
        ste.executeUpdate(req);
        
        
        
        
        
        return true;
    }
    
}
