/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Giannis
 */
public class Duration_Frequency_ExtrasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    ObservableList<String> durationList = FXCollections.observableArrayList("Days","Weeks","Months","Years");
    ObservableList<String> frequencyList = FXCollections.observableArrayList("Day","Week","Month","Year");
    
    @FXML
    private Button unknownDur;
    
    @FXML
    private Button unknownFreq;
    
    @FXML
    private Slider daySlider;
    
    @FXML
    private Slider weekSlider;
    
    @FXML
    private Slider monthSlider;
    
    @FXML
    private Slider yearSlider;
    
    @FXML
    private ChoiceBox durationChoice;
    
    @FXML
    private ChoiceBox frequencyChoice;
    
    /*@FXML
    private void durationValue(ActionEvent e) throws Exception
    {
        if(e.getSource() == )
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        durationChoice.setItems(durationList);
        durationChoice.setValue("Days");
        
        frequencyChoice.setItems(frequencyList);
        frequencyChoice.setValue("Day");
        
        
    }    
    
}
