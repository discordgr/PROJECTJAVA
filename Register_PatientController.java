/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class Register_PatientController implements Initializable {

    ObservableList<String> familyStatusList = FXCollections.observableArrayList("Άγαμος","Έγγαμος","Χήρος","Διαζευγμένος","Σε σχέση","Αρραβωνιασμένος");
    ObservableList<String> genderList = FXCollections.observableArrayList("Άνδρας","Γυναίκα","Άλλο");
    ObservableList<String> educationList = FXCollections.observableArrayList("Δημοτικό","Γυμνάσιο","Λύκειο","ΑΕΙ","ΤΕΙ","ΤΕΕ","Μεταπτυχιακό","Διδακτορικό","Άλλο");
    
    //public LoginModel store;
    public LoginModel loginmodel2 = new LoginModel();
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField age;
    
    @FXML
    private ChoiceBox genderBox;
    
    @FXML
    private ChoiceBox familyStatusBox;
    
    @FXML
    private ChoiceBox educationBox;
    
    @FXML
    private Button cancel1;
    
    @FXML
    private Button save1;
    
    @FXML
    private Button cancel2;
    
    @FXML
    private Button cancel3;
    
    @FXML
    private Button Continue;
    
    @FXML
    private RadioButton yes;
    
    @FXML
    private ToggleGroup Kids;
    @FXML
    private ToggleGroup Tropos_gennisis;
    @FXML
    private ToggleGroup Tropos_gennisis1;
    @FXML
    private ToggleGroup Tropos_gennisis11;

    /**
     * Initializes the controller class.
     */
    //@FXML
    /*public void storePatientData(ActionEvent e) throws Exception{
        String sql = "INSERT INTO patient(firstname,lastname,age,gender,familystatus) VALUES(?,?,?,?,?)";
        
        if (e.getSource() == save1 ){
            try(  PreparedStatement pstmt = store.connection.prepareStatement(sql)) {
                 pstmt.setString(1, firstName.getText() );
                 pstmt.setString(2, lastName.getText() );
                 pstmt.setInt(3, Integer.parseInt(age.getText()) );
                 pstmt.setString(4, genderBox.getSelectionModel().getSelectedItem().toString());
                 pstmt.setString(5, familyStatusBox.getSelectionModel().getSelectedItem().toString());
                 pstmt.executeUpdate();
            }catch (SQLException er) {
            System.out.println(er.getMessage());
            }
        }
    }*/
    
    
    @FXML
    public void cancelAction(ActionEvent e) throws Exception{
        Stage stage;
        Scene scene;
        Parent root;
        if ( e.getSource() == cancel1 ) {
            stage = (Stage) cancel1.getScene().getWindow();
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
        else if ( e.getSource() == cancel2 ){
            stage = (Stage) cancel2.getScene().getWindow();
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
        else if (e.getSource() == save1 ){
            System.out.println("EISAI MALAKAS");
            RadioButton r1 = (RadioButton)Kids.getSelectedToggle();
            loginmodel2.insertValue(firstName.getText(),lastName.getText(),Integer.parseInt(age.getText()),genderBox.getValue().toString(),familyStatusBox.getValue().toString(),r1.getText(),educationBox.getValue().toString());
           
        }      
                    
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        familyStatusBox.setItems(familyStatusList);
        familyStatusBox.setValue("Άγαμος");
        genderBox.setItems(genderList);
        genderBox.setValue("Άνδρας");
        educationBox.setItems(educationList);
        educationBox.setValue("Δημοτικό");
        
        
    }    
    
}
