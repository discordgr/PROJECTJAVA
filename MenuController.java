/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.*;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class MenuController implements Initializable 
{

    public LoginModel loginmodel = new LoginModel();
    
    @FXML
    private Button new_patient;
    
    @FXML
    private Button patient_archive;
    
    @FXML 
    private Button statistic_data;
    
    @FXML
    private Button help;
    
    @FXML
    private Button exit;
    
    @FXML
    private void menuActions(ActionEvent e) throws IOException
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
        else if ( e.getSource() == patient_archive ){
            stage = (Stage) patient_archive.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Patient_Data.fxml"));
            scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        }
        else if ( e.getSource() == exit ){
            stage = (Stage) exit.getScene().getWindow();
            stage.close();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if ( loginmodel.isDbConnected() ){
            System.out.println("Connection to Database Established!");
            //loginmodel.insertValue();
            //loginmodel.selectValue();
        }
        else{
            System.out.println("Connection to Database Failed!");
        }
    } 
    
}
