/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experience.services;

import com.esprit.entite.Experience;
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
 * @author ghada
 */
public class ExperienceService implements IExperienceService {
    
    Connection connexion;
    Statement st;
    ResultSet rs; 
    public ExperienceService()
    {
      connexion = DataSource.getInstance().getConnection();
      
    }
    @Override
    public void createExperience(Experience e) {
        
        String req="insert into experience(idExperience,rateTitle,comment,idUser) values ('"+e.getIdExperience()+"','"+e.getRateTitle()+"','"+e.getComment()+"','"+e.getIdUser()+"')";
        System.out.println(req);
        try {
        st=connexion.createStatement();
        st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Experience> getAllExperience() {
        List <Experience> experience= new ArrayList<>();
        try {
            st=connexion.createStatement();
            rs = st.executeQuery("select * from experience");
            ResultSetMetaData resultMeta =rs.getMetaData();
            for (int i =1; i<= resultMeta.getColumnCount(); i++)
            {
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
    
        while(rs.next()){
            Experience e=new Experience(rs.getInt("idExperience"), rs.getString("rateTitle"),rs.getString("comment"),rs.getInt("idUser"));
            
            experience.add(e);
        }
     
       } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        
        return experience;
    }
    
   
    @Override
    public Experience getExperiencebyId(int idExperience) {

Experience e = null;
        try {
            st=connexion.createStatement();
           rs=  st.executeQuery("select * from experience where idExperience="+idExperience);
           if (rs.next())
           e=new Experience(rs.getInt("idExperience"), rs.getString("rateTitle"),rs.getString("comment"),rs.getInt("idUser"));
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public boolean deleteExperience(int idExperience) {
 Experience e = getExperiencebyId(idExperience);
 if (e!=null){
 try {
     st=connexion.createStatement();
     st.executeUpdate("delete from experience where idExperience="+idExperience);
     return true;
             
 } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
return false;
    }

   

    @Override
    public boolean updateExperience(Experience e) {
Experience e1=getExperiencebyId(e.getIdExperience());
if (e1!=null)
    try {
        st=connexion.createStatement();
    st.executeUpdate("update experience set rateTitle='Updated',comment='Updated',idUser='Updated' where idExperience="+e.getIdExperience());
        System.out.println("experience with idExperience:"+e.getIdExperience()+" was updated");
    return true;
    }catch(SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
return false;
    }

  

    @Override
    public boolean deleteExperience(Experience e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateExperience(int idExperience) { 
        Experience e = getExperiencebyId(idExperience);
 if (e!=null){
   System.out.println("experience with idExperience:"+idExperience+" was updated");
        try {
            st=connexion.createStatement();
            st.executeUpdate("update experience  set rateTitle='Updated',comment='Updated',idUser='Updated' where idExperience=5");
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
       return true;
        }
        
 }
    
return false;
    }

}