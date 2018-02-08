package experience.services;

import com.esprit.entite.Rate;
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
public class RateService implements IRateService {
    
    Connection connexion;
    Statement st;
    ResultSet rs; 
    public RateService()
    {
      connexion = DataSource.getInstance().getConnection();
      
    }
    @Override
    public void addRate(Rate r) {
        String req="insert into rate (idExperience,rate,idUser) values ('"+r.getIdExperience()+"','"+r.getRate()+"','"+r.getIdUser()+"')";
        System.out.println(req);
        try {
        st=connexion.createStatement();
        st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Rate> getAllRate() {
        List <Rate> rate= new ArrayList<>();
        try {
            rs = st.executeQuery("select * from rate");
            ResultSetMetaData resultMeta =rs.getMetaData();
            for (int i =1; i<= resultMeta.getColumnCount(); i++)
            {
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
    
        while(rs.next()){
            Rate r=new Rate(rs.getInt("idRate"),  rs.getInt("idExperience"), rs.getInt("rate"),rs.getInt("idUser"));
            
            rate.add(r);
        }
     
       } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        
        return rate;
    }
    
   
    @Override
    public Rate getRatebyId(int idRate) {

Rate r = null;
        try {
            st=connexion.createStatement();
           rs=  st.executeQuery("select * from rate where idRate="+idRate);
           if (rs.next())
           r=new Rate(rs.getInt("idRate"),  rs.getInt("idExperience"), rs.getInt("rate"),rs.getInt("idUser"));
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }

    @Override
    public boolean deleteRate(int idRate) {
 Rate r = getRatebyId(idRate);
 if (r!=null){
 try {
     st=connexion.createStatement();
     st.executeUpdate("delete from rate where idRate="+idRate);
     return true;
             
 } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
return false;
    }

    @Override
    public boolean deleteRate(Rate r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   


    
}
