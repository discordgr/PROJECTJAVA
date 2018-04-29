/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private Label Symptom;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button save;
    
    @FXML
    private Slider daySlider;
    
    @FXML
    private Slider weekSlider;
    
    @FXML
    private Slider monthSlider;
    
    @FXML
    private Slider yearSlider;
    
    @FXML
    private Slider frequencySlider;
    
    @FXML
    private ChoiceBox durationChoice;
    
    @FXML
    private ChoiceBox frequencyChoice;
    
    @FXML
    public void cancel(ActionEvent e){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Symptom.setText("Symptom");
        durationChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                
            public void changed(ObservableValue ov, Number value, Number new_value) {
                if ( new_value.toString().equals("0") ){
                    daySlider.setVisible(true);
                    weekSlider.setVisible(false);
                    monthSlider.setVisible(false);
                    yearSlider.setVisible(false);
                }else if ( new_value.toString().equals("1") ){
                    daySlider.setVisible(false);
                    weekSlider.setVisible(true);
                    monthSlider.setVisible(false);
                    yearSlider.setVisible(false);
                }else if ( new_value.toString().equals("2") ){
                    daySlider.setVisible(false);
                    weekSlider.setVisible(false);
                    monthSlider.setVisible(true);
                    yearSlider.setVisible(false);
                }else{
                    daySlider.setVisible(false);
                    weekSlider.setVisible(false);
                    monthSlider.setVisible(false);
                    yearSlider.setVisible(true);
                }
            }

        });
        
        durationChoice.setItems(durationList);
        durationChoice.setValue("Days");
        
        
        frequencyChoice.setItems(frequencyList);
        frequencyChoice.setValue("Day");
        
    }    
    
    
    
}
