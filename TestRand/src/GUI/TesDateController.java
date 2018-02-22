/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author Aziz
 */
public class TesDateController implements Initializable {

    @FXML
    private DatePicker DD;
    @FXML
    private DatePicker DF;
    @FXML
    private TextField msg;
    @FXML
    private Button save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date date1 = (Date) sdf.parse(DD.getValue().toString());
        //Date date2 = (Date) sdf.parse(DF.getValue().toString());
        
        //System.out.println("date1 : " + sdf.format(date1));
        //System.out.println("date2 : " + sdf.format(date2));

        if (DD.getValue().compareTo(DF.getValue()) > 0) {
            System.out.println("Date1 is after Date2");
            msg.setText("Valeur illogique");
        } else if (DD.getValue().compareTo(DF.getValue()) < 0) {
            System.out.println("Date1 is before Date2");
            msg.setText("Valeur logique");
        } else if (DD.getValue().compareTo(DF.getValue()) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }
        
    }
    
}
