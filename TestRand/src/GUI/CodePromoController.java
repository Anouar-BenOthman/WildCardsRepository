/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import testrand.Rand;

/**
 * FXML Controller class
 *
 * @author Aziz
 */
public class CodePromoController implements Initializable {

    @FXML
    private ImageView cover;
    @FXML
    private Label titre;
    @FXML
    private Label slogan;
    @FXML
    private ListView<?> view;
    @FXML
    private TextField txtCode2;
    @FXML
    private TextField txtCode4;
    @FXML
    private TextField txtCode5;
    @FXML
    private TextField txtCode3;
    @FXML
    private Button btnCode1;
    @FXML
    private Button btnCode2;
    @FXML
    private Button btnCode4;
    @FXML
    private Button btnCode3;
    @FXML
    private Button btnCode5;
    
    static String code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void VoirCode(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsulterPromo.fxml"));
            Parent root = loader.load();
           Scene homePageScene=new Scene(root); 
           Stage appStage =(Stage) ((Node) event.getSource()).getScene().getWindow(); 
           appStage.setScene(homePageScene); 
           appStage.show();
        
        Rand rand= new Rand();
        //txtCode.setText(rand.rand()+"");
        
    }

    //@FXML
    @FXML
    private void VoirCode2(ActionEvent event) {
        Rand rand= new Rand();
        txtCode2.setText(rand.rand()+"");
    }

    //@FXML
    @FXML
    private void VoirCode4(ActionEvent event) {
        Rand rand= new Rand();
        txtCode4.setText(rand.rand()+"");
    }

    //@FXML
    @FXML
    private void VoirCode3(ActionEvent event) {
        Rand rand= new Rand();
        txtCode3.setText(rand.rand()+"");
    }

    //@FXML
    @FXML
    private void VoirCode5(ActionEvent event) {
        Rand rand= new Rand();
        txtCode5.setText(rand.rand()+"");
    }
    
}
