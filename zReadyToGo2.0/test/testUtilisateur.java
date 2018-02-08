package tests;

import com.esprit.entite.Utilisateur;
import com.esprit.util.DataSource;
import worshop0.services.UtilisateurService;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lanwe
 */
public class testUtilisateur {
    
    public static void main(String[] args) {
        DataSource ds =DataSource.getInstance();
         System.out.println("DS:\n"+ds+"\n connexion etablie");
         UtilisateurService uService = new UtilisateurService();
         
        System.out.println("***********************insertion utilisateur***********************");
         Utilisateur u1= new Utilisateur("ANOUAR","BENOTHMAN","login","pwd");
        uService.createPersonne(u1);
        
        System.out.println("***********************recuperation de tout les utilisateurs***********************");
        uService.getAllUtilisateur();
       
         System.out.println("***********************recuperation de l'utilisateur d'id=2 **********************");
        uService.getUtilisateurById(2);
        
        System.out.println("***********************update d **********************");
       u1.setIdUtilisateur(10);
        uService.updateUtilisateur(u1);
    }
    
}
