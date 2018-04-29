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
    private int durNumber,freqNumber;

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

    public int getDurNumber() {
        return durNumber;
    }

    public void setDurNumber(int durNumber) {
        this.durNumber = durNumber;
    }

    public int getFreqNumber() {
        return freqNumber;
    }

    public void setFreqNumber(int freqNumber) {
        this.freqNumber = freqNumber;
    }
    
    
    
    
}
