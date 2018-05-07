/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceHistorique;
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.Historique;
import com.mycompany.Entite.Utilisateur;
import static com.mycompany.gui.LoginForm.user;
import java.util.ArrayList;



/**
 * The Login form
 *
 * @author Shai Almog
 */
public class historiqueForm extends Form {
    
    
    
    public historiqueForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome to, ", "WelcomeWhite"),
                new Label("ReadyToGo", "WelcomeBlue")
        );
        Label er = new Label("");
        er.getAllStyles().setFgColor(0xff0000);
        Container erreur = FlowLayout.encloseCenter(er);
        
        
        
        getTitleArea().setUIID("Container");
        
        Image profilePic = theme.getImage("logo.png");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button loginButton = new Button("retour");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
                  
         ProfileForm profil=new ProfileForm(theme);
            profil.show();
            
        });
        
        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
        
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
         ServiceHistorique sh=new ServiceHistorique();
        System.out.println("waaaaaaaa");
        System.out.println(user.getNom());
        ArrayList<Historique> listHistorique = sh.getListHistorique(user.getIdUtilisateur());
        
        Form hi = new Form("Mon Historique");
        hi.setLayout(new BorderLayout());
        final MapContainer cnt = new MapContainer();
        hi.addComponent(BorderLayout.CENTER, cnt);
        hi.addCommand(new Command("Move Camera") {
            public void actionPerformed(ActionEvent ev) {
                cnt.setCameraPosition(new Coord(-33.867, 151.206));
            }
        });
        
                 // since the image is iin the jar this is unlikely
                
                for (Historique h : listHistorique ){
                cnt.addMarker(null, new Coord(h.getLongitude(), h.getLatitude()), "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show(h.getNomProp(), h.getAdresse(), "RETOUR", null);
                        cnt.setCameraPosition(new Coord(25, 25));
                    }
                });
                }
        
     
        Container by = BoxLayout.encloseY(
               loginButton,
                 hi
                
                
               
        );
        add(BorderLayout.CENTER_BEHAVIOR_SCALE, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
        
        loginButton.addActionListener(l->{
            ServiceUtilisateur su=new ServiceUtilisateur();
            if (login.getText().equals("")){
                er.setText("veuiller saisir votre login");
            }
            else if (password.getText().equals("")){
                er.setText("veuiller saisir votre mot de passe");
            }
            else{
                user=su.getUser(login.getText(),password.getText());
                if (user.getNom()==null)
                {
                er.setText("veuillez verifier vos informations");
                
                }
                else{
                    er.setText("bienvenue "+user.getNom());
                    
                    ProfileForm inscri=new ProfileForm(theme);
            inscri.show();
                }
            }
            
            
        });
        
        createNewAccount.addActionListener(l->{
            inscriptionForm inscri=new inscriptionForm(theme);
            inscri.show();
        });
    
    
    }
}
