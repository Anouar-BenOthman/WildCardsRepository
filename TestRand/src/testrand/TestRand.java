/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrand;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Aziz
 */
public class TestRand extends Application{
    LeftPane leftpane= new LeftPane();
    static RightPane rightpane= new RightPane();
    
    Rand rand= new Rand();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        launch();
        
        
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        HBox main= new HBox();
        
        main.getChildren().addAll(leftpane,rightpane);
        
        //TextField txt = new TextField();
        //txt=rand.rand();
        
        //txt.setText(rand.rand()+"");
        
        //StackPane stackpane= new StackPane();
        
        //stackpane.getChildren().add(txt);
            
            
        Scene scene=new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
