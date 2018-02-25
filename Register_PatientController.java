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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static javafxapplication4.MenuController.id;

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
    ObservableList<String> appearanceList = FXCollections.observableArrayList("Υπερβολική Φροντίδα","Απώλεια Ενδιαφέροντος Ένδυσης","Παράδοξη ένδυση");
    ObservableList<String> movementList = FXCollections.observableArrayList("Υπερκινησίες","Υποκινησίες","Παρακινησίες","Άλλο");
    ObservableList<String> eye_contactList = FXCollections.observableArrayList("Υπερμιμίες","Αμιμίες","Παραμιμίες","Στερομιμίες","Δυσμιμίες","Άλλο");
    ObservableList<String> speechList = FXCollections.observableArrayList("Τραυλισμός","Δυσαρθρία","Απροσωπία","Δυσφωνίες","Βωβότητα","Βραδυφημία","Λογόρροια","Λεξιλογική Ορθότητα","Εκτροχιασμός","Εφαπτόμενος λόγος","Υπερλεπτομεριακός λόγος","Λεκτικοί Αυτοματισμοί","Λεκτικές εμμονές","Λογοπενία","Λεκτική Πληθωρικότητα","Άλλο");
    
    //public LoginModel store;
    public LoginModel loginmodel2 = new LoginModel();
    public static int comment_counter;
    private Connection con_upd;
    private boolean flag_smoking = false;
    private boolean flag_drugs = false;
    private boolean flag_alcohol = false;
    private boolean flag_toggle = false;
    private String unknown = "Άγνωστο";
    private RadioButton r1,r2,r3,r4,r5,r6,r7,r8;
    
    @FXML
    private TabPane registerPane;
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField age;
    
    @FXML
    private TextField employment;
    
    @FXML
    private TextField address;
    
    @FXML
    private TextField phone;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField nationality;
    
    // ChoiceBox
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
    private ChoiceBox appearanceBox;
    
    @FXML
    private ChoiceBox movementBox;
    
    @FXML
    private ChoiceBox eye_contactBox;
    
    @FXML
    private ChoiceBox speechBox;
    // End of ChoiceBox
    
    
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
    
    @FXML
    private Button comment_request;
    
    @FXML
    private Button comment_physical_illness_current;
    
    @FXML
    private Button comment_medication_use_current;
    
    @FXML
    private Button comment_traumatic_event;
    
    @FXML
    private Button comment_diagnostics_test_current;
    
    @FXML
    private Button comment_personality;
    
    @FXML
    private Button comment_current_hospitalization;
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
    private Button save1;
    
    @FXML
    private Button save_all;
    
    @FXML
    private Button cancel1;
    
    @FXML
    private Button cancel2;
    
    @FXML
    private Button cancel3;
    
    @FXML
    private Button cancel4;
    
    @FXML
    private RadioButton yes;
    

    
    
    
    // Toggle Groups
    @FXML
    private ToggleGroup kids;
    
    @FXML
    private ToggleGroup physicalIllness;
    
    @FXML
    private ToggleGroup medicationUse;
    
    @FXML
    private ToggleGroup traumaticEvent;
    
    @FXML
    private ToggleGroup diagnosticTest;
    // End of Toggle Groups
    
    @FXML
    private CheckBox smoking;
    
    @FXML
    private CheckBox drugs;
    
    @FXML
    private CheckBox alcohol;
    
    @FXML
    private CheckBox birthProblem;
    
    @FXML
    private CheckBox pastTraumaticEvent;
    
    @FXML
    private CheckBox pastPhysicalIllness;
    
    @FXML
    private CheckBox pasthistoryIllness;
    
    @FXML
    private CheckBox pastMedicationUse;
    
    @FXML
    private CheckBox pastDiagnosticTests;
    
    @FXML
    private CheckBox pastDiagnosis;
    
    @FXML
    private CheckBox pastHospitalization;
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
        String values[];
        if ( e.getSource() == cancel1 ) {
            try{
                PreparedStatement ps = con_upd.prepareStatement("DELETE FROM trashes WHERE ROWID = ?"); 
                ps.setInt(1,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                System.out.println("SQL ERROR");
            }
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
            try{
                PreparedStatement ps = con_upd.prepareStatement("DELETE FROM trashes WHERE ROWID = ?"); 
                ps.setInt(1,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                System.out.println("SQL ERROR");
            }
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
        else if ( e.getSource() == cancel3 ){
            try{
                PreparedStatement ps = con_upd.prepareStatement("DELETE FROM trashes WHERE ROWID = ?"); 
                ps.setInt(1,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                System.out.println("SQL ERROR");
            }
            stage = (Stage) cancel3.getScene().getWindow();
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
        else if ( e.getSource() == cancel4 ){
            try{
                PreparedStatement ps = con_upd.prepareStatement("DELETE FROM trashes WHERE ROWID = ?"); 
                ps.setInt(1,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                System.out.println("SQL ERROR");
            }
            stage = (Stage) cancel4.getScene().getWindow();
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
            RadioButton r1 = (RadioButton)kids.getSelectedToggle();
            loginmodel2.insertValue(firstName.getText(),lastName.getText(),Integer.parseInt(age.getText()),genderBox.getValue().toString(),familyStatusBox.getValue().toString(),r1.getText(),educationBox.getValue().toString());
           
        }
        else if(e.getSource() == next){
            if ( kids.getSelectedToggle() == null ){
                flag_toggle = true;
            }else{
                r1 = (RadioButton)kids.getSelectedToggle();
            }
            try{
                PreparedStatement ps = con_upd.prepareStatement("UPDATE trashes SET FIRSTNAME = ?,LASTNAME = ?,AGE = ?,GENDER = ?,FAMILY_STATUS = ?,KIDS = ?,EDUCATION = ?,EMPLOYMENT = ?,CLASS = ?,ADDRESS = ?,TELEPHONE = ?,EMAIL = ? WHERE ID = ?"); 
                ps.setString(1,firstName.getText() + "");
                ps.setString(2,lastName.getText() + "");
                if ( age.getText().equals("") ){
                    ps.setInt(3, 0);
                }else{
                    ps.setInt(3,Integer.parseInt(age.getText()+ ""));
                }
                ps.setString(4,genderBox.getValue().toString()+ "");
                ps.setString(5,familyStatusBox.getValue().toString()+ "");
                if ( flag_toggle == true ){
                    ps.setString(6,"Άγνωστο");
                }else{
                    ps.setString(6,r1.getText());
                }
                ps.setString(7,educationBox.getValue().toString()+ "");
                ps.setString(8,employment.getText()+ "");
                ps.setString(9,incomeBox.getValue().toString()+ "");
                ps.setString(10,address.getText()+ "");
                ps.setString(11,phone.getText()+ "");
                ps.setString(12,email.getText()+ "");
                ps.setInt(13, id);
                ps.executeUpdate();
                ps.close();
            }catch (SQLException exc){
                System.out.println(exc.toString());
            }
            registerPane.getSelectionModel().selectNext();
        }
        else if(e.getSource() == next1){
            try{
                PreparedStatement ps = con_upd.prepareStatement("UPDATE trashes SET NATIONALITY = ?, RELIGION = ? WHERE ID = ?");
                ps.setString(1,nationality.getText()+ "");
                ps.setString(2,religionBox.getValue().toString()+ "");
                ps.setInt(3,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                exc.printStackTrace();
            }
            registerPane.getSelectionModel().selectNext();
        }
        else if(e.getSource() == next2){
            
            try{
                PreparedStatement ps = con_upd.prepareStatement("UPDATE trashes SET BIRTH_WAY = ?, BIRTH_DEFECTS = ?,PAST_TRAUMATIC_EVENT=?,PAST_PHYSICAL_ILLNESS=?,PAST_HISTORY_ILLNESS=?,PAST_DRUG_USE=?,PAST_MEDICATION_USE=?,PAST_DIAGNOSTICS_TEST=?,PAST_DIAGNOSIS=?,PAST_HOSPITALIZATION=? WHERE ID = ?");
                ps.setString(1,birthBox.getValue().toString() + "");
                if ( birthProblem.isSelected() ){
                    ps.setString(2,"Ναι");
                }else{
                    ps.setString(2,"Όχι");
                }
                if ( pastTraumaticEvent.isSelected() ){
                    ps.setString(3,"Ναι");
                }else{
                    ps.setString(3,"Όχι");
                }
                if ( pastPhysicalIllness.isSelected() ){
                    ps.setString(4,"Ναι");
                }else{
                    ps.setString(4,"Όχι");
                }
                if ( pasthistoryIllness.isSelected() ){
                    ps.setString(5,"Ναι");
                }else{
                    ps.setString(5,"Όχι");
                }
                if ( smoking.isSelected() ){
                    ps.setString(6,"Smoking");
                    flag_smoking = true;
                }
                if ( drugs.isSelected() ){
                    if ( flag_smoking == true ){
                        ps.setString(6, "Smoking,Drugs");
                    }
                    else{
                        ps.setString(6, "Drugs");
                    }
                    flag_drugs = true;
                }
                if ( alcohol.isSelected() ){
                    if ( flag_smoking == true && flag_drugs == true ){
                        ps.setString(6,"Smoking,Drugs,Alcohol");
                    }else if ( flag_smoking == true && flag_drugs == false ){
                        ps.setString(6,"Smoking,Alcohol");
                    }else if ( flag_smoking == false && flag_drugs == true ){
                        ps.setString(6,"Drugs,Alcohol");
                    }else {
                        ps.setString(6,"Alcohol");
                    }
                    flag_alcohol = true;
                }
                if ( flag_smoking == false && flag_drugs == false && flag_alcohol == false ){
                    ps.setString(6,"Καμία");
                }
                if ( pastMedicationUse.isSelected() ){
                    ps.setString(7,"Ναι");
                }else{
                    ps.setString(7,"Όχι");
                }
                if ( pastDiagnosticTests.isSelected() ){
                    ps.setString(8,"Ναι");
                }else{
                    ps.setString(8,"Όχι");
                }
                if ( pastDiagnosis.isSelected() ){
                    ps.setString(9,"Ναι");
                }else{
                    ps.setString(9,"Όχι");
                }
                if ( pastHospitalization.isSelected() ){
                    ps.setString(10,"Ναι");
                }else{
                    ps.setString(10,"Όχι");
                }
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                exc.printStackTrace();
            }
            registerPane.getSelectionModel().selectNext();
        }else if ( e.getSource() == save_all ) {
            
           
        }
        else if ( e.getSource() == comment_kids ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 7;
            stage2.show();
        }
        else if ( e.getSource() == comment_education ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 9;
            stage2.show();
        }
        else if ( e.getSource() == comment_political ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 17;
            stage2.show();
        }
        else if ( e.getSource() == bmi ){
            root2 = FXMLLoader.load(getClass().getResource("BMI.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 19;
            stage2.show();
        }
        else if ( e.getSource() == comment_period ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 18;
            stage2.show();
        }
        else if ( e.getSource() == comment_sexual_life ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 20;
            stage2.show();
        }
        else if ( e.getSource() == comment_sexual_orientation ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 21;
            stage2.show();
        }
        else if ( e.getSource() == comment_personal_interest ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 22;
            stage2.show();
        }
        else if ( e.getSource() == comment_birth_problem ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 25;
            stage2.show();
        }
        else if ( e.getSource() == comment_physical_illness ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 28;
            stage2.show();
        }
        else if ( e.getSource() == comment_history ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 30;
            stage2.show();
        }
        else if ( e.getSource() == comment_medication_use ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 33;
            stage2.show();
        }
        else if ( e.getSource() == comment_diagnostics_test ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 35;
            stage2.show();
        }
        else if ( e.getSource() == comment_diagnosis ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 37;
            stage2.show();
        }
        else if ( e.getSource() == comment_hospitalization ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 39;
            stage2.show();
        }
        else if ( e.getSource() == comment_request ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 40;
            stage2.show();
        }
        else if ( e.getSource() == comment_physical_illness_current ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 46;
            stage2.show();
        }
        else if ( e.getSource() == comment_medication_use_current ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 49;
            stage2.show();
        }
        else if ( e.getSource() == comment_traumatic_event ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 51;
            stage2.show();
        }
        else if ( e.getSource() == comment_diagnostics_test_current ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 53;
            stage2.show();
        }
         else if ( e.getSource() == comment_personality ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 54;
            stage2.show();
        }
        else if ( e.getSource() == comment_current_hospitalization ){
            root2 = FXMLLoader.load(getClass().getResource("Comment_Window.fxml"));
            scene2 = new Scene(root2);
            
            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setMaxWidth(350);
            stage2.setMaxHeight(250);
            comment_counter = 55;
            stage2.show();
        }
   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con_upd = loginmodel2.getConnection();
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
        appearanceBox.setItems(appearanceList);
        appearanceBox.setValue("Υπερβολική Φροντίδα");
        movementBox.setItems(movementList);
        movementBox.setValue("Υπερκινησίες");
        eye_contactBox.setItems(eye_contactList);
        eye_contactBox.setValue("Υπερμιμίες");
        speechBox.setItems(speechList);
        speechBox.setValue("Τραυλισμός");
    }    
    
}


//("INSERT INTO trashes(FIRSTNAME,LASTNAME,AGE,GENDER,FAMILY_STATUS,KIDS,KIDS_COMMENT,EDUCATION,EDUCATION_COMMENT,EMPLOYMENT,CLASS,ADDRESS,TELEPHONE,EMAIL,NATIONALITY,RELIGION,POLITICAL_VIEWS,MENSTRUATION,BMI,SEX_LIFE,SEXUAL_ORIENTATION,PERSONAL_INTERESTS,BIRTH_WAY,BIRTH_DEFECTS,BIRTH_DEFECTS_COMMENTS,PAST_TRAUMATIC_EVENT,PAST_PHYSICAL_ILLNESS,PAST_PHYSICAL_ILLNESS_COMMENTS,PAST_HISTORY_ILLNESS,PAST_HISTORY_ILLNESS_COMMENTS,PAST_DRUG_USE,PAST_MEDICATION_USE,PAST_MEDICATION_USE_COMMENTS,PAST_DIAGNOSTICS_TEST,PAST_DIAGNOSTICS_TEST_COMMENTS,PAST_DIAGNOSIS,PAST_DIAGNOSIS_COMMENTS,PAST_HOSPITALIZATION,PAST_HOSPITALIZATION_COMMENTS,REQUEST,APPEARANCE,MOVEMENT_ACTIVITY,EYE_CONTACT,SPEECH,PHYSICAL_ILLNESS,PHYSICAL_ILLNESS_COMMENTS,DRUG_USE,MEDICATION_USE,MEDICATION_USE_COMMENTS,TRAUMATIC_EVENT,TRAUMATIC_EVENT_COMMENTS,DIAGNOSTICS_TEST,DIAGNOSTICS_TEST_COMMENTS,PERSONALITY,HOSPITALIZATION,ID)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
/* PreparedStatement ps = con_create.prepareStatement("INSERT INTO trashes(FIRSTNAME,LASTNAME,AGE,GENDER,FAMILY_STATUS,KIDS,KIDS_COMMENT,EDUCATION,EDUCATION_COMMENT,EMPLOYMENT,CLASS,ADDRESS,TELEPHONE,EMAIL,NATIONALITY,RELIGION,POLITICAL_VIEWS,MENSTRUATION,BMI,SEX_LIFE,SEXUAL_ORIENTATION,PERSONAL_INTERESTS,BIRTH_WAY,BIRTH_DEFECTS,BIRTH_DEFECTS_COMMENTS,PAST_TRAUMATIC_EVENT,PAST_PHYSICAL_ILLNESS,PAST_PHYSICAL_ILLNESS_COMMENTS,PAST_HISTORY_ILLNESS,PAST_HISTORY_ILLNESS_COMMENTS,PAST_DRUG_USE,PAST_MEDICATION_USE,PAST_MEDICATION_USE_COMMENTS,PAST_DIAGNOSTICS_TEST,PAST_DIAGNOSTICS_TEST_COMMENTS,PAST_DIAGNOSIS,PAST_DIAGNOSIS_COMMENTS,PAST_HOSPITALIZATION,PAST_HOSPITALIZATION_COMMENTS,REQUEST,APPEARANCE,MOVEMENT_ACTIVITY,EYE_CONTACT,SPEECH,PHYSICAL_ILLNESS,PHYSICAL_ILLNESS_COMMENTS,DRUG_USE,MEDICATION_USE,MEDICATION_USE_COMMENTS,TRAUMATIC_EVENT,TRAUMATIC_EVENT_COMMENTS,DIAGNOSTICS_TEST,DIAGNOSTICS_TEST_COMMENTS,PERSONALITY,HOSPITALIZATION,ID)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            ps.setInt(56,1);
            ps.executeUpdate(); 
             RadioButton r1 = (RadioButton)kids.getSelectedToggle();
            try{
                PreparedStatement ps = con_create.prepareStatement("INSERT INTO trashes(FIRSTNAME,LASTNAME,AGE,GENDER,FAMILY_STATUS,KIDS,KIDS_COMMENT,EDUCATION,EDUCATION_COMMENT,EMPLOYMENT,CLASS,ADDRESS,TELEPHONE,EMAIL,NATIONALITY,RELIGION,POLITICAL_VIEWS,MENSTRUATION,BMI,SEX_LIFE,SEXUAL_ORIENTATION,PERSONAL_INTERESTS,BIRTH_WAY,BIRTH_DEFECTS,BIRTH_DEFECTS_COMMENTS,PAST_TRAUMATIC_EVENT,PAST_PHYSICAL_ILLNESS,PAST_PHYSICAL_ILLNESS_COMMENTS,PAST_HISTORY_ILLNESS,PAST_HISTORY_ILLNESS_COMMENTS,PAST_DRUG_USE,PAST_MEDICATION_USE,PAST_MEDICATION_USE_COMMENTS,PAST_DIAGNOSTICS_TEST,PAST_DIAGNOSTICS_TEST_COMMENTS,PAST_DIAGNOSIS,PAST_DIAGNOSIS_COMMENTS,PAST_HOSPITALIZATION,PAST_HOSPITALIZATION_COMMENTS,REQUEST,APPEARANCE,MOVEMENT_ACTIVITY,EYE_CONTACT,SPEECH,PHYSICAL_ILLNESS,PHYSICAL_ILLNESS_COMMENTS,DRUG_USE,MEDICATION_USE,MEDICATION_USE_COMMENTS,TRAUMATIC_EVENT,TRAUMATIC_EVENT_COMMENTS,DIAGNOSTICS_TEST,DIAGNOSTICS_TEST_COMMENTS,PERSONALITY,HOSPITALIZATION,ID)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
                ps.setString(1,firstName.getText());
                ps.setString(2,lastName.getText());
                ps.setInt(3, Integer.parseInt(age.getText()));
                ps.setString(4,genderBox.getValue().toString());
                ps.setString(5,familyStatusBox.getValue().toString());
                ps.setString(6,r1.getText());
                ps.setString(8,educationBox.getValue().toString());
                ps.executeUpdate();
            }catch(SQLException er){
                er.printStackTrace();
            }
*/               