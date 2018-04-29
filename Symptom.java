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
    private int subSymptomCategory;
    private boolean duration,frequency;
    
    
    public Symptom(String name,String symptomId, int subSymptomCategory){
        this.name = name;
        //this.category = category;
        this.symptomId = symptomId;
        this.subSymptomCategory = subSymptomCategory;
    }
    
    public boolean getDuration() {
        return duration;
    }

    public void setDuration(boolean duration) {
        this.duration = duration;
    }

    public boolean getFrequency() {
        return frequency;
    }

    public void setFrequency(boolean frequency) {
        this.frequency = frequency;
    }

    public void setSubSymptomCategory(int subSymptomCategory) {
        this.subSymptomCategory = subSymptomCategory;
    }

    public int getSubSymptomCategory() {
        return subSymptomCategory;
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