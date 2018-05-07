/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Historique;
import com.mycompany.Entite.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceHistorique {

    
    

    public ArrayList<Historique> getListHistorique(int idUser) {
        ArrayList<Historique> listHistoriques = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/findHistorique/"+idUser);
        System.out.println(idUser);
       
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> historiques = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)
                    System.out.println(historiques);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) historiques.get("root");   //ca va parcourer[key,valeu] = id,1
                    
                    for (Map<String, Object> obj : list) {
                       
                      
                        Historique historique = new Historique();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float logitude = Float.parseFloat(obj.get("longitude").toString());
                        float latitude = Float.parseFloat(obj.get("latitude").toString());
                        historique.setAdresse(obj.get("adresse").toString());
                        historique.setNomProp(obj.get("nomProp").toString());
                        historique.setId((int) id);
                        historique.setLongitude(logitude);
                        historique.setLatitude(latitude);
                        System.out.println(historique);
                        listHistoriques.add(historique);

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listHistoriques;
    }
    
    
    public void ajoutHistoriquee(Historique ta) {
        ConnectionRequest con = new ConnectionRequest();
        int i=com.mycompany.gui.LoginForm.user.getIdUtilisateur();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/newHistorique?idUser="+com.mycompany.gui.LoginForm.user.getIdUtilisateur()+"&idPropriete=" +  ta.getIdPropriete()+"&nomProp=" +  ta.getNomProp()+"&longitude=" +  ta.getLongitude()+"&latitude=" +  ta.getLatitude()+"&adresse=" +  ta.getAdresse();
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }
    
    public void suppHistoriquee(Historique ta) {
        ConnectionRequest con = new ConnectionRequest();
        int i=com.mycompany.gui.LoginForm.user.getIdUtilisateur();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/deleteH/"+com.mycompany.gui.LoginForm.user.getIdUtilisateur()+"/"+ta.getIdPropriete();
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }

}
