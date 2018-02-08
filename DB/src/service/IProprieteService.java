/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Propriete;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface IProprieteService {
    public boolean ajouterPropriete(Propriete p) throws SQLException;
    public boolean modifierPropriete(Propriete p) throws SQLException;
    public ResultSet afficherPropriete() throws SQLException;
    public ResultSet chercherPropriete(int idPropriete) throws SQLException ;
    public boolean supprimerPropriete(int idPropriete) throws SQLException ;
    public ResultSet chercherPropriete(String s) throws SQLException ;
    
}
