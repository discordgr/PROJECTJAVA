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
import javafx.scene.control.TabPane;
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
    ObservableList<String> incomeList = FXCollections.observableArrayList("Χαμηλό","Μεσαίο","Μεγάλο");
    ObservableList<String> religionList = FXCollections.observableArrayList("Χριστιανισμός","Ινδουϊσμός","Ιουδαϊσμός","Ισλαμισμός","Άλλες θρησκείες");
    ObservableList<String> birthList = FXCollections.observableArrayList("Φυσιολογικός","Με Καισαρική");
    
    //public LoginModel store;
    public LoginModel loginmodel2 = new LoginModel();
    
    @FXML
    private TabPane registerPane;
    
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
    private ChoiceBox incomeBox;
    
    @FXML
    private ChoiceBox religionBox;
    
    @FXML
    private ChoiceBox birthBox;
    
    @FXML
    private Button cancel1;
    
    @FXML
    private Button save1;
    
    @FXML
    private Button cancel2;
    
    
    // Comment Buttons
    @FXML
    private Button comment_kids;
    
    @FXML
    private Button comment_education;
    
    @FXML
    private Button comment_phone;
    
    @FXML
    private Button comment_political;
    
    @FXML
    private Button comment_period;
    
    @FXML
    private Button comment_sexual_life;
    
    @FXML
    private Button comment_sexual_orientation;
    
    @FXML
    private Button comment_personal_interest;
    
    @FXML
    private Button comment_birth_problem;
    
    @FXML
    private Button comment_physical_illness;
    
    @FXML
    private Button comment_history;
    
    @FXML
    private Button comment_medication_use;
    
    @FXML
    private Button comment_diagnostics_test;
    
    @FXML
    private Button comment_diagnosis;
    
    @FXML
    private Button comment_hospitalization;
    // End Of Comment Buttons
    
    
    @FXML
    private Button bmi;
    
    @FXML
    private Button next;
    
    @FXML
    private Button next1;
    
    @FXML
    private Button next2;
    
    @FXML
    private RadioButton yes;
    
    
    // Toggle Groups
    @FXML
    private ToggleGroup Kids;
    
    @FXML
    private ToggleGroup BirthProblem;
    
    @FXML
    private ToggleGroup TraumaticEvent;
    
    @FXML
    private ToggleGroup PastPhysicalIllness;
    
    @FXML
    private ToggleGroup Historyillness;
    
    @FXML
    private ToggleGroup PastMedicationUse;
    
    @FXML
    private ToggleGroup PastDiagnosticTests;
    
    @FXML
    private ToggleGroup PastDiagnosis;
    
    @FXML
    private ToggleGroup PastHospitalization;
    // End of Toggle Groups
    
    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private void registerTabAction(ActionEvent e) throws Exception{
        Stage stage;
        Stage stage2;
        Scene scene;
        Scene scene2;
        Parent root;
        Parent root2;
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
        else if(e.getSource() == next){
            registerPane.getSelectionModel().selectNext();
        }
        else if(e.getSource() == next1){
            registerPane.getSelectionModel().selectNext();
        }
        else if(e.getSource() == next2){
            registerPane.getSelectionModel().selectNext();
        }
        else if ( e.getSource() == comment_kids ){
            //stage2 = (Stage) comment_kids.getScene().getWindow();
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_education ){
            //stage2 = (Stage) comment_education.getScene().getWindow();
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_political ){
            //stage2 = (Stage) comment_political.getScene().getWindow();
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == bmi ){
            //stage2 = (Stage) bmi.getScene().getWindow();
            root2 = FXMLLoader.load(getClass().getResource("BMI.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_period ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_sexual_life ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_sexual_orientation ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_personal_interest ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_birth_problem ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_physical_illness ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_history ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_medication_use ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_diagnostics_test ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_diagnosis ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
        }
        else if ( e.getSource() == comment_hospitalization ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            stage2.show();
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
        incomeBox.setItems(incomeList);
        incomeBox.setValue("Χαμηλό");
        religionBox.setItems(religionList);
        religionBox.setValue("Χριστιανισμός");
        birthBox.setItems(birthList);
        birthBox.setValue("Φυσιολογικός");
    }    
    
}
