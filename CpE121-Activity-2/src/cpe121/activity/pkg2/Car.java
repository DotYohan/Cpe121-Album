/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity.pkg2;

/**
 *
 * @author yuanb
 */
public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String make, String model, double rentalPrice, int numberOfDoors) {
        super(make, model, rentalPrice);
        this.numberOfDoors = numberOfDoors;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}
