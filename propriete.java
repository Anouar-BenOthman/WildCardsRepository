/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.OnOffSwitch;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompagny.Service.ServiceHistorique;
import com.mycompany.Entite.Historique;
import static com.mycompany.myapp.MyApplication.theme;

/**
 *
 * @author mosla
 */
public class propriete extends Layout {


    private Button btn;

    public propriete() {
    
       
        btn = new Button("ok");
        
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
      
       
        
        Label label = new Label("Hafoud : deja visité ?");
        OnOffSwitch s = new OnOffSwitch();
        Container cc = new Container();
        cc.add(label);
        cc.add(s);
        f.add(cc);
        
        Label label1 = new Label("pizza diese : deja visité ?");
        OnOffSwitch s1 = new OnOffSwitch();
        Container c1 = new Container();
        c1.add(label1);
        c1.add(s1);
        f.add(c1);
        
        Historique H1=new Historique();
        H1.setAdresse("Petite Ariana,Tunis");
        H1.setLongitude((float)25.0);
        H1.setLatitude((float)25.0);
        H1.setNomProp("Hafood");
        H1.setIdPropriete(1);
       
        Historique H2=new Historique();
        H2.setAdresse("Petite Ariana,Tunis");
        H2.setLongitude((float)26.0);
        H2.setLatitude((float)26.0);
        H2.setNomProp("Comme Chez Toi");
        H2.setIdPropriete(2); 
        

        
        f.add(btn);
         btn.setUIID("LoginButton");
         
         btn.addActionListener(l->{
             ServiceHistorique hs=new ServiceHistorique();
             if (s.isValue())
                {
                    hs.ajoutHistoriquee(H1);
                }
             else{
                 hs.suppHistoriquee(H1);
             }
             
              if (s.isValue())
                {
                    hs.ajoutHistoriquee(H2);
                }
             else{
                 hs.suppHistoriquee(H2);
             }
             
             
             
             
             
              ProfileForm profil = new ProfileForm(theme);
                         profil.show();
             
             
         });
        
        
     
        }
    }

