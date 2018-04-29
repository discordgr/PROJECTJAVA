/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import static javafxapplication4.MenuController.id;
import static javafxapplication4.Register_PatientController.comment_counter;


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
    private TextArea t1;
    
    private LoginModel lm;
    private Connection con;
    
    @FXML
    private void commentWindowActions(ActionEvent e) throws IOException{
        Stage stage;
        if ( e.getSource() == cancel ){
            stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        }
        else if ( e.getSource() == save ){
            con = lm.getConnection();
            if ( comment_counter == 7){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET KIDS_COMMENT = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 9 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET EDUCATION_COMMENT = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 17 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET POLITICAL_VIEWS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 18 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET MENSTRUATION = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 20 ){            
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET SEX_LIFE = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 21 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET SEXUAL_ORIENTATION = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 22 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PERSONAL_INTERESTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 25 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET BIRTH_DEFECTS_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 28 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_PHYSICAL_ILLNESS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 30 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_HISTORY_ILLNESS_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 33 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_MEDICATION_USE_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 35 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_DIAGNOSTICS_TEST_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 37 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_DIAGNOSIS_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 39 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PAST_HOSPITALIZATION_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 40 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET REQUEST = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 46 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PHYSICAL_ILLNESS_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 49 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET MEDICATION_USE_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 51 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET TRAUMATIC_EVENT_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 53 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET DIAGNOSTICS_TEST_COMMENTS = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 54 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET PERSONALITY = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }else if ( comment_counter == 55 ){
                try{
                   PreparedStatement ps = con.prepareStatement("UPDATE trashes SET HOSPITALIZATION = ? WHERE ID = ?"); 
                   ps.setString(1,t1.getText());
                   ps.setInt(2, id);
                   ps.executeUpdate();
                   ps.close();
                   System.out.println("Update Successfull");
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }
            stage = (Stage) save.getScene().getWindow();
            stage.close();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lm = new LoginModel();
        con = lm.getConnection();
        String comment = null;
        if ( comment_counter == 7){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT KIDS_COMMENT FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 9 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT EDUCATION_COMMENT FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }     
        else if ( comment_counter == 17 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT POLITICAL_VIEWS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 18 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT MENSTRUATION FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 20 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT SEX_LIFE FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 21 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT SEXUAL_ORIENTATION FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 22 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PERSONAL_INTERESTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 25 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT BIRTH_DEFECTS_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 28 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_PHYSICAL_ILLNESS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 30 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_HISTORY_ILLNESS_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 33 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_MEDICATION_USE_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 35 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_DIAGNOSTICS_TEST_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 37 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_DIAGNOSIS_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 39 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PAST_HOSPITALIZATION_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 40 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT REQUEST FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 46 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PHYSICAL_ILLNESS_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 49 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT MEDICATION_USE_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 51 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT TRAUMATIC_EVENT_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 53 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT DIAGNOSTICS_TEST_COMMENTS FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 54 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT PERSONALITY FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        else if ( comment_counter == 55 ){
            try{
                   PreparedStatement ps = con.prepareStatement("SELECT HOSPITALIZATION FROM trashes WHERE ID = ?"); 
                   ps.setInt(1, id);
                   ResultSet rs = ps.executeQuery();
                   System.out.println("Select Comment Successfull");
                   while ( rs.next() )
                       comment = rs.getString("KIDS_COMMENT");
                   
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
        }
        if ( comment != null ) {
            t1.setText(""+comment);
        }else{
            t1.setText("");
        }
        
    }
    
}
