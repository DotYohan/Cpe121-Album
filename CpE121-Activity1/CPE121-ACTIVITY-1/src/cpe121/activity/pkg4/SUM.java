/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity.pkg4;

/**
 *
 * @author yuanb
 */
public class SUM {
    private int number;
    private int numb;
    
    public SUM(){
        this.number = 0;
        this.numb = 0;
        
        
    }
    
    public void CalculateSum(int n){
        numb = n;
        for (int i = 1; i < numb; i++) {
            number += i;
            
        }
    }
    public void DisplayResult(){
        System.out.println("The Arithmetic Series Sum of " + numb + " is " + number);
    }
    
}
