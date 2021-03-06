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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafxapplication4.MenuController.id;
import static javafxapplication4.Register_PatientController.comment_counter;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class BMIController implements Initializable {

    @FXML
    private Button cancel;
    @FXML
    private Button calculate;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextArea result;

    private LoginModel lm_bmi;
    private Connection con;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lm_bmi = new LoginModel();
    }    

    @FXML
    private void bmiCalculator(ActionEvent e) throws IOException{
        Stage stage;
        double bmi; 
        con = lm_bmi.getConnection();
        if ( e.getSource() == cancel ){
            stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        }
        else if ( e.getSource() == calculate ){
            bmi = Double.parseDouble(weight.getText())/((Double.parseDouble(height.getText())*Double.parseDouble(height.getText()))/10000);
            double roundOff = (double) Math.round(bmi * 100) / 100;
            result.setText(Double.toString(roundOff));
            try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET BMI = ? WHERE ID = ?"); 
                   ps.setString(1,Double.toString(roundOff));
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
