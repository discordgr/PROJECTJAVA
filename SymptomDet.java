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
public class SymptomDet {
    
    private String name,symptomId,durPeriod,freqPeriod;
    private double durNumber,freqNumber;

    public SymptomDet(String name, String symptomId, String durPeriod, String freqPeriod, int durNumber, int freqNumber) {
        this.name = name;
        this.symptomId = symptomId;
        this.durPeriod = durPeriod;
        this.freqPeriod = freqPeriod;
        this.durNumber = durNumber;
        this.freqNumber = freqNumber;
    }

    public SymptomDet(String name, String symptomId) {
        this.name = name;
        this.symptomId = symptomId;
    }

    public SymptomDet() {
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    public String getDurPeriod() {
        return durPeriod;
    }

    public void setDurPeriod(String durPeriod) {
        this.durPeriod = durPeriod;
    }

    public String getFreqPeriod() {
        return freqPeriod;
    }

    public void setFreqPeriod(String freqPeriod) {
        this.freqPeriod = freqPeriod;
    }

    public double getDurNumber() {
        return durNumber;
    }

    public void setDurNumber(double durNumber) {
        this.durNumber = durNumber;
    }

    public double getFreqNumber() {
        return freqNumber;
    }

    public void setFreqNumber(double freqNumber) {
        this.freqNumber = freqNumber;
    }
    
    @Override
    public String toString(){
        return "Name of Symptom is: " + this.name + "\nId of Symptom is: " + this.symptomId + "\nDuration Period is: " + this.durPeriod + "\nDuration Number is: " + this.durNumber + "\nFrequency Period is: " + this.freqPeriod + "\nFrequency Number is: " + this.freqNumber;
    }
    
    
    
    
}
