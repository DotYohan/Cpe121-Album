/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity1.pkg1;

/**
 *
 * @author yuanb
 */
public class employee {
     private String Name;
    private int EmployeeID;
    private String department;
    private double monthlySalary;
    
    public employee(){
        this.Name = "";
        this.EmployeeID = 0;
        this.department = "";
        this.monthlySalary = 0.00;
        
    }
    public double calculateAnnualSalary(){
    return monthlySalary * 12;
    }
    
    public employee( String name, int employeeId, String Department, double monthlySalary){
        this.Name = name;
        this.EmployeeID = employeeId;
        this.department = Department;
        this.monthlySalary = monthlySalary;
        
    }
    
    public void DisplayEmployeeInfo(){
        System.out.println("Employee Information");
        System.out.println("Name: " + Name);
        System.out.println("Employee ID: " + EmployeeID);
        System.out.println("Department: " + department);
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Annual Salary: $" + calculateAnnualSalary());
    }
    public String getName(){
        return Name;
    }
    public void setName(String name){
        this.Name = name;
    } 
}
