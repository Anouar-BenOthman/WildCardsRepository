/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


/**
 *
 * @author Nidhal
 */
import entity.Categorie;
import entity.Equipement;
import entity.Horaire;
import entity.Propriete;
import entity.ReseauSocial;
import entity.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.CategorieService;
import service.EquipementService;
import service.HoraireService;
import service.ImgService;
import service.ProprieteService;
import service.ReseauSocialService;
import service.TagService;
public class DB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // Declaration des service
        ProprieteService ps = new ProprieteService();
        EquipementService es = new EquipementService();
        HoraireService hs= new HoraireService();
        ReseauSocialService r= new ReseauSocialService();
        TagService ts =new TagService();
        ImgService is= new ImgService();
        CategorieService cs = new CategorieService();
        
        // Declaration des categories
        Categorie c1 = new Categorie("restaurant", 1);
        Categorie c2 = new Categorie("vetement", 1);
        Categorie c3 = new Categorie("music", 1);
        List<Categorie> lg = new ArrayList<>();
        lg.add(c3);
        lg.add(c1);
        lg.add(c2);
        
       
        
        // Declaration des horaires
        Horaire h1 = new Horaire("lundi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h2 = new Horaire("mardi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h3 = new Horaire("mercredi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h4 = new Horaire("jeudi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h5 = new Horaire("vendredi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h6 = new Horaire("samedi", "8:50 AM", "16:00 PM", true, 1);
        Horaire h7 = new Horaire("dimanche", null, null, false, 1);
        
        List<Horaire> lh = new ArrayList<>();
        lh.add(h7);
        lh.add(h6);
        lh.add(h5);
        lh.add(h4);
        lh.add(h3);
        lh.add(h2);
        lh.add(h1);
        
        
        
        // Declaration des equipements
        Equipement e1 = new Equipement("parking", 1);
        Equipement e2 = new Equipement("ascenseur", 1);
        
        List<Equipement> le = new ArrayList<>();
        le.add(e2);
        le.add(e1);
        
       
        // Declaration des tags
        Tag t1 = new Tag("good time", 1);
        Tag t2 = new Tag("famille", 1);
        
        List<Tag> lt = new ArrayList<>();
        lt.add(t2);
        lt.add(t1);
       
        // Declaration des reseaux sociaux
        
        ReseauSocial r1 = new ReseauSocial("Facebook", "www.facebook.com/test", 1);
        ReseauSocial r2 = new ReseauSocial("Twitter", "www.twitter.com/test", 1);
        List<ReseauSocial> lr = new ArrayList<>();
        lr.add(r1);
        
        List<ReseauSocial> lr2 = new ArrayList<>();
        lr2.add(r2);
       
        
        // Declaratio de gallery
        List<String> lgal = new ArrayList<>();
        lgal.add("image1.jpg");
        lgal.add("image2.jpg");
        
        
        Propriete p = new Propriete(1,lg, lt, "email", "tirte", "slogan", "description",
                "logo", "cover", lgal, "emailOwner", "numTel", "siteWeb",lr, "adresse", 0, 0, le, lh);
        
        Propriete p2 = new Propriete(1,lg, lt, "emailss", "test", "slogan", "description",
                "logo", "cover", lgal, "emailOwner", "numTel123", "siteWeb",lr2, "adresse", 0, 0, le, lh);
        
        
        
        //ps.ajouterPropriete(p);
       // ps.modifierPropriete(p2);
        ResultSet rs = ps.afficherPropriete() ;
        while(rs.next()){
            System.out.println(rs.getInt("id")+" ; "+rs.getString("email")+" ; "
                    +rs.getString("titre")+" ; "+rs.getString("slogan")+" ; "+rs.getString("description")
            +" ; "+rs.getString("logo")+" ; "+rs.getString("cover")+" ; "+rs.getString("emailOwner")
            +" ; "+rs.getString("numTel")+" ; "+rs.getString("siteWeb")+" ; "+rs.getString("adresse")
            +" ; "+rs.getString("longitude")+" ; "+rs.getString("latitude"));
            
            System.out.println("*************Reseaux sociaux**************");
            
            ResultSet rsr=r.afficherReseau(1);
            while(rsr.next()){
                System.out.println(rsr.getString("reseau")+" ; "+rsr.getString("url"));
            }
            
            System.out.println("*************Horaire**************");

            ResultSet rsh=hs.afficherHoraire();
            while(rsh.next()){
                System.out.println(rsh.getString("jour")+" ; "+rsh.getString("ouverture")+
                " ; "+rsh.getString("fermeture")+" ; "+rsh.getString("on_off"));
            }
            
            System.out.println("*************categorie**************");
            
            ResultSet rsc=cs.afficherCategorie(1);
            while(rsc.next()){
                System.out.println(rsc.getString("nom"));
            }
            
            System.out.println("*************tag**************");
            
            ResultSet rst=ts.afficherTag(1);
            while(rst.next()){
                System.out.println(rst.getString("nom"));
            }
            
            
            
            
            
            
            }
        
       // ps.supprimerPropriete(2);
        }
        
    
    
}