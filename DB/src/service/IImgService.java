/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public interface IImgService {
    public boolean ajouterImg(String url,int id) throws SQLException;
    public ResultSet afficherImg(int idp) throws SQLException;
    public boolean supprimerImg(int idPropriete) throws SQLException ;
    
}
