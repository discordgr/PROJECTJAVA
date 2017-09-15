/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class Diagnosis_MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button back;
    
    @FXML
    private Button new_patient;
    
    @FXML
    private Button new_diagnosis_on_existing_patient;
    
     @FXML
    private void diagnosisMenuActions(ActionEvent e) throws IOException
    {
        Stage stage;
        Scene scene;
        Parent root;
        if ( e.getSource() == new_patient )
        {
            stage = (Stage) new_patient.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Register_Patient.fxml"));
            scene = new Scene(root);    
            
            stage.setScene(scene);
            //stage.setMaxWidth(1024);
            //stage.setMaxHeight(768);
            stage.show();
        }
        else if ( e.getSource() == back )
        {
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            scene = new Scene(root);    
            
            stage.setX(0);
            stage.setY(0);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
