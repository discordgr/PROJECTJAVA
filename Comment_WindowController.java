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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Panayiotis
 */
public class Comment_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button cancel;
    
    @FXML
    private Button save;
    
    @FXML
    private void commentWindowActions(ActionEvent e) throws IOException{
        Stage stage;
        if ( e.getSource() == cancel ){
            stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        }
        else if ( e.getSource() == save ){
            System.out.println("To be Expected");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
