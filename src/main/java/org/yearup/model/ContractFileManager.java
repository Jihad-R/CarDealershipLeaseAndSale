package org.yearup.model;

import org.yearup.JavaHelpers.ColorCodes;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        ArrayList<Vehicle> inventory = dealership.getAllVehicle();
        Vehicle vehicle = findVehicleById(inventory, contract.getVehicleID());

        if (vehicle == null) {
            System.out.println(ColorCodes.YELLOW+"No Vehicle with such ID is found!"+ColorCodes.RESET);
            return;
        }

        // Remove the vehicle from the dealership
        dealership.removeVehicle(vehicle.getVin());
        dealershipFileManager.saveDealership(dealership);

        // Generate contract information
        String contractInfo = generateContractInfo(contract, vehicle);

        // Write contract information to file
        writeContractToFile(contractInfo);
    }

    // Find a vehicle in the inventory by ID
    private Vehicle findVehicleById(ArrayList<Vehicle> inventory, int vehicleID) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vehicleID) {
                return vehicle;
            }
        }
        return null;
    }

    // Generate contract information based on the contract type
    private String generateContractInfo(Contract contract, Vehicle vehicle) {
        String contractInfo = "";

        if (contract instanceof LeaseContract) {
            LeaseContract leaseContract = (LeaseContract) contract;

            contractInfo = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f\n",
                    "LEASE", leaseContract.getDate(), leaseContract.getName(), leaseContract.getEmail(),
                    leaseContract.getVehicleID(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice(),
                    leaseContract.getExpectedEnding(), leaseContract.getLeaseFee(), leaseContract.getTotalPrice(),
                    leaseContract.getMonthlyPayment());
        }

        if (contract instanceof SaleContract) {
            SaleContract saleContract = (SaleContract) contract;

            contractInfo = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n",
                    "SALE", saleContract.getDate(), saleContract.getName(), saleContract.getEmail(),
                    saleContract.getVehicleID(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice(),
                    saleContract.getSalesTax(), saleContract.getRecordingFee(), saleContract.getProcessingFee(),
                    saleContract.getTotalPrice(), saleContract.isFinance().toUpperCase(),
                    saleContract.getMonthlyPayment());
        }

        return contractInfo;
    }

    // Write contract information to file
    private void writeContractToFile(String contractInfo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("contracts.csv", true); // append the existing file
            fileWriter.write(contractInfo);
        } catch (IOException e) {
            System.out.println(ColorCodes.RED + "Error occurred while writing to the file!" + ColorCodes.RESET);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(ColorCodes.RED + "Error occurred while closing the file!" + ColorCodes.RESET);
                }
            }
        }
    }
}