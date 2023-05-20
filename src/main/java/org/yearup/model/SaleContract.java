package org.yearup.model;

import java.util.ArrayList;

public class SaleContract extends Contract{

    private final double recordingFee = 100;
    private double processingFee;
    private boolean isFinance;
    private final double salesTax = 0.05;


    public SaleContract(String date, String name, String email, int vehicleID, double processingFee, boolean isFinance) {
        super(date, name, email, vehicleID);
        this.processingFee = processingFee;
        this.isFinance = isFinance;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        Vehicle vehicle = null;

        for(int i=0;i<dealership.getAllVehicle().size();i++){

            if(vehicles.get(i).getVin() == super.getVehicleID())
            {
                vehicle = vehicles.get(i);
            }

        }

        return vehicle.getPrice() < 10000 ? 295 : 495 ;


    }

    public boolean isFinance() {
        return isFinance;
    }

    public double getSalesTax() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        Vehicle vehicle = null;

        for(int i=0;i<dealership.getAllVehicle().size();i++){

            if(vehicles.get(i).getVin() == super.getVehicleID())
            {
                vehicle = vehicles.get(i);
            }

        }


        return salesTax*vehicle.getPrice();
    }

    @Override
    public double getTotalPrice() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        Vehicle vehicle = null;

        for(int i=0;i<dealership.getAllVehicle().size();i++){

            if(vehicles.get(i).getVin() == super.getVehicleID())
            {
                vehicle = vehicles.get(i);
            }

        }

        return vehicle.getPrice() + (getSalesTax()*vehicle.getPrice()) + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPercentageDepreciation;

        if (getProcessingFee() == 295 && isFinance() == true) {
            monthlyPercentageDepreciation = (4.25/12)/100;
            return getTotalPrice()*monthlyPercentageDepreciation / (1 - Math.pow(1+monthlyPercentageDepreciation,-48));
        }

        if (getProcessingFee() == 495 && isFinance() == true) {
            monthlyPercentageDepreciation = (5.25/12)/100;
            return getTotalPrice()*monthlyPercentageDepreciation / (1 - Math.pow(1+monthlyPercentageDepreciation,-24));
        }

        return 0;
    }
}
