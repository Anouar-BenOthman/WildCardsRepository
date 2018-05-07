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
import com.mycompany.Entite.Task;
import com.mycompany.Entite.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceUtilisateur {

    
    

    public ArrayList<Utilisateur> getList2() {
        ArrayList<Utilisateur> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/allU");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");   //ca va parcourer[key,valeu] = id,1
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Utilisateur task = new Utilisateur();
                        
                        task.setNom(obj.get("nom").toString());
                        task.setPrenom(obj.get("prenom").toString());
                        
                            
                             listTasks.add(task);
                        
                     
                       

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    public Utilisateur getUser(String login,String password) {
        Utilisateur user = new Utilisateur();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/findU/"+login+"/"+password);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");   //ca va parcourer[key,valeu] = id,1
                    for (Map<String, Object> obj : list) {
                        
                        float idU = Float.parseFloat(obj.get("id").toString());
                        user.setIdUtilisateur((int) idU);
                        System.out.println(user.getIdUtilisateur());
                        user.setNom(obj.get("nom").toString());
                        user.setPrenom(obj.get("prenom").toString());
                        
                        float tel = Float.parseFloat(obj.get("numTel").toString());
                        user.setNumTel((int) tel);
                        
                        user.seteMail(obj.get("eMail").toString());
                        user.setAdresse(obj.get("adresse").toString());
                        
                        user.setBiographie(obj.get("biographie").toString());
                        user.setLogin(obj.get("login").toString());
                        user.setPassword(obj.get("password").toString());
                        float code = Float.parseFloat(obj.get("code").toString());
                        user.setCodevalidation((int) code);
                        user.setImage(obj.get("image").toString());
                        float etat = Float.parseFloat(obj.get("etat").toString());
                        user.setEtat((int) etat);
                        
                        
                            
                             
                        
                     
                       

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return user;
    }

    public Utilisateur getUserByLogin(String login) {
        Utilisateur user = new Utilisateur();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/findUByLogin/"+login);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");   //ca va parcourer[key,valeu] = id,1
                    for (Map<String, Object> obj : list) {
                        
                        
                        
                        user.setNom(obj.get("nom").toString());
                        user.setPrenom(obj.get("prenom").toString());
                        float tel = Float.parseFloat(obj.get("numTel").toString());
                        user.setNumTel((int) tel);
                        user.seteMail(obj.get("eMail").toString());
                        user.setAdresse(obj.get("adresse").toString());
                        user.setSexe(obj.get("sexe").toString());
                        user.setBiographie(obj.get("biographie").toString());
                        user.setLogin(obj.get("login").toString());
                        user.setPassword(obj.get("password").toString());
                        float code = Float.parseFloat(obj.get("code").toString());
                        user.setCodevalidation((int) code);
                        user.setImage(obj.get("image").toString());
                        float etat = Float.parseFloat(obj.get("etat").toString());
                        user.setEtat((int) etat);
                       
                            
                             
                        
                     
                       

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(user);
        return user;
    }
    
    
    public Utilisateur getUserByEmail(String email) {
        Utilisateur user = new Utilisateur();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/findUByEmail/"+email);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");   //ca va parcourer[key,valeu] = id,1
                    for (Map<String, Object> obj : list) {
                        
                        
                        
                        user.setNom(obj.get("nom").toString());
                        user.setPrenom(obj.get("prenom").toString());
                        float tel = Float.parseFloat(obj.get("numTel").toString());
                        user.setNumTel((int) tel);
                        user.seteMail(obj.get("eMail").toString());
                        user.setAdresse(obj.get("adresse").toString());
                        user.setSexe(obj.get("sexe").toString());
                        user.setBiographie(obj.get("biographie").toString());
                        user.setLogin(obj.get("login").toString());
                        user.setPassword(obj.get("password").toString());
                        float code = Float.parseFloat(obj.get("code").toString());
                        user.setCodevalidation((int) code);
                        user.setImage(obj.get("image").toString());
                        float etat = Float.parseFloat(obj.get("etat").toString());
                        user.setEtat((int) etat);
                       
                            
                             
                        
                     
                       

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(user);
        return user;
    }
    
    
    
    public void ajoutUser(Utilisateur u) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/newU?nom="+u.getNom()+"&prenom="+u.getPrenom()+"&login="+u.getLogin()+"&password="+u.getPassword()+"&eMail="+u.geteMail()+"&code="+u.getCodevalidation()+"&numtel="+u.getNumTel();
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }

    public void MofifierUser(Utilisateur u) {
          ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/modifU/"+u.getIdUtilisateur()+"?nom="+u.getNom()+"&prenom="+u.getPrenom()+"&login="+u.getLogin()+"&password="+u.getPassword()+"&eMail="+u.geteMail()+"&adresse="+u.getAdresse()+"&Biographie="+u.getBiographie()+"&numTel="+u.getNumTel();
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }
    
    
    public void MofifiercodeUser(Utilisateur u,int code) {
          ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/modifCodeU/"+u.getIdUtilisateur()+"?code="+code;
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }
}
