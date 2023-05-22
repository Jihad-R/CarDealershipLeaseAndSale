package org.yearup.model;

import java.util.ArrayList;

public class SaleContract extends Contract {
    private final double recordingFee = 100;
    private String isFinance;
    private final double salesTax = 0.05;
    private DealershipFileManager dealershipFileManager;
    private Dealership dealership;

    public SaleContract(String date, String name, String email, int vehicleID, String isFinance) {
        super(date, name, email, vehicleID);
        this.isFinance = isFinance;
        initializeDealership();
    }

    // Initialize DealershipFileManager and Dealership objects
    private void initializeDealership() {
        dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    // Determine the processing fee based on the vehicle price
    public double getProcessingFee() {
        double price = getVehiclePrice();
        return price < 10_000 ? 295 : 495;
    }

    public String isFinance() {
        return isFinance;
    }

    // Calculate the sales tax based on the vehicle price
    public double getSalesTax() {
        double price = getVehiclePrice();
        return salesTax * price;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehiclePrice();

        // Calculate the total price including vehicle price, sales tax, recording fee, and processing fee
        return price + getSalesTax() + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPercentageDepreciation;

        // Determine the monthly percentage depreciation and calculate the monthly payment
        if (getProcessingFee() == 295 && isFinance().equalsIgnoreCase("Yes")) {
            monthlyPercentageDepreciation = (4.25 / 12) / 100;
            return getTotalPrice() * monthlyPercentageDepreciation / (1 - Math.pow(1 + monthlyPercentageDepreciation, -48));
        }

        if (getProcessingFee() == 495 && isFinance().equalsIgnoreCase("Yes")) {
            monthlyPercentageDepreciation = (5.25 / 12) / 100;
            return getTotalPrice() * monthlyPercentageDepreciation / (1 - Math.pow(1 + monthlyPercentageDepreciation, -24));
        }

        return 0;
    }

    // Retrieve the price of the vehicle from the dealership
    private double getVehiclePrice() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        double price = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == super.getVehicleID()) {
                price = vehicle.getPrice();
                break;
            }
        }

        return price;
    }
}