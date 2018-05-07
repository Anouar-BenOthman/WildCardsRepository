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
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.Utilisateur;




/**
 * The Login form
 *
 * @author Shai Almog
 */
public class inscriptionForm extends Form {
    
    static Utilisateur user=new Utilisateur();
    
    public inscriptionForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Inscription", "WelcomeWhite")      
        );
        Label er = new Label("");
        er.getAllStyles().setFgColor(0xff0000);
        Container erreur = FlowLayout.encloseCenter(er);
        
        Label erM = new Label("");
        erM.getAllStyles().setFgColor(0xff0000);
        Container errM = FlowLayout.encloseCenter(erM);
        
        Label erL = new Label("");
        erL.getAllStyles().setFgColor(0xff0000);
        Container errL = FlowLayout.encloseCenter(erL);
        
        Label erN = new Label("");
        erN.getAllStyles().setFgColor(0xff0000);
        Container errN = FlowLayout.encloseCenter(erN);
        
        Label erP = new Label("");
        erP.getAllStyles().setFgColor(0xff0000);
        Container errP = FlowLayout.encloseCenter(erP);
        
        Label erPr = new Label("");
        erPr.getAllStyles().setFgColor(0xff0000);
        Container errPr = FlowLayout.encloseCenter(erPr);
        getTitleArea().setUIID("Container");
        
        Image profilePic = theme.getImage("logo.png");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
               TextField nom = new TextField("", "nom", 20, TextField.EMAILADDR) ;
               nom.getAllStyles().setMargin(LEFT, 0);
        TextField prenom = new TextField("", "prenom", 20, TextField.EMAILADDR) ;
               TextField eMail = new TextField("", "eMail", 20, TextField.EMAILADDR) ;
        TextField tel = new TextField("", "telephone", 20, TextField.EMAILADDR) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button confirmButton = new Button("CONFIRMER");
        confirmButton.setUIID("LoginButton");
        
        
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
              nom,
              errN,
              prenom,
              errPr,
              eMail,
              errM,
              tel,
              //errT
              login,
              errL,
              password,
              errP,
              confirmButton,
              erreur
                
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
        
        confirmButton.addActionListener(l->{
            boolean valide2;
            if(nom.getText().equals("")){
                 erN.setText("champ Obligatoire");
                 valide2 = false;
             }
             else{
                 erN.setText("");
                 valide2 = true;
}
            boolean valide3;
            if(prenom.getText().equals("")){
                 erPr.setText("champ Obligatoire");
                 valide3 = false;
             }
             else{
                 erPr.setText("");
                 valide3 = true;
            }
            boolean valide4;
            if (login.getText().equals("")){
            
             erL.setText("champs Obligatoire");
                      valide4 = false;   
         }else{
                
           
                    ServiceUtilisateur su=new ServiceUtilisateur();
         Utilisateur u=su.getUserByLogin(login.getText());
         
         if (u.getNom()!=null)
         {
            erL.setText("login déja utilisée");
              erL.getAllStyles().setFgColor(0xff0000);
                      valide4 = false;
         }
         else{
             erL.setText("login valide");
            erL.getAllStyles().setFgColor(0x21ff00);
                      valide4 = true;
         }
            }
         
                boolean valide5;
                if(password.getText().equals("")){
                 erP.setText("champ Obligatoire");
                 valide5 = false;
             }
           else{
                 erP.setText("");  
               valide5 = true;
                
               }
 
                if(!(valide2&&valide3&&valide4&&valide5)){
                    er.setText("veuillez verifier");
                    
                    
                }
                else{
                    ServiceUtilisateur us=new ServiceUtilisateur();
                    
                    Utilisateur user2=new Utilisateur();
                    user2.setNom(nom.getText());
                    user2.setPrenom(prenom.getText());
                    user2.setLogin(login.getText());
                    user2.setPassword(password.getText());
                    user2.seteMail(eMail.getText());
                    user2.setNumTel(Integer.parseInt(tel.getText()));
                    user2.setAdresse("*Modifier ceci*");
                    user2.setBiographie("*Modifier ceci*");
                    int x1=user2.getNom().length();
                    int x2=user2.getPrenom().length();
                    int x=(x1+x2)*10000;
                    user2.setCodevalidation(x);
                    user2.setImage("user.JPG");
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    System.out.println(user2);
                    us.ajoutUser(user2);
                    er.setText("inscription reussite");
                   LoginForm lr = new LoginForm(theme);
                    lr.showBack();
                    
                }
                
                
                
                
                
                
//        String Email = eMail.getText();       
        
        
//         ServiceUtilisateur su1=new ServiceUtilisateur();
//         Utilisateur u=su1.getUserByEmail(Email);
//          if(!(isValid(Email))){
//             {erM.getAllStyles().setFgColor(0xff0000);
//             erM.setText("Entrer une format valide");
//                 boolean valide1 = false;
//             System.out.println(valide1);
//             } 
//         }else{
//              
//         if (u!=null)
//         {erM.getAllStyles().setFgColor(0xff0000);
//             erM.setText("Adresse déja utilisée");
//             boolean valide1 = false;
//}
//         else{
//             erM.setText("Adresse valide");
//              erM.getAllStyles().setFgColor(0x21ff00);
//             boolean valide1 = true;
//             
//         }
//         
//        }
             
         
                
                
                
        });
    }
    
//public static boolean isValid(String email)
//    {
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                            "[a-zA-Z0-9_+&*-]+)*@" +
//                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                            "A-Z]{2,7}$";
//                             
//        Pattern pat = Pattern.compile(emailRegex);
//        if (email == null)
//            return false;
//        return pat.matcher(email).matches();
//    }
}
