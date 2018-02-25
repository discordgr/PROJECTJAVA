/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

/**
 *
 * @author Giannis
 */
public class Disorder {
    
    private String name, subCategory;
    private boolean icd10,dsm5;
    private float percent;

    public Disorder(String name, String subCategory, boolean icd10, boolean dsm5, float percent) {
        this.name = name;
        this.subCategory = subCategory;
        this.icd10 = icd10;
        this.dsm5 = dsm5;
        this.percent = percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getPercent() {
        return percent;
    }

    public String getName() {
        return name;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public boolean getIcd10() {
        return icd10;
    }

    public boolean getDsm5() {
        return dsm5;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setIcd10(boolean icd10) {
        this.icd10 = icd10;
    }

    public void setDsm5(boolean dsm5) {
        this.dsm5 = dsm5;
    }
    
    
    
}
