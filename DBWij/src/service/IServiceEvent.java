/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Evenement;

/**
 *
 * @author WIJ
 */
public interface IServiceEvent {
    public void ajouterEvent(Evenement e);
    public void modifierEvent(Evenement e,int id);
    public void supprimerEvent(int id);
    
}
