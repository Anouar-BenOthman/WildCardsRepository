/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experience.test;

import com.esprit.entite.Experience;
import com.esprit.entite.Image;
import com.esprit.entite.Rate;
import com.esprit.util.DataSource;


import experience.services.ExperienceService;
import experience.services.ImageService;
import experience.services.RateService;

/**
 *
 * @author ghada
 */
public class test1 {

    /**
     * @param args the command line arguments
   
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        DataSource ds =DataSource.getInstance();
      //  DataSource ds1 =DataSource.getInstance();
       // DataSource ds2 =DataSource.getInstance();
        System.out.println("DS:\n"+ds);
       // System.out.println("DS:\n"+ds1);
      //  System.out.println("DS:\n"+ds2); //verfication de l'unicité de l'instance puisque on affiche la meme addresse memoire utilisé par ds ds1 et ds2
        
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
        Date d2 = sdf.parse("2017/09/25");*/
    
        ExperienceService eService = new ExperienceService();
        //eService.createExperience(e);
       
      Experience eu = new Experience(3,"genial","comment1",2);
      eService.createExperience(eu);
   // eService.updateExperience(20);
     /*  int x=5;
        eService.updateExperience(x);
        */
      
     // eService.deleteExperience(13);
      
     // RateService pService = new RateService();
  //   Rate ru= new Rate(8,8,7,7);
       // pService.addRate(ru);
                
        
       // ImageService pService = new ImageService();
  // Image iu= new Image(1,1,"image");
  
      // pService.addImage(iu);
     //  pService.deleteImage(1);
        
        
    }
    
}
