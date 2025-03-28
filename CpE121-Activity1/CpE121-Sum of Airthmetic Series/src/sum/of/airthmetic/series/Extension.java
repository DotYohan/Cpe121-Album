/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum.of.airthmetic.series;

/**
 *
 * @author yuanb
 */
public class Extension {
    private int n;
    
    
    public int process (int d){
        this.n = d;
        for (int i = 1; i < d; i++) {
            n += i;
           
        }
        return n;
    }
    public void displayResult(){
        System.out.println("The Sum from " + n + " is: " + n);
    }
}
