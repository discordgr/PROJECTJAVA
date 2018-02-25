/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Giannis
 */
public class Temporary_Symptoms_WindowController implements Initializable {

    @FXML
    private TableView<?> tempSymptomsTable;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> actionCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
