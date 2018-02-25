/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;



import javafx.application.Application;
import static javafx.application.Application.launch;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 *
 * @author Panayiotis
 */
public class JavaFXApplication4 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
        Scene scene = new Scene(root);
        stage.setX(0);
        stage.setY(0);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\Panayiotis\\Desktop\\App.xlsx"));
        XSSFSheet sheet = wb.getSheetAt(0);
        
        
        String [][] arr = new String[125][16];
        
        DataFormatter formatter = new DataFormatter();
        
        
        for(int i = 2; i < 121; i++)
        {
            
            for(int j = 0; j < 15; j++)
            {
                if ( j<5 || (j>10 && j < 13 )){
                    
                    
                    String val = formatter.formatCellValue(sheet.getRow(i).getCell(j)); 
                    
                    
                    if ( j == 11 && !val.equals("") ){
                        arr[i-2][0] = val; 
                        //System.out.println("MPIKA GIA I = " + i);
                    }
                    arr[i-2][j] = val;
                      
                }
            }
        }
        
        for(int i = 0; i < 118; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        */
        //LoginModel loginmodelofmain = new LoginModel();
        //loginmodelofmain.insertSymptoms(arr);
        
        launch(args);
    }
    
}
