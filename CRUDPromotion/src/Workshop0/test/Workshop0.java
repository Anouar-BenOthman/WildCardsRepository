/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop0.test;

import com.esprit.entite.Promotion;
import com.esprit.services.PromotionService;
import com.esprit.util.DataSource;

/**
 *
 * @author Aziz
 */
public class Workshop0 {
    public static void main(String[] args) {
         DataSource ds =DataSource.getInstance();
         System.out.println("DS:\n"+ds);
         Promotion p= new Promotion("test2","test",10,"test","12/12/2017","30/12/2017","test");
         PromotionService pService = new PromotionService();
         pService.createPromotion(p);
         
        /* for(Promotion p :pService.getAllPromotion())
         {
             System.out.println(p);
         }*/
        
       // pService.deletePromotion(2);
        
       /* Promotion pr= new Promotion("tor","tor",10,"tror","12/12/2017","30/12/2017","tor");
        pService.updatePromotion(pr);*/
        
         
         
         
    }
           
         
}
    

