package org.yearup.model;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getter for VIN
    public int getVin() {
        return vin;
    }

    // Getter for year
    public int getYear() {
        return year;
    }

    // Getter for make
    public String getMake() {
        return make;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Getter for odometer reading
    public int getOdometer() {
        return odometer;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }
}
