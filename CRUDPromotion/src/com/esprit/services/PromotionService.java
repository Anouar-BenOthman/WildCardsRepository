/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.entite.Promotion;
import com.esprit.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aziz
 */
public class PromotionService implements IPromotionService {
    
    Connection connexion;
    Statement st;
    ResultSet rs; 
    public PromotionService()
    {
      connexion = DataSource.getInstance().getConnection();
      
    }

    @Override
    public void createPromotion(Promotion p) {
        String req="insert into promotion (marque,categorie,pourcentage,model,date_debut,date_fin,image) values ('"+p.getMarque()+"','"+p.getCategorie()+"','"+p.getPourcentage()+"','"+p.getModel()+"','"+p.getDate_debut()+"','"+p.getDate_fin()+"','"+p.getImage()+"')";
        System.out.println(req);
        try {
        st=connexion.createStatement();
        st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Promotion> getAllPromotion() {
        List <Promotion> promotion= new ArrayList<>();
        try {
            st=connexion.createStatement();
            rs = st.executeQuery("select * from promotion");
            ResultSetMetaData resultMeta =rs.getMetaData();
            for (int i =1; i<= resultMeta.getColumnCount(); i++)
            {
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
    
        while(rs.next()){
            Promotion p=new Promotion(rs.getInt("id_promotion"), rs.getString("marque"), rs.getString("categorie"), rs.getInt("pourcentage"), rs.getString("model"), rs.getString("date_debut"), rs.getString("date_fin"), rs.getString("image"));
            
            promotion.add(p);
        }
     
       } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        
        return promotion;
    }

    @Override
    public Promotion getPromotionbyId(int id) {
        Promotion p = null;
        try {
            st=connexion.createStatement();
           rs=  st.executeQuery("select * from promotion where id_promotion="+id);
           if (rs.next())
           p=new Promotion(rs.getInt("id_promotion"), rs.getString("marque"), rs.getString("categorie"), rs.getInt("pourcentage"), rs.getString("model"), rs.getString("date_debut"), rs.getString("date_fin"), rs.getString("image"));
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }

    @Override
    public boolean deletePromotion(int id) {
        Promotion p = getPromotionbyId(id);
 if (p!=null){
 try {
     st.executeUpdate("delete from promotion where id_promotion="+id);
     return true;
             
 } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
return false;
    }

    @Override
    public boolean deletePromotion(Promotion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePromotion(Promotion p) {
        Promotion p1=getPromotionbyId(p.getId_promotion());
if (p1!=null)
    try {
        st=connexion.createStatement();
    st.executeUpdate("update promotion set marque='updated', categorie='updated', pourcentage='updated', model='updated', date_debut='updated', date_fin='updated', image='updated',  where id_promotion="+p.getId_promotion());
        System.out.println("promotion with id:"+p.getId_promotion()+" was updated");
    return true;
    }catch(SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
return false;
    }

    @Override
    public boolean updatePromotion(int p) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    
}
