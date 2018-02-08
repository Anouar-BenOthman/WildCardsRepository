/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Equipement;
import entity.Propriete;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface IEquipementService {
    public boolean ajouterEquipement(Equipement e,int i) throws SQLException;
    public boolean modifierEquipement(Equipement e) throws SQLException;
    public ResultSet afficherEquipement() throws SQLException;
    public boolean supprimerequipement(int idEquipement) throws SQLException ;
    
    
}
