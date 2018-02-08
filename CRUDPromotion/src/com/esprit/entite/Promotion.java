/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aziz
 */
public class Promotion {
    private int id_promotion;
    private String marque;
    private String categorie;
    private int pourcentage;
    private String model;
    private String date_debut;
    private String date_fin;
    private String image;

    public Promotion(int id_promotion, String marque, String categorie, int pourcentage, String model, String date_debut, String date_fin, String image) {
        this.id_promotion = id_promotion;
        this.marque = marque;
        this.categorie = categorie;
        this.pourcentage = pourcentage;
        this.model = model;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.image = image;
    }

    public Promotion(String marque, String categorie, int pourcentage, String model, String date_debut, String date_fin, String image) {
        this.marque = marque;
        this.categorie = categorie;
        this.pourcentage = pourcentage;
        this.model = model;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.image = image;
    }

    public Promotion(String anouar, String benothman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_promotion;
        hash = 67 * hash + Objects.hashCode(this.marque);
        hash = 67 * hash + Objects.hashCode(this.categorie);
        hash = 67 * hash + this.pourcentage;
        hash = 67 * hash + Objects.hashCode(this.model);
        hash = 67 * hash + Objects.hashCode(this.date_debut);
        hash = 67 * hash + Objects.hashCode(this.date_fin);
        hash = 67 * hash + Objects.hashCode(this.image);
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
        final Promotion other = (Promotion) obj;
        if (this.id_promotion != other.id_promotion) {
            return false;
        }
        if (this.pourcentage != other.pourcentage) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promotion=" + id_promotion + ", marque=" + marque + ", categorie=" + categorie + ", pourcentage=" + pourcentage + ", model=" + model + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", image=" + image + '}';
    }

    public String get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
