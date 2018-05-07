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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceTask {

    public void ajoutTask(Task ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/tasks/new?name="+ta.getNom() +"&status=" +  ta.getEtat();
        con.setUrl(Url);

        System.out.println(Url);

        con.addResponseListener(e -> {                             //listner on success
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone
    }
    

    public ArrayList<Task> getList2() {
        ArrayList<Task> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/api/tasks/all");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();  //parser son role est extraire les donnée  //le serveur peut retourner chaine de caractere or il est plus facile de recupérer par le JSONparseur
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));  //retourne tableau d'octer (byte)
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");   //ca va parcourer[key,valeu] = id,1
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Task task = new Task();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setEtat(obj.get("status").toString());
                        task.setNom(obj.get("name").toString());
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }
                
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

}
