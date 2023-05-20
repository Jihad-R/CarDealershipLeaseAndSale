package org.yearup.model;

import org.yearup.JavaHelpers.ColorCodes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContractFileManager {

    public void saveContract(Contract contract){

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        ArrayList<Vehicle> inventory = dealershipFileManager.getDealership().getAllVehicle();
        Vehicle vehicle = null;
        for (int i=0;i < inventory.size();i++)
        {
            if (inventory.get(i).getVin() == contract.getVehicleID()) {
                vehicle = inventory.get(i);
                dealership.removeVehicle(vehicle.getVin());
                dealershipFileManager.saveDealership(dealership);
            }
            }

        FileWriter fileWriter = null;
        String info = null;
        try {
            fileWriter = new FileWriter("contracts.csv", true); // append the existing file

            if(contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;

                info = String.format("%s|%s|%s|%s|%s|%s|%s|%s" +
                        "|%s|%s|%s|%s|%s|%s|%s","LEASE",
                        leaseContract.getDate(),leaseContract.getName(),
                        leaseContract.getEmail(),leaseContract.getVehicleID(),vehicle.getYear(),
                        vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(),
                        vehicle.getOdometer(),vehicle.getPrice(),leaseContract.getExpectedEnding(),
                        leaseContract.getLeaseFee(),leaseContract.getTotalPrice(),leaseContract.getMonthlyPayment());
            }

            if(contract instanceof SaleContract) {
                SaleContract saleContract = (SaleContract) contract;

                info = String.format("%s|%s|%s|%s|%s|%s|%s|%s" +
                                "|%s|%s|%s|%s|%s|%s|%s","SALE",
                        saleContract.getDate(),saleContract.getName(),
                        saleContract.getEmail(),saleContract.getVehicleID(),vehicle.getYear(),
                        vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(),
                        vehicle.getOdometer(),vehicle.getPrice(),saleContract.getSalesTax(),
                        saleContract.getRecordingFee(),saleContract.getTotalPrice(),saleContract.getMonthlyPayment());
            }

            fileWriter.write(info);
        } catch (IOException e) {
            System.out.println(ColorCodes.RED+"Error occurred while writing to the file!"+ColorCodes.RESET);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(ColorCodes.RED+"Error occurred while closing the file!"+ColorCodes.RESET);
                }
            }
        }


    }

}
