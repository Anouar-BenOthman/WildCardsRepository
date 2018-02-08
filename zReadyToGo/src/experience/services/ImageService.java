package experience.services;

import com.esprit.entite.Image;
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
public class ImageService implements IImageService {
    
    Connection connexion;
    Statement st;
    ResultSet rs; 
    public ImageService()
    {
      connexion = DataSource.getInstance().getConnection();
      
    }
    @Override
    public void addImage(Image i) {
        String req="insert into image (idImage,idExperience,image) values ('"+i.getIdImage()+"','"+i.getIdExperience()+"','"+i.getImage()+"')";
        System.out.println(req);
        try {
        st=connexion.createStatement();
        st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Image> getAllImage() {
        List <Image> image= new ArrayList<>();
        try {
            rs = st.executeQuery("select * from image");
            ResultSetMetaData resultMeta =rs.getMetaData();
            for (int i =1; i<= resultMeta.getColumnCount(); i++)
            {
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
    
        while(rs.next()){
            Image i=new Image(rs.getInt("idImage"),  rs.getInt("idExperience"), rs.getString("image"));
            
            image.add(i);
        }
     
       } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        
        return image;
    }
    
   
    @Override
    public Image getImagebyId(int idImage) {

Image i = null;
        try {
            st=connexion.createStatement();
           rs=  st.executeQuery("select * from image where idImage="+idImage);
           if (rs.next())
           i=new Image(rs.getInt("idImage"),  rs.getInt("idExperience"), rs.getString("image"));
        } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }

    @Override
    public boolean deleteImage(int idImage) {
 Image i = getImagebyId(idImage);
 if (i!=null){
 try {
     st=connexion.createStatement();
     st.executeUpdate("delete from image where idImage="+idImage);
     return true;
             
 } catch (SQLException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
return false;
    }

   

    @Override
    public boolean deleteImage(Image i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   


    
}
