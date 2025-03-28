/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity.pkg2;

/**
 *
 * @author yuanb
 */
public class Motorcyle extends Vehicle {

    private boolean hasHelmelRental;

    public Motorcyle(String make, String model, double RentalPrice, boolean hasHelmetRental) {
        super(make, model, RentalPrice);
        this.hasHelmelRental = hasHelmetRental;

    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Helmet Rental Available: " + (hasHelmelRental ? "YES" : "NO"));
    }
}
