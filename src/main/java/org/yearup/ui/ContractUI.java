package org.yearup.ui;

import org.yearup.JavaHelpers.ColorCodes;
import org.yearup.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContractUI {
    private DealershipFileManager dealershipFileManager;
    private ContractFileManager contractFileManager;
    private DealershipUI dealershipUI;
    private MainMenuUI mainMenu;
    private Scanner scanner;

    public ContractUI() {
        dealershipFileManager = new DealershipFileManager();
        contractFileManager = new ContractFileManager();
        dealershipUI = new DealershipUI();
        mainMenu = new MainMenuUI();
        scanner = new Scanner(System.in);
    }

    public void run() {
        String userInput = "";
        while (!userInput.equalsIgnoreCase("X")) {
            System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                    "Hi Welcome to " + dealershipFileManager.getDealership().getName()+ColorCodes.RESET);
            System.out.println("What would you like to do?");
            System.out.println("1 - Lease a Vehicle");
            System.out.println("2 - Purchase a Vehicle");
            System.out.println("99 - Go back to the main menu");
            System.out.print("Please select a command: ");
            userInput = scanner.nextLine();

            switch (userInput.toUpperCase()) {
                case "1":
                    processVehicleLease();
                    break;
                case "2":
                    processVehicleSale();
                    break;
                case "99":
                    mainMenu.run();
                    break;
                default:
                    System.out.println("Invalid Input! Try again.");
                    break;
            }
        }
    }

    // Process vehicle lease
    private void processVehicleLease() {
        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+"~ Lease Vehicle ~"+
                ColorCodes.RESET);
        System.out.print("Enter the ID of the vehicle to lease: ");
        int vehicleID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicleID);

        contractFileManager.saveContract(leaseContract);
    }

    // Process vehicle sale
    private void processVehicleSale() {
        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+"~ Sale Vehicle ~"
                +ColorCodes.RESET);
        System.out.print("Enter the ID of the vehicle to purchase: ");
        int vehicleID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        System.out.print("Is the vehicle financed? ");
        String isFinanced = scanner.nextLine();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        SaleContract saleContract = new SaleContract(date, name, email, vehicleID, isFinanced);

        contractFileManager.saveContract(saleContract);
    }
}
