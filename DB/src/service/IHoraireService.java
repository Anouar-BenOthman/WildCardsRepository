/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Horaire;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface IHoraireService {
    public boolean ajouterHoraire(Horaire h,int i) throws SQLException;
    public boolean modifierHoraire(Horaire h) throws SQLException;
    public ResultSet afficherHoraire() throws SQLException;
    public boolean supprimerHoraire(int idProp) throws SQLException;
    
    
}
