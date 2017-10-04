/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Connection con_create;
    public static int id;
    public LoginModel loginmodel = new LoginModel();
    
    @FXML
    private Button new_patient;
    
    @FXML
    private Button patient_archive;
    
    @FXML 
    private Button new_diagnosis;
    
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
        if ( e.getSource() == new_patient ){
            stage = (Stage) new_patient.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Register_Patient.fxml"));
            scene = new Scene(root);    
            
            stage.setScene(scene);
            try{
                PreparedStatement ps = con_create.prepareStatement("INSERT INTO trashes(FIRSTNAME,LASTNAME,AGE,GENDER,FAMILY_STATUS,KIDS,KIDS_COMMENT,EDUCATION,EDUCATION_COMMENT,EMPLOYMENT,CLASS,ADDRESS,TELEPHONE,EMAIL,NATIONALITY,RELIGION,POLITICAL_VIEWS,MENSTRUATION,BMI,SEX_LIFE,SEXUAL_ORIENTATION,PERSONAL_INTERESTS,BIRTH_WAY,BIRTH_DEFECTS,BIRTH_DEFECTS_COMMENTS,PAST_TRAUMATIC_EVENT,PAST_PHYSICAL_ILLNESS,PAST_PHYSICAL_ILLNESS_COMMENTS,PAST_HISTORY_ILLNESS,PAST_HISTORY_ILLNESS_COMMENTS,PAST_DRUG_USE,PAST_MEDICATION_USE,PAST_MEDICATION_USE_COMMENTS,PAST_DIAGNOSTICS_TEST,PAST_DIAGNOSTICS_TEST_COMMENTS,PAST_DIAGNOSIS,PAST_DIAGNOSIS_COMMENTS,PAST_HOSPITALIZATION,PAST_HOSPITALIZATION_COMMENTS,REQUEST,APPEARANCE,MOVEMENT_ACTIVITY,EYE_CONTACT,SPEECH,PHYSICAL_ILLNESS,PHYSICAL_ILLNESS_COMMENTS,DRUG_USE,MEDICATION_USE,MEDICATION_USE_COMMENTS,TRAUMATIC_EVENT,TRAUMATIC_EVENT_COMMENTS,DIAGNOSTICS_TEST,DIAGNOSTICS_TEST_COMMENTS,PERSONALITY,HOSPITALIZATION,ID)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
                ps.setInt(56,id);
                ps.executeUpdate();
                ps.close();
            }catch(SQLException exc){
                exc.printStackTrace();
            }
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
        else if ( e.getSource() == new_diagnosis ){
            stage = (Stage) new_diagnosis.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Diagnosis_Menu.fxml"));
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
        con_create = loginmodel.getConnection();
        try{
            PreparedStatement ps = con_create.prepareStatement("SELECT ROWID FROM trashes ORDER BY ROWID DESC");
            ResultSet rs = ps.executeQuery();
            try{ 
                id = rs.getInt("ROWID") + 1;
            }catch(SQLException exc){
                id = 1;
            }
            ps.close();
            rs.close();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
        System.out.println(id);
        if ( loginmodel.isDbConnected() ){
            System.out.println("Connection to Database Established!");
        }
        else{
            System.out.println("Connection to Database Failed!");
        }
    } 
    
}
