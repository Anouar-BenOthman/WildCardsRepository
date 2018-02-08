/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;




import java.util.Objects;

/**
 *
 * @author ghada
 */
public class Experience {
     private int idExperience ; 
    private String rateTitle ; 
    
     private String comment ;
      private int idUser ;
      

    public Experience(int idExperience, String rateTitle, String comment, int idUser) {
        this.idExperience = idExperience;
        this.rateTitle = rateTitle;
       
        this.comment = comment;
        this.idUser = idUser;
    }
      
     public Experience( String rateTitle, String comment, int idUser) {

        this.rateTitle = rateTitle;
       
        this.comment = comment;
        this.idUser = idUser;
    }
      

    
    

    public int getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    public String getRateTitle() {
        return rateTitle;
    }

    

    public String getComment() {
        return comment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setRateTitle(String rateTitle) {
        this.rateTitle = rateTitle;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idExperience;
        hash = 23 * hash + Objects.hashCode(this.rateTitle);
       
        hash = 23 * hash + Objects.hashCode(this.comment);
        hash = 23 * hash + Objects.hashCode(this.idUser);
        return hash;
    }

    @Override
    public String toString() {
        return "Experience{" + "idExperience=" + idExperience + ", rateTitle=" + rateTitle + ", comment=" + comment + ", idUser=" + idUser + '}';
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
        final Experience other = (Experience) obj;
        if (this.idExperience != other.idExperience) {
            return false;
        }
        if (!Objects.equals(this.rateTitle, other.rateTitle)) {
            return false;
        }
        
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        return true;
    }

    

  
    

   
    
}
