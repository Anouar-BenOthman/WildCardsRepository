/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Propriete;
import entity.ReseauSocial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface IReseauSocialService {
    public boolean ajouterReseau(ReseauSocial r,int i) throws SQLException;
    public boolean modifierReseau(ReseauSocial r) throws SQLException;
    public ResultSet afficherReseau(int idp) throws SQLException;
    public boolean supprimerPropriete(int idPropriete) throws SQLException ;
    
}
