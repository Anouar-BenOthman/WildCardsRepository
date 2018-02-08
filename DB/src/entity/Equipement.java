/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nidhal
 */
public class Equipement {
    private String nom;
    private int id_prop;

    @Override
    public String toString() {
        return "Equipement{" + "nom=" + nom + ", id_prop=" + id_prop + '}';
    }

    public Equipement(String nom, int id_prop) {
        this.nom = nom;
        this.id_prop = id_prop;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
}
