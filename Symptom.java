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
public class Symptom {
    
    private String name,symptomId;
    
    public Symptom(String name,String symptomId){
        this.name = name;
        //this.category = category;
        this.symptomId = symptomId;
        //setGraphic(add_symptom);
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSymptomId(String symptomId){
        this.symptomId = symptomId;
    }
    
    public String getSymptomId(){
        return this.symptomId;
    }
}