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
        
        public Connection getConnection(){
            return Database_Connection.Connector();
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
         
        public ObservableList<Symptom> selectSymptomTrofis(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID BETWEEN ? AND ?");
                ps.setInt(1,1);
                ps.setInt(2,137);
                ps.setInt(3,0);
                ps.setInt(4,10);
                ps.setInt(5,19);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
         public ObservableList<Symptom> selectSymptomDiathesis(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID BETWEEN ? AND ?");
                ps.setInt(1,3);
                ps.setInt(2,0);
                ps.setInt(3,13);
                ps.setInt(4,23);
                ps.setInt(5,137);
                ps.setInt(6,30);
                ps.setInt(7,39);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
         
        public ObservableList<Symptom> selectSymptomSkepsis(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID BETWEEN ? AND ?");
                ps.setInt(1,2);
                ps.setInt(2,12);
                ps.setInt(3,0);
                ps.setInt(4,20);
                ps.setInt(5,29);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        } 
        
        public ObservableList<Symptom> selectSymptomFovou(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,4);
                ps.setInt(2,14);
                ps.setInt(3,0);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        public ObservableList<Symptom> selectSymptomSynaisthimatos(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,0);
                ps.setInt(2,5);
                ps.setInt(3,15);
                ps.setInt(4,35);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        public ObservableList<Symptom> selectSymptomAgxous_Stres(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,0);
                ps.setInt(2,6);
                ps.setInt(3,16);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        public ObservableList<Symptom> selectSymptomLeitourgikotitas(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,0);
                ps.setInt(2,17);
                ps.setInt(3,137);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        public ObservableList<Symptom> selectSymptomDrastiriotitas(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,0);
                ps.setInt(2,8);
                ps.setInt(3,28);
                ps.setInt(3,38);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        public ObservableList<Symptom> selectSymptomYpnou(){
            connection = Database_Connection.Connector();
            ObservableList<Symptom> symptomsData = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM symptoms WHERE CATEGORY_ID=? OR CATEGORY_ID=?");
                ps.setInt(1,0);
                ps.setInt(2,39);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                            String name = rs.getString("NAME");
                            String symptomId = rs.getString("ID");
                            //System.out.println("name : " + name);
                            //System.out.println("category : " + category);  
                            Symptom s = new Symptom(name,symptomId);
                            symptomsData.add(s);
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return symptomsData;
        }
        
        
        public ObservableList<Disorder> selectDisorder(int k){
            connection = Database_Connection.Connector();
            ObservableList<Disorder> disordersData = FXCollections.observableArrayList();
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM disorders WHERE ID = ?");
                ps.setInt(1, k);
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()) {
                                
				
                                String name = rs.getString("NAME");
                                String subCategory = rs.getString("SUBCATEGORY");
                                boolean icd10 = rs.getBoolean("ICD10");
                                boolean dsm5 = rs.getBoolean("DSM");
				//System.out.println("name : " + name);
                                //System.out.println("category : " + category);  
                                Disorder d = new Disorder(name,subCategory,icd10,dsm5,100);
                                disordersData.add(d);
			}
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            return disordersData;
        }
        
        public int[][] getDisorders(){
            String[] symptoms;
            int[][] a = new int[20][40];
            int i = 0;
            connection = Database_Connection.Connector();
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT SYMPTOMS FROM DISORDERS");
                ResultSet rs = ps.executeQuery();
                System.out.println("Select Successfull");
                while (rs.next()){
                    symptoms = rs.getString("SYMPTOMS").split(",");
                    for ( int j = 0; j < symptoms.length; j++){
                        a[i][j] = Integer.parseInt(symptoms[j]);
                        System.out.println(a[i][j]);
                    } 
                    i++;
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            return a;
        }
        
        public void insertSymptoms(String arr[][]){
            connection = Database_Connection.Connector();
            for ( int i = 0; i < 118; i++)
            {
                try{
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO symptoms (ID,NAME,DURATION,FREQUENCY,CATEGORY,CATEGORY_ID)" + "VALUES(?,?,?,?,?,?)");
                    ps.setString(1, arr[i][0] );
                    ps.setString(2, arr[i][1]);
                    if ( !arr[i][3].equals("")){
                        ps.setInt(3,1);
                    }else{
                        ps.setInt(3,0);
                    }
                    if ( !arr[i][4].equals("")){
                        ps.setInt(4,1);
                    }else{
                        ps.setInt(4,0);
                    }
                    ps.setString(5,arr[i][2]);
                    ps.setInt(6,Integer.parseInt(arr[i][12]));
                    ps.executeUpdate();
                    System.out.println("Insert " + i + " Successfull");
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
        
}
