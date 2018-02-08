/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
import entity.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface ITagService {
    public boolean ajouterTag(Tag t,int i) throws SQLException;
    public boolean modifierTag(Tag t) throws SQLException;
    public ResultSet afficherTag(int idp) throws SQLException;
    public boolean supprimerTag(int idPropriete) throws SQLException ;
    
}
