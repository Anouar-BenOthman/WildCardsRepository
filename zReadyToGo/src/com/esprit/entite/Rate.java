/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

/**
 *
 * @author ghada
 */
public class Rate {
       private int idRate ; 
    private int idExperience; 
    private int rate ;
     private int idUser ;

    public Rate(int idRate, int idExperience, int rate, int idUser) {
        this.idRate = idRate;
        this.idExperience = idExperience;
        this.rate = rate;
        this.idUser = idUser;
    }

    public Rate(int idExperience, int rate, int idUser) {
        this.idExperience = idExperience;
        this.rate = rate;
        this.idUser = idUser;
    }

    public int getIdRate() {
        return idRate;
    }

    public int getIdExperience() {
        return idExperience;
    }

    public int getRate() {
        return rate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idRate;
        hash = 89 * hash + this.idExperience;
        hash = 89 * hash + this.rate;
        hash = 89 * hash + this.idUser;
        return hash;
    }

    @Override
    public String toString() {
        return "Rate{" + "idRate=" + idRate + ", idExperience=" + idExperience + ", rate=" + rate + ", idUser=" + idUser + '}';
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
        final Rate other = (Rate) obj;
        if (this.idRate != other.idRate) {
            return false;
        }
        if (this.idExperience != other.idExperience) {
            return false;
        }
        if (this.rate != other.rate) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    
}
