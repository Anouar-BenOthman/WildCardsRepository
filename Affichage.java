/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompagny.Service.ServiceTask;
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.Task;
import com.mycompany.Entite.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class Affichage {

    Form f;
    SpanLabel lb;
  
    public Affichage() {
        
        f = new Form();
        lb = new SpanLabel("aaaaaaaaaaa");
        f.add(lb);
        ServiceUtilisateur serviceTask=new ServiceUtilisateur();
        ArrayList<Utilisateur> lis=serviceTask.getList2();
        lb.setText(lis.toString());
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();  //pour l'image c'east autre chose
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
