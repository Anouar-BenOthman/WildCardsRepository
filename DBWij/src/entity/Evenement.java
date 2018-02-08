/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author WIJ
 */
public class Evenement 
{
    private int idEvent ;
    private String titre ;
    private Date date;
    private  String description;
    private String coverImage ;
    private String gallerie ;
    private  String lieu;
    private  String prix;
    private String categorie;
    private String emailOwner;
    private int numTelephoneOwner;
    private String nomOwner;

    public Evenement(int idEvent, String titre, Date date, String description, String gallerie, String lieu, String prix, String categorie, String emailOwner, int numTelephoneOwner, String nomOwner) {
        this.idEvent = idEvent;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.gallerie = gallerie;
        this.lieu = lieu;
        this.prix = prix;
        this.categorie = categorie;
        this.emailOwner = emailOwner;
        this.numTelephoneOwner = numTelephoneOwner;
        this.nomOwner = nomOwner;
        
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getGallerie() {
        return gallerie;
    }

    public String getLieu() {
        return lieu;
    }

    public String getPrix() {
        return prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getEmailOwner() {
        return emailOwner;
    }

    public int getNumTelephoneOwner() {
        return numTelephoneOwner;
    }

    public String getNomOwner() {
        return nomOwner;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setGallerie(String gallerie) {
        this.gallerie = gallerie;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
    }

    public void setNumTelephoneOwner(int numTelephoneOwner) {
        this.numTelephoneOwner = numTelephoneOwner;
    }

    public void setNomOwner(String nomOwner) {
        this.nomOwner = nomOwner;
    }
    public void setDate(String dateM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
