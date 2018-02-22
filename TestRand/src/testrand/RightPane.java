/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrand;

import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Aziz
 */
public class RightPane extends VBox{
    
    HBox test= new HBox();
    HBox test2= new HBox();
    
    
    
    HBox ligne1= new HBox();
    HBox ligne2= new HBox();
    HBox ligne3= new HBox();
    HBox ligne4= new HBox();
    
    HBox pane11= new HBox();
    HBox pane12=new HBox();
    
    HBox pane21= new HBox();
    HBox pane22=new HBox();
    
    HBox pane31= new HBox();
    HBox pane32=new HBox();
    
    HBox pane41= new HBox();
    HBox pane42=new HBox();
    
    Button btncode= new Button("Voir le code");
    Button btncode2= new Button("Voir le code");
    Button btncode3= new Button("Voir le code");
    Button btncode4= new Button("Voir le code");
    Button btncode5= new Button("Test");
    
    Button btnSave1 = new Button("Tous");
    Button btnUpdate1 = new Button("Codes");
    Button btnDelete1 = new Button("Promotions");
    Button btntest1 = new Button("Exclusif");
    
    Label Labelpr= new Label("    20% \n  SOLDES \npromotion");
    Label Labeltext= new Label("Profilter de 20% de promotion avec zara\nCliquer sur le bouton voir le code\npour consulter votre code");
    
    Label Labelpr2= new Label("    30% \n OFFERTS \npromotion");
    Label Labeltext2= new Label("Profilter de 30% de promotion avec Celio\nCliquer sur le bouton voir le code\npour consulter votre code");
    
    Label Labelpr3= new Label("    50% \n OFFERTS \npromotion");
    Label Labeltext3= new Label("Profilter de 50% de promotion avec H&M\nCliquer sur le bouton voir le code\npour consulter votre code");
    
    Label Labelpr4= new Label("    45% \n OFFERTS \npromotion");
    Label Labeltext4= new Label("Profilter de 45% de promotion avec HA\nCréer sur la bouton voir le code\npour consulter votre code");
    
    Label Labeltitre= new Label("Les meilleurs codes promo en Février 2018");
    
    TextField txtcode= new TextField();
    TextField txtcode2= new TextField();
    TextField txtcode3= new TextField();
    TextField txtcode4= new TextField();
    
    public RightPane()
    {
        
        
        pane11.setSpacing(20);
        pane11.setPadding(new Insets(20));
        
        pane12.setSpacing(20);
        pane12.setPadding(new Insets(20));
        
        pane21.setSpacing(20);
        pane21.setPadding(new Insets(20));
        
        pane22.setSpacing(20);
        pane22.setPadding(new Insets(20));
        
        pane31.setSpacing(20);
        pane31.setPadding(new Insets(20));
        
        pane32.setSpacing(20);
        pane32.setPadding(new Insets(20));
        
        pane41.setSpacing(20);
        pane41.setPadding(new Insets(20));
        
        pane42.setSpacing(20);
        pane42.setPadding(new Insets(20));
        
        ligne1.setSpacing(10);
        ligne1.setPadding(new Insets(10));
        
        ligne2.setSpacing(10);
        ligne2.setPadding(new Insets(10));
        
        ligne3.setSpacing(10);
        ligne3.setPadding(new Insets(10));
        
        ligne4.setSpacing(10);
        ligne4.setPadding(new Insets(10));
        
        
        
        pane12.setAlignment(Pos.CENTER);
        pane22.setAlignment(Pos.CENTER);
        pane32.setAlignment(Pos.CENTER);
        pane42.setAlignment(Pos.CENTER);
        
        
        pane11.setStyle("-fx-background-color:#ff214f");
        pane21.setStyle("-fx-background-color:#ff214f");
        pane31.setStyle("-fx-background-color:#ff214f");
        pane41.setStyle("-fx-background-color:#ff214f");
        
        Labelpr.setStyle("-fx-font-size:18px");
        Labeltext.setStyle("-fx-font-size:18px;-fx-text-fill:#FFF");
        
        Labelpr2.setStyle("-fx-font-size:18px;-fx-font-style:italique");
        Labeltext2.setStyle("-fx-font-size:18px;-fx-text-fill:#FFF");
        
        Labelpr3.setStyle("-fx-font-size:18px");
        Labeltext3.setStyle("-fx-font-size:18px;-fx-text-fill:#FFF");
        
        Labelpr4.setStyle("-fx-font-size:18px");
        Labeltext4.setStyle("-fx-font-size:18px;-fx-text-fill:#FFF");
        
        Labeltitre.setStyle("-fx-font-size:28px");
        
        test2.getChildren().add(btncode5);
        test2.setAlignment(Pos.BASELINE_RIGHT);
        
        
        pane11.getChildren().addAll(Labeltext,btncode,txtcode);
        pane12.getChildren().add(Labelpr);
        
        pane21.getChildren().addAll(Labeltext2,btncode2,txtcode2);
        pane22.getChildren().add(Labelpr2);
        
        pane31.getChildren().addAll(Labeltext3,btncode3,txtcode3);
        pane32.getChildren().add(Labelpr3);
        
        pane41.getChildren().addAll(Labeltext4,btncode4,txtcode4);
        pane42.getChildren().add(Labelpr4);
        
        ligne1.getChildren().addAll(pane12,pane11);
        ligne2.getChildren().addAll(pane22,pane21);
        ligne3.getChildren().addAll(pane32,pane31);
        ligne4.getChildren().addAll(pane42,pane41);
        
        test.getChildren().addAll(btnSave1,btnUpdate1,btnDelete1,btntest1);
        
        test.setAlignment(Pos.BASELINE_LEFT);
        test.setStyle("-fx-background-color:#bdc3c7");
        
        
        this.getChildren().addAll(Labeltitre,test,ligne1,ligne2,ligne3);
        
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        
        
        
        
        
        
        btncode.setOnMouseClicked(e->{
            
           Rand rand= new Rand();
           
           TestRand.rightpane.txtcode.setText(rand.rand()+"");
            
        });
        
        btncode2.setOnMouseClicked(e->{
            
           Rand rand= new Rand();
           
           TestRand.rightpane.txtcode2.setText(rand.rand()+"");
            
        });
        
        btncode3.setOnMouseClicked(e->{
            
           Rand rand= new Rand();
           
           TestRand.rightpane.txtcode3.setText(rand.rand()+"");
            
        });
        
        btncode4.setOnMouseClicked(e->{
            
           Rand rand= new Rand();
           
           TestRand.rightpane.txtcode4.setText(rand.rand()+"");
            
        });
        
        
        
        
    }
    
}
