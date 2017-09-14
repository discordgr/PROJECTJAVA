/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

/**
 *
 * @author Panayiotis
 */
public class Patient {
    
    private String firstname,lastname,age,gender,family,kids,education;
    
    public Patient(String firstname,String lastname,String age,String gender,String family,String kids,String education){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.family = family;
        this.kids = kids;
        this.education = education;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public String getAge(){
        return this.age;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getFamily(){
        return this.family;
    }
    
    public String getKids(){
        return this.kids;
    }
    
    public String getEducation(){
        return this.education;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
}