/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrand;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Aziz
 */
public class LeftPane extends VBox{
    
    Label LabelTitle= new Label("Profiltez de nos promotions");
    
    Button btnSave = new Button("Tous");
    Button btnUpdate = new Button("Codes");
    Button btnDelete = new Button("Promotions");
    Button btntest = new Button("Exclusif");
    
    public LeftPane()
    {
        btnSave.setPrefWidth(150);
        btnUpdate.setPrefWidth(150);
        btnDelete.setPrefWidth(150);
        btntest.setPrefWidth(150);
        
        LabelTitle.setStyle("-fx-font-size:27px;-fx-text-fill:#FFF");
        
        btnSave.setStyle("-fx-background-color:#f1c40f;-fx-font-size:18;-fx-text-fill:#FFF");
        btnUpdate.setStyle("-fx-background-color:#f1c40f;-fx-font-size:18;-fx-text-fill:#FFF");
        btnDelete.setStyle("-fx-background-color:#f1c40f;-fx-font-size:18;-fx-text-fill:#FFF");
        btntest.setStyle("-fx-background-color:#f1c40f;-fx-font-size:18;-fx-text-fill:#FFF");
        
        
        this.setStyle("-fx-background-color:#ff214f");
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(LabelTitle,btnSave,btnUpdate,btnDelete,btntest);
        
        
        
    }
    
    
    
}
