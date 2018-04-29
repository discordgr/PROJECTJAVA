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
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

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
        //stage.setX(0);
        //stage.setY(0);
        //stage.setMinWidth(800);
        //stage.setMinHeight(600);
        //stage.setWidth(1024);
        //stage.setHeight(768);
        //stage.setMaximized(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        //stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /* Gia sumptwmata
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
        
        /* Gia Disorders
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\Panayiotis\\Desktop\\App.xlsx"));
        XSSFSheet sheet = wb.getSheetAt(2);
        
        
        String [][] arr = new String[15][5];
        
        DataFormatter formatter = new DataFormatter();
        
        
        for(int i = 2; i < 17; i++)
        {
            
            for(int j = 1; j < 6; j++)
            {
                    
                    
                    String val = formatter.formatCellValue(sheet.getRow(i).getCell(j)); 
                    
                    
                    if ( j == 2 && val.equals("") ){
                        arr[i-2][1] = "0"; 
                        //System.out.println("MPIKA GIA I = " + i);
                    }
                    else if ( j == 2 && !val.equals("") ) 
                    {
                        arr[i-2][1] = "1";
                    }
                    else if ( j == 3 && val.equals("") )
                    {
                        arr[i-2][2] = "0";
                    }
                    else if ( j == 3 && !val.equals(""))   
                    { 
                        arr[i-2][2] = "1";
                    }
                    else
                    {
                        arr[i-2][j-1] = val;
                    }

                      
                
            }
        }
        
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        LoginModel loginmodelofmain = new LoginModel();
        loginmodelofmain.insertDisorders(arr);
        */
        launch(args);
    }
    
}
