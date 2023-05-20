package org.yearup.ui;

import org.yearup.model.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContractUI {

    private DealershipFileManager dealershipFileManager = new DealershipFileManager();
    private ContractFileManager contractFileManager = new ContractFileManager();
    private UserInterface userInterface = new UserInterface();
    private Scanner scanner = new Scanner(System.in);

    public void run (){

        String userInput;

        System.out.println("Hi Welcome to "+dealershipFileManager.getDealership());
        System.out.println("What would you like to do?");
        System.out.println("1 - List Available Vehicle? ");
        System.out.println("2 - Lease a Vehicle");
        System.out.println("3 - Purchase a Vehicle");
        System.out.print("Please select a command: ");
        userInput = scanner.nextLine();

        switch (userInput)
        {
            case "1":
            {
                userInterface.processAllVehiclesRequest();break;
            }
            case "2":
            {
                processVehicleLease();break;
            }
            case "3":
            default:
        }


    }

    private void processVehicleLease() {

        System.out.println("~~~Lease Vehicle~~~");
        System.out.print("Enter the ID of the vehicle to lease: ");
        int vehicleID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        LeaseContract leaseContract = new LeaseContract(date,name,email,vehicleID);

        String info = String.format("\nLease Contract\n"+"-".repeat(15)+
                "\nDate: %s\nName: %s" +
                "\nEmail: %s\nVehicle ID: %s\nExpected expected value: %s\nLeasing Fee: %s\nTotal Cost: %s",leaseContract.getDate(),
                leaseContract.getName(), leaseContract.getEmail(),leaseContract.getVehicleID(),
                leaseContract.getExpectedEnding(),leaseContract.getLeaseFee(),leaseContract.getTotalPrice());


        contractFileManager.saveContract(leaseContract);

    }

}
