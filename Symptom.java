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
    
    private String name,category;
    
    public Symptom(String name,String category){
        this.name = name;
        this.category = category;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getCategory(){
        return this.category;
    }
   
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
}