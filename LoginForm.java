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

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.Utilisateur;
import com.twilio.rest.api.v2010.account.Call;
import java.net.URI;
import java.net.URISyntaxException;



/**
 * The Login form
 *
 * @author Shai Almog
 */
public class LoginForm extends Form {
    private final static String ACCOUNT_SID = "AC4a0db2a20efd85a403f8116e8d7631c3";
    private final static String AUTH_TOKEN = "32737805adfd34e8556fe8c2e8b64ef0";
    public static Utilisateur user=new Utilisateur();
    
    public LoginForm(Resources theme) {
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
        
        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
                  
       
            
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
        
        
        Container by = BoxLayout.encloseY(
               
                welcome,
                            
                profilePicLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                spaceLabel,
                erreur,
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
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
//                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//                        Message message = Message.creator(
//                                new PhoneNumber("+21699791227" ), // To number
//                                new PhoneNumber("+12563054745"), // From number
//                             "test"   ).create();
//                        System.out.println(message.getSid());

//try {
//                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//                            
//                            String from = "+12563054745";
//                            String to = "++21653575511";
//                            
//                            Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
//                                    new URI("http://demo.twilio.com/docs/voice.xml")).create();
//                            
//                            System.out.println(call.getSid());
//                        } catch (URISyntaxException ex) {
//                        }
                       if(user.getCodevalidation()==1){
                           
                       
                    ProfileForm profil=new ProfileForm(theme);
            profil.show();
                       }else{
                     validationForm af=new validationForm(theme);
                     af.show();
                           
                           
                       }
            
            
                }
            }
            
            
        });
        
        createNewAccount.addActionListener(l->{
            inscriptionForm inscri=new inscriptionForm(theme);
            inscri.show();
        });
    
    
    }
}
