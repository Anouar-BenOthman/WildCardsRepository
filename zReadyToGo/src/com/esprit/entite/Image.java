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
public class Image {
  
     private int idImage; 
    private int idExperience; 
    private String image;

    public Image(int idImage, int idExperience, String image) {
        this.idImage = idImage;
        this.idExperience = idExperience;
        this.image = image;
    }

    public Image(int idExperience, String image) {
        this.idExperience = idExperience;
        this.image = image;
    }

    public int getIdImage() {
        return idImage;
    }

    public int getIdExperience() {
        return idExperience;
    }

    public String getImage() {
        return image;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idImage;
        hash = 97 * hash + this.idExperience;
        hash = 97 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public String toString() {
        return "Image{" + "idImage=" + idImage + ", idExperience=" + idExperience + ", image=" + image + '}';
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
        final Image other = (Image) obj;
        if (this.idImage != other.idImage) {
            return false;
        }
        if (this.idExperience != other.idExperience) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
  

    

}
