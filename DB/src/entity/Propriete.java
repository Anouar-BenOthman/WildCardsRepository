/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Nidhal
 */
public class Propriete {
    private int id;

    public int getId() {
        return id;
    }
    private List<Categorie> categorie;
    private List<Tag> lstag;
    private String email;
    private String tirte;
    private String slogan;
    private String description;
    private String logo;
    private String cover;
    private List<String> gallerie;
    private String emailOwner;
    private String numTel;
    private String siteWeb;
    private List<ReseauSocial> rs;
    private String adresse;
    private float latitude;
    private float longitude;
    private List<Equipement> lsequi;
    private List<Horaire> lshr;

    public List<Categorie> getCategorie() {
        return categorie;
    }

    public Propriete(int id,List<Categorie> categorie, List<Tag> lstag, String email, String tirte, String slogan, String description, String logo, String cover, List<String> gallerie, String emailOwner, String numTel, String siteWeb, List<ReseauSocial> rs, String adresse, float latitude, float longitude, List<Equipement> lsequi, List<Horaire> lshr) {
        this.id = id;
        this.categorie = categorie;
        this.lstag = lstag;
        this.email = email;
        this.tirte = tirte;
        this.slogan = slogan;
        this.description = description;
        this.logo = logo;
        this.cover = cover;
        this.gallerie = gallerie;
        this.emailOwner = emailOwner;
        this.numTel = numTel;
        this.siteWeb = siteWeb;
        this.rs = rs;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lsequi = lsequi;
        this.lshr = lshr;
    }

    public Propriete(String email, String tirte, String slogan, String description, String logo, String cover, String emailOwner, String numTel, String siteWeb, String adresse, float latitude, float longitude) {
        this.email = email;
        this.tirte = tirte;
        this.slogan = slogan;
        this.description = description;
        this.logo = logo;
        this.cover = cover;
        this.emailOwner = emailOwner;
        this.numTel = numTel;
        this.siteWeb = siteWeb;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setCategorie(List<Categorie> categorie) {
        this.categorie = categorie;
    }

    public List<Tag> getLstag() {
        return lstag;
    }

    public void setLstag(List<Tag> lstag) {
        this.lstag = lstag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTirte() {
        return tirte;
    }

    public void setTirte(String tirte) {
        this.tirte = tirte;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<String> getGallerie() {
        return gallerie;
    }

    public void setGallerie(List<String> gallerie) {
        this.gallerie = gallerie;
    }

    public String getEmailOwner() {
        return emailOwner;
    }

    public void setEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public List<ReseauSocial> getRs() {
        return rs;
    }

    public void setRs(List<ReseauSocial> rs) {
        this.rs = rs;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public List<Equipement> getLsequi() {
        return lsequi;
    }

    public void setLsequi(List<Equipement> lsequi) {
        this.lsequi = lsequi;
    }

    public List<Horaire> getLshr() {
        return lshr;
    }

    public void setLshr(List<Horaire> lshr) {
        this.lshr = lshr;
    }
    
    
    
    
}
