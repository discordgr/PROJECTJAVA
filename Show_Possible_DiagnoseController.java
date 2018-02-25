/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javafxapplication4.Symptom_DataController.disorder_id;

/**
 * FXML Controller class
 *
 * @author Giannis
 */
public class Show_Possible_DiagnoseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Disorder> disordersTable;
    
    @FXML
    private TableColumn<Disorder,String> nameColumn;
   
    @FXML
    private TableColumn<Disorder,String> subCategoryColumn;
    
    @FXML
    private TableColumn<Disorder,Boolean> icd10Column;
    
    @FXML
    private TableColumn<Disorder,Boolean> dsm5Column;
    
    @FXML
    private TableColumn<Disorder,Float> percentColumn;
    
    @FXML
    private Button cancel;
    
    @FXML
    private void cancelAction(ActionEvent e) throws Exception{
        Stage stage;
        Scene scene;
        Parent root;
        if ( e.getSource() == cancel ) {
            stage = (Stage) cancel.getScene().getWindow();
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
    }
    
    private LoginModel loginModelDisordersTable = new LoginModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        subCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        icd10Column.setCellValueFactory(new PropertyValueFactory<>("icd10"));
        dsm5Column.setCellValueFactory(new PropertyValueFactory<>("dsm5"));
        percentColumn.setCellValueFactory(new PropertyValueFactory<>("percent"));
        disordersTable.setItems(loginModelDisordersTable.selectDisorder(disorder_id));
    }    
    
}
