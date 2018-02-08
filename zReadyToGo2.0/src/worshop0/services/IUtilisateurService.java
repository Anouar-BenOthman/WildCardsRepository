/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worshop0.services;

import com.esprit.entite.Utilisateur;
import java.util.List;

/**
 *
 * @author lanwe
 */
public interface IUtilisateurService {
    
    public void createPersonne(Utilisateur p);
    public List <Utilisateur> getAllUtilisateur();
    public Utilisateur getUtilisateurById (int id);
    public boolean deleteUtilisateur(int id);
    public boolean updateUtilisateur (Utilisateur p);
    public boolean updateUtilisateur (int p);
}
