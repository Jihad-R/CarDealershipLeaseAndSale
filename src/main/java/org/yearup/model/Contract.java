package org.yearup.model;

public abstract class Contract {

    private String date;
    private String name;
    private String email;
    private int vehicleID;

    public Contract(String date, String name, String email, int vehicleID) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleID = vehicleID;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

}
