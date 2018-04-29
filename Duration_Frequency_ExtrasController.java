/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javafxapplication4.Symptom_DataController.data;
import static javafxapplication4.Symptom_DataController.symptomDet;

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
    private CheckBox durationCheck;
    
    @FXML
    private CheckBox frequencyCheck;
    
    @FXML 
    public void updateCheckDur(){
        if ( durationCheck.isSelected() ){
            daySlider.setDisable(true);
            weekSlider.setDisable(true);
            monthSlider.setDisable(true);
            yearSlider.setDisable(true);
            durationChoice.setDisable(true);
        }else{
            daySlider.setDisable(false);
            weekSlider.setDisable(false);
            monthSlider.setDisable(false);
            yearSlider.setDisable(false);
            durationChoice.setDisable(false);
        }
    }
    
    @FXML
    public void updateCheckFreq(){
        if ( frequencyCheck.isSelected() ){
            frequencySlider.setDisable(true);
            frequencyChoice.setDisable(true);
        }else{
            frequencySlider.setDisable(false);
            frequencyChoice.setDisable(false);
        }
    }
    
    @FXML
    public void cancelAction(ActionEvent e){
        Stage stage;
        
        if ( e.getSource() == cancel ){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            //alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you sure you want to exit?");
            Optional<ButtonType> closeResponse = alert.showAndWait();
            if (!ButtonType.OK.equals(closeResponse.get())) {
                e.consume();
            }
            stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        }
    }
    
    @FXML
    public void saveAction(ActionEvent e){
        Stage stage;
        SymptomDet sd = new SymptomDet();
        double d,f;
        String dur;

        f = frequencySlider.getValue();
        if ( durationChoice.getValue().toString().equals("Days") ){
            dur = durationChoice.getValue().toString();
            d = daySlider.getValue();
        }else if ( durationChoice.getValue().toString().equals("Weeks") ){
            dur = durationChoice.getValue().toString();
            d = weekSlider.getValue();
        }else if ( durationChoice.getValue().toString().equals("Months") ){
            dur = durationChoice.getValue().toString();
            d = monthSlider.getValue();
        }else{
            dur = durationChoice.getValue().toString();
            d = yearSlider.getValue();
        }
            if ( durationCheck.isSelected() ){
                d = 0;
            }
            if ( frequencyCheck.isSelected()){
                f = 0;
            }
            
            sd.setDurPeriod(dur);
            sd.setDurNumber(d);
            sd.setFreqPeriod(frequencyChoice.getValue().toString());
            sd.setFreqNumber(f);
            sd.setName(symptomDet.getName());
            sd.setSymptomId(symptomDet.getSymptomId());
            data.add(sd);
            
            stage = (Stage) save.getScene().getWindow();
            stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Symptom.setText(symptomDet.getName());
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
