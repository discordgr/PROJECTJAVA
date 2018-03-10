/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafxapplication4.Symptom_DataController.data;
import static javafxapplication4.Symptom_DataController.subSymptoms;

/**
 * FXML Controller class
 *
 * @author Giannis
 */
public class PopupSymptomsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Symptom> subSymptomsTable;
    
    @FXML
    private TableColumn<Symptom,String> nameColumn;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        actionColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        
        actionColumn.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
        private final Button button = new Button("Select");
        {
            button.setOnAction(e -> {
                
                Symptom symptom = getItem();
                
                boolean flag = false;
                for (Symptom s1 : data){
                    if ( s1.getSymptomId().equals(symptom.getSymptomId())) {
                        flag = true;
                        break;
                    }
                }
                if ( flag == false){
                    data.add(symptom);
                }

                
                System.out.println(symptom.getSymptomId());
            });
        }

        @Override
        protected void updateItem(Symptom item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(button);
            }
        }
    });
        
       subSymptomsTable.setItems(subSymptoms); 
       
    }    
    
}
