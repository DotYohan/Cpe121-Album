/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity.pkg2;

/**
 *
 * @author yuanb
 */
public class truck extends Vehicle {

    private double payloadCapacity;

    public truck(String make, String model, double rentalPrice, double PayloadCapacity) {
        super(make, model, rentalPrice);
        this.payloadCapacity = PayloadCapacity;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
        
    }
}
