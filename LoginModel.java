/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Panayiotis
 */
public class LoginModel {
    Connection connection;
        public LoginModel(){
            connection = Database_Connection.Connector();
            if (connection == null) System.exit(1);
        }
        
        public boolean isDbConnected(){
            try{
                return !connection.isClosed();
            }catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        
        public void insertValue(String name,String lastname,int age,String gender,String family,String kids,String education){
            connection = Database_Connection.Connector();
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO patients (FIRSTNAME,LASTNAME,AGE,GENDER,FAMILY_STATUS,KIDS,EDUCATION)" + "VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, name );
                ps.setString(2, lastname);
                ps.setInt(3, age);
                ps.setString(4,gender);
                ps.setString(5,family);
                ps.setString(6,kids);
                ps.setString(7,education);
                ps.executeUpdate();
                System.out.println("Insert Successfull");
            /*Statement st = connection.createStatement();
            st.execute("INSERT INTO patients (firstname,sirname) VALUES('" + name
                    + "," + sirname + "')");*/
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
         public ObservableList<Patient> selectValue(){
            connection = Database_Connection.Connector();
            ObservableList<Patient> patientData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM patients");
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
                                String age = rs.getString("AGE");
                                String gender = rs.getString("GENDER");
                                String family = rs.getString("FAMILY_STATUS");
                                String kids = rs.getString("KIDS");
                                String education = rs.getString("EDUCATION");

				/*System.out.println("name : " + firstname);
				System.out.println("sirname : " + lastname);
                                System.out.println("age : " + age);
                                System.out.println("Gender : " + gender);
                                System.out.println("Family Status : " + family);
                                System.out.println("Kids : " + kids);
                                System.out.println("Education : " + education); */ 
                                Patient p = new Patient(firstname,lastname,age,gender,family,kids,education);
                                patientData.add(p);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return patientData;
        }
         
        public ObservableList<Symptom> selectSymptomValue(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms");
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                                String name = rs.getString("NAME");
                                String category = rs.getString("CATEGORY");

				//System.out.println("name : " + name);
                                //System.out.println("category : " + category);  
                                Symptom s = new Symptom(name,category);
                                symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
}
