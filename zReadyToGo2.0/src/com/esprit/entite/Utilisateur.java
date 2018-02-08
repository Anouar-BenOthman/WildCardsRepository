/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

/**
 *
 * @author lanwe
 */
public class Utilisateur {
  private int  	idUtilisateur ; 
    private String nom ; 
    private String prenom ;
    private int numTel  ;
    private String eMail; 
     private String dresse ;
     private String sexe;
     private String Biographie;
     private String login;
    private String  password;
    
    
    
    public Utilisateur( String nom, String prenom,String login ,String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password=password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + '}';
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getDresse() {
        return dresse;
    }

    public void setDresse(String dresse) {
        this.dresse = dresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getBiographie() {
        return Biographie;
    }

    public void setBiographie(String Biographie) {
        this.Biographie = Biographie;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur(int idUtilisateur, String nom, String prenom, int numTel, String eMail, String dresse, String sexe, String Biographie, String login, String password) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.eMail = eMail;
        this.dresse = dresse;
        this.sexe = sexe;
        this.Biographie = Biographie;
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }
    
 
    
    
    
}
