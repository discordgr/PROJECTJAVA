/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class Symptom_DataController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private TableView<Symptom> symptomsTable;
    
    @FXML
    private TableColumn<Symptom,String> nameColumn;
   
    @FXML
    private TableColumn<Symptom,String> categoryColumn;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button diagnose;
    
    public LoginModel loginModelSymptomsTable = new LoginModel();
    
    @FXML
    private void cancelAction(ActionEvent e) throws Exception{
        Stage stage;
        Scene scene;
        Parent root;
        if ( e.getSource() == cancel ) {
            stage = (Stage) cancel.getScene().getWindow();
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
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        symptomsTable.setItems(loginModelSymptomsTable.selectSymptomValue());
        
    }    
    
}
