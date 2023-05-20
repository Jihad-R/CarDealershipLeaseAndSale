package org.yearup.model;

import java.util.ArrayList;

public class SaleContract extends Contract{

    private final double recordingFee = 100;
    private String isFinance;
    private final double salesTax = 0.05;

    DealershipFileManager dealershipFileManager = new DealershipFileManager();
    Dealership dealership = dealershipFileManager.getDealership();

    public SaleContract(String date, String name, String email, int vehicleID, String isFinance)
    {
        super(date, name, email, vehicleID);
        this.isFinance = isFinance;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee()
    {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        double price = 0;

        for(Vehicle vehicle: vehicles){

            if(vehicle.getVin() == super.getVehicleID())
            {
                price = vehicle.getPrice();
            }

        }

        return price < 10000 ? 295 : 495 ;


    }

    public String isFinance() {
        return isFinance;
    }

    public double getSalesTax()
    {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        double price = 0;

        for(Vehicle vehicle: vehicles){

            if(vehicle.getVin() == super.getVehicleID())
            {
                price = vehicle.getPrice();
            }

        }


        return salesTax*price;
    }

    @Override
    public double getTotalPrice()
    {

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();

        double price = 0;

        for(Vehicle vehicle: vehicles){

            if(vehicle.getVin() == super.getVehicleID())
            {
                price = vehicle.getPrice();
            }

        }

        return price + getSalesTax() + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment()
    {
        double monthlyPercentageDepreciation;

        if (getProcessingFee() == 295 && isFinance().equalsIgnoreCase("Yes")) {
            monthlyPercentageDepreciation = (4.25/12)/100;
            return getTotalPrice()*monthlyPercentageDepreciation / (1 - Math.pow(1+monthlyPercentageDepreciation,-48));
        }

        if (getProcessingFee() == 495 && isFinance().equalsIgnoreCase("Yes")) {
            monthlyPercentageDepreciation = (5.25/12)/100;
            return getTotalPrice()*monthlyPercentageDepreciation / (1 - Math.pow(1+monthlyPercentageDepreciation,-24));
        }

        return 0;
    }
}
