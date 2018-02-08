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
public class ReseauSocial {
    private String reseau;
    private String url;
    private int id_prop;

    public ReseauSocial(String reseau, String url, int id_prop) {
        this.reseau = reseau;
        this.url = url;
        this.id_prop = id_prop;
    }

    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
}
