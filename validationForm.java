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
import static com.mycompany.gui.LoginForm.user;




/**
 * The Login form
 *
 * @author Shai Almog
 */
public class validationForm extends Form {
    
    
    
    public validationForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Validation", "WelcomeWhite")      
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
        
        Label erC = new Label("");
        erC.getAllStyles().setFgColor(0xff0000);
        Container errC = FlowLayout.encloseCenter(erC);
        
        Label l1 = new Label("");
        l1.getAllStyles().setFgColor(0x21ff00);
        Container L1 = FlowLayout.encloseCenter(l1);
        l1.setText("veuillez saisir votre code");
        Label l2 = new Label("");
        l2.getAllStyles().setFgColor(0x21ff00);
        Container L2 = FlowLayout.encloseCenter(l2);
        l2.setText("de validation");
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
               TextField code = new TextField("", "code", 20, TextField.EMAILADDR) ;
               code.getAllStyles().setMargin(LEFT, 0);
        TextField prenom = new TextField("", "prenom", 20, TextField.EMAILADDR) ;
               TextField eMail = new TextField("", "eMail", 20, TextField.EMAILADDR) ;
        
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
              L1,
              L2,
              code,
              errC, 
              confirmButton,
              erreur
                
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
        
        
        
        
        
        confirmButton.addActionListener(l->{
            ServiceUtilisateur su=new ServiceUtilisateur();
           
            System.out.println(code.getText());
            System.out.println(user.getCodevalidation());
            if(code.getText().equals(""+user.getCodevalidation())){
                 er.setText("code correcte");
                 su.MofifiercodeUser(user, 1);
                 
             }
             else{
                 er.setText("code incorrecte");               
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
