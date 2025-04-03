/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentTransfer;

/**
 *
 * @author yuanb
 */
public class Student {
    private String name;
    private int id;

    // Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Display student information
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
