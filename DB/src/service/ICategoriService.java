/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
import entity.ReseauSocial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface ICategoriService {
    public boolean ajouterCategorie(Categorie c,int i) throws SQLException;
    public boolean modifierCategorie(Categorie c) throws SQLException;
    public ResultSet afficherCategorie(int idp) throws SQLException;
    public boolean supprimerCategorie(int idPropriete) throws SQLException ;
    
}
