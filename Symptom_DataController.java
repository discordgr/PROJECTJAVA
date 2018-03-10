/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Panayiotis kai kala
 */
public class Symptom_DataController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    // Tabs symnptwmatwn
    @FXML
    private TableView<Symptom> symptomsTableTrofis;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnTrofis;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnTrofis;
    
    @FXML
    private TableView<Symptom> symptomsTableDiathesis;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnDiathesis;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnDiathesis;
    
     @FXML
    private TableView<Symptom> symptomsTableSkepsis;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnSkepsis;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnSkepsis;
    
     @FXML
    private TableView<Symptom> symptomsTableDrastiriotitas;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnDrastiriotitas;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnDrastiriotitas;
    
     @FXML
    private TableView<Symptom> symptomsTableFovou;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnFovou;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnFovou;
    
    @FXML
    private TableView<Symptom> symptomsTableSynaisthimatos;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnSynaisthimatos;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnSynaisthimatos;
    
    @FXML
    private TableView<Symptom> symptomsTableLeitourgikotitas;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnLeitourgikotitas;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnLeitourgikotitas;
    
    @FXML
    private TableView<Symptom> symptomsTableYpnou;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnYpnou;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnYpnou;
    
    @FXML
    private TableView<Symptom> symptomsTableAgxous_Stres;
    
    @FXML
    private TableColumn<Symptom,String> nameColumnAgxous_Stres;
    
    @FXML
    private TableColumn<Symptom,Symptom> actionColumnAgxous_Stres;
    
    // Pinakas me ta symptwmata pou exoun epilexxthei (emfanizetai deksia)
    @FXML
    private TableView<Symptom> addedSymptomsTable;
    
    @FXML
    private TableColumn<Symptom,String> addedSymptomsColumn;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button proceed;
    
    @FXML
    private Button remove;
    
    public static int disorder_id;
    
    public LoginModel loginModelSymptomsTable = new LoginModel();
    
    public static ObservableList<Symptom> data = FXCollections.observableArrayList();
    
    public static ObservableList<Symptom> subSymptoms = FXCollections.observableArrayList();
    
    
    @FXML
    private void cancelAction(ActionEvent e) throws Exception{
        data.clear();
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
    
    @FXML
    private void proceedToDiagnose(ActionEvent e) throws Exception{
        ArrayList<Integer> ids = new ArrayList<>();
        //ids.add(54);
        String symptomsClicked = "";
        //int[] ids = new int[50];
        int[][] b;
        for ( Symptom s1 : data){
            if(symptomsClicked.equals("")) symptomsClicked += s1.getSymptomId();
                else symptomsClicked += "," + s1.getSymptomId();
        } 
        String[] temp = symptomsClicked.split(",");
        for (int i = 0; i < temp.length; i++){
            ids.add(Integer.parseInt(temp[i]));
            System.out.println("To id" + i + " einai " + ids.get(i));
        }
        
        Collections.sort(ids);


        b = loginModelSymptomsTable.getDisorders();
        for ( int i = 0; i < 20; i++){
            for ( int j = 0; j < 40; j++ ){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        
        //To k einai o arithmos twn disorder 
        for(int k = 0; k < 15; k++)
        {
            boolean flag = true;
            for(int c = 0; c < ids.size(); c++)
            {
                if(ids.get(c) != b[k][c])
                {
                    System.out.println("ASGSFHAGSHASGHJSFAJFSJA");
                    flag = false;
                    break;
                }
            }
            disorder_id = k+1;
            if(flag) break;
            
        }
        
        System.out.println("To disorder_id einai " + disorder_id);
        
        Stage stage;
        Scene scene;
        Parent root;
        if ( e.getSource() == proceed ) {
            stage = (Stage) proceed.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Show_Possible_Diagnose.fxml"));
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
        
        data.clear();
    }
    
    @FXML
    private void removeSymptom(MouseEvent e) throws Exception{
         if (e.getClickCount() == 1) {
            Symptom s = addedSymptomsTable.getSelectionModel().getSelectedItem();
            if ( s != null ){
                remove.setDisable(false);
                remove.setOnAction(ex ->{
                data.remove(s);
                remove.setDisable(true);
                });
            }
    
            

        }
    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    //TROFIS
    nameColumnTrofis.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnTrofis.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    //DIATHESIS
    nameColumnDiathesis.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnDiathesis.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //SKEPSIS
    nameColumnSkepsis.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnSkepsis.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //FOVOU
    nameColumnFovou.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnFovou.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //SYNAISTHIMATOS
    nameColumnSynaisthimatos.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnSynaisthimatos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //AGXOUS
    nameColumnAgxous_Stres.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnAgxous_Stres.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //LEITOURGIKOTITAS
    nameColumnLeitourgikotitas.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnLeitourgikotitas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //DRASTIRIOTITAS
    nameColumnDrastiriotitas.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnDrastiriotitas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    nameColumnYpnou.setCellValueFactory(new PropertyValueFactory<>("Name"));
    actionColumnYpnou.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
    
    //EPILEGMNENA pou pane deksia
    addedSymptomsColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
    
    
    //ACTIONS
    actionColumnTrofis.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
        private final Button button = new Button("Select");
        {
            button.setOnAction(e -> {
                
                Symptom symptom = getItem();
                this.tableRowProperty().get().setStyle("-fx-background-color: #15ED15;");
                
                
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
    actionColumnDiathesis.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnSkepsis.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
        private final Button button = new Button("Select");
        {
           
            button.setOnAction(e -> {
                
                Symptom symptom = getItem();
                boolean anoiksePopUpWindow;
                Parent root = null;
                Scene scene;
                Stage stage;
                
                if(symptom.getSymptomId().equals("109"))
                {
                    anoiksePopUpWindow = true;
                    subSymptoms = loginModelSymptomsTable.selectSubSymptoms(1);
                    try {
                    root = FXMLLoader.load(getClass().getResource("PopupSymptoms.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(Symptom_DataController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scene = new Scene(root);

                    stage = new Stage();
                    stage.setScene(scene);
                    stage.setMaxWidth(1024);
                    stage.setMaxHeight(768);

                    stage.initModality(Modality.APPLICATION_MODAL);

                    stage.show();
                }else if (symptom.getSymptomId().equals("110"))
                {
                    anoiksePopUpWindow = true;
                    subSymptoms = loginModelSymptomsTable.selectSubSymptoms(2);
                    try {
                    root = FXMLLoader.load(getClass().getResource("PopupSymptoms.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(Symptom_DataController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scene = new Scene(root);

                    stage = new Stage();
                    stage.setScene(scene);
                    stage.setMaxWidth(1024);
                    stage.setMaxHeight(768);

                    stage.initModality(Modality.APPLICATION_MODAL);

                    stage.show();

                }
                
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
    actionColumnFovou.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnSynaisthimatos.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnAgxous_Stres.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnLeitourgikotitas.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnDrastiriotitas.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    actionColumnYpnou.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
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
    
    
    symptomsTableTrofis.setItems(loginModelSymptomsTable.selectSymptomTrofis());
    symptomsTableDiathesis.setItems(loginModelSymptomsTable.selectSymptomDiathesis());
    symptomsTableSkepsis.setItems(loginModelSymptomsTable.selectSymptomSkepsis());
    symptomsTableFovou.setItems(loginModelSymptomsTable.selectSymptomSkepsis());
    symptomsTableSynaisthimatos.setItems(loginModelSymptomsTable.selectSymptomSynaisthimatos());
    symptomsTableAgxous_Stres.setItems(loginModelSymptomsTable.selectSymptomAgxous_Stres());
    symptomsTableLeitourgikotitas.setItems(loginModelSymptomsTable.selectSymptomLeitourgikotitas());
    symptomsTableDrastiriotitas.setItems(loginModelSymptomsTable.selectSymptomDrastiriotitas());
    symptomsTableYpnou.setItems(loginModelSymptomsTable.selectSymptomYpnou());
    addedSymptomsTable.setItems(data);
    }    
   
    
}
