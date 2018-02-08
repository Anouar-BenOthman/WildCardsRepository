/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worshop0.services;

import com.esprit.entite.Utilisateur;
import java.util.List;
import com.esprit.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lanwe
 */
public class UtilisateurService implements IUtilisateurService {

    
    Connection connexion;
    Statement st;
    ResultSet rs; 
    public UtilisateurService()
    {
      connexion = DataSource.getInstance().getConnection();
      
    }
    @Override
    public void createPersonne(Utilisateur p) {
        String req="insert into utilisateur (nom,prenom,login,password) values ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getLogin()+"','"+p.getPassword()
                +"')";
        System.out.println(req);
        try {
        st=connexion.createStatement();
        st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        
         List <Utilisateur> utilisateurs= new ArrayList<>();
        try {
            rs = st.executeQuery("select * from utilisateur");
            ResultSetMetaData resultMeta =rs.getMetaData();
            for (int i =1; i<= resultMeta.getColumnCount(); i++)
            {
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
    
        while(rs.next()){
            Utilisateur p=new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"));
            
            utilisateurs.add(p);
        }
     
       } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        
        System.out.println(utilisateurs);
        return utilisateurs;
        
        
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {

Utilisateur u = null;
        try {
           rs=  st.executeQuery("select * from utilisateur where idUtilisateur="+id);
           if (rs.next())
           u=new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"));
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(u);
        return u;


    }

    @Override
    public boolean deleteUtilisateur(int id) {
Utilisateur p = getUtilisateurById(id);
 if (p!=null){
 try {
     st.executeUpdate("delete from utilisateur where id="+id);
     return true;
             
 } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
return false;

    }

    @Override
    public boolean updateUtilisateur(Utilisateur p) {
Utilisateur p1=getUtilisateurById(p.getIdUtilisateur());
        
if (p1!=null)
    try {
        
    st.executeUpdate("update utilisateur set nom='updated', prenom='updated' where idUtilisateur="+p.getIdUtilisateur());
        System.out.println("personne with id:"+p.getIdUtilisateur()+" was updated");
    return true;
    }catch(SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
return false;    
    }

    @Override
    public boolean updateUtilisateur(int p) {

                Utilisateur u = getUtilisateurById(p);
 if (u!=null){
   System.out.println("personne with id:"+p+" was updated");
        try {
            st.executeUpdate("update personne set nom='updated1', prenom='updated1' where id="+p);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
       return true;
        }
        
 }
    
return false;
        

    }
    
}
