package org.yearup.ui;

import org.yearup.JavaHelpers.ColorCodes;
import org.yearup.model.Dealership;
import org.yearup.model.DealershipFileManager;
import org.yearup.model.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager dealershipFileManager = new DealershipFileManager();


    public UserInterface() {
    }

    private void init() {
        //Initialize the dealership object
        this.dealership = dealershipFileManager.getDealership();

    }

    public void display() {

        init(); // initialize the dealership object

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // Main loop of the user interface
        while (!userInput.equals("99"))
        {
            System.out.println("-".repeat(27));
            System.out.printf(ColorCodes.BLACK_BACKGROUND+"WELCOME TO %s"+ColorCodes.RESET+
                    "\n",dealership.getName());
            System.out.println("-".repeat(27));

            displayMenu(); // Display the menu options
            userInput = scanner.nextLine();
            processRequests(userInput); // Process user input
        }


    }

    // Displays the menu options
    private void displayMenu() {
        System.out.println("1 - Find vehicle within price range");
        System.out.println("2 - Find vehicle by make / model");
        System.out.println("3 - Find vehicle by year");
        System.out.println("4 - Find vehicle by color");
        System.out.println("5 - Find vehicle by mileage range");
        System.out.println("6 - Find vehicle by type (car,truck,SUV,van)");
        System.out.println("7 - List All vehicle");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Select a Command: ");
    }

    // Process user requests based on the selected command
    private void processRequests(String userInput) {

        switch (userInput) {
            case "1": {
                processGetByPriceRequest();// Get vehicles within price range
                return;
            }
            case "2": {
                processGetByMakeModelRequest();// Get vehicles by make and model
                return;
            }
            case "3": {
                processGetByYearRequest();// Get vehicles by year range
                return;
            }
            case "4": {
                processGetByColorRequest();// Get vehicles by color
                return;
            }
            case "5": {
                processGetByMileageRequest();// Get vehicles by mileage range
                return;
            }
            case "6": {
                processGetByVehicleTypeRequest();// Get vehicles by type
                return;
            }
            case "7": {
                processAllVehiclesRequest();// List all vehicles
                return;
            }
            case "8": {
                processAddVehicleRequest();// Add a vehicle
                return;
            }
            case "9": {
                processRemoveVehicleRequest();// Remove a vehicle
                return;
            }
            case "99": {
                System.out.println("Thanking you for using our service");
                return;
            }
            default:{
                System.out.println(ColorCodes.YELLOW +"Unrecognized Input!"+ColorCodes.RESET);
            }
        }
    }

    // Displays the vehicles in a formatted table
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        System.out.println("-".repeat(71));
        System.out.printf(ColorCodes.BLACK_BACKGROUND+"%-7s %-7s %-10s %-8s %-8s %-7s %-10s %-7s"+ColorCodes.RESET+"\n",
                "VIN","YEAR","MODEL","MAKE","TYPE","COLOR","MILEAGE","PRICE");
        System.out.println("-".repeat(71));

        for (Vehicle vehicle : vehicles) {

            stringBuilder.append(String.format("%-7d %-7d %-10s %-8s %-8s %-7s %-10d %-7.2f\n"+
                            "-".repeat(71)+"\n", vehicle.getVin(), vehicle.getYear() ,vehicle.getModel(),
                    vehicle.getMake(), vehicle.getVehicleType(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice()));
        }

        System.out.println(stringBuilder.toString());
        System.out.print(ColorCodes.CYAN+"Press any key to continue: "+ColorCodes.RESET);
        scan.nextLine();
        System.out.println();
    }

    // Method to display all the vehicles in the dealership
    private void processAllVehiclesRequest() {

        // Get all the vehicles from the dealership and store them in an ArrayList
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();

        // Display the vehicles using the displayVehicles() method
        displayVehicles(vehicles);

    }

    // Method to get all the vehicles within a certain price range
    public void processGetByPriceRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY PRICE RANGE ~~"+ColorCodes.RESET);
        // Initialize the variables to store the min and max values of the price range
        double min, max;

        // Create a Scanner object to read user input
        Scanner scanNum = new Scanner(System.in);

        // Prompt the user to enter the min and max values of the price range
        System.out.print("Enter the min (price range): ");
        min = scanNum.nextDouble();
        System.out.print("Enter the max (price range): ");
        max = scanNum.nextDouble();
        scanNum.nextLine();

        // Get the vehicles within the specified price range and store them in an ArrayList
        ArrayList<Vehicle> vehicles = dealership.getVehicleByPrice(min, max);

        // Display the vehicles using the displayVehicles() method
        displayVehicles(vehicles);

    }

    // Method to get all the vehicles of a specific make and model
    public void processGetByMakeModelRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY Make-Model ~~"+ColorCodes.RESET);
        // Initialize the variables to store the make and model of the vehicle
        String make, model;

        // Create a Scanner object to read user input
        Scanner scanMakeModel = new Scanner(System.in);

        // Prompt the user to enter the make and model of the vehicle
        System.out.print("Enter the make of the vehicle: ");
        make = scanMakeModel.nextLine();
        System.out.print("Enter the model of the vehicle: ");
        model = scanMakeModel.nextLine();

        // Get the vehicles with the specified make and model and store them in an ArrayList
        ArrayList<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);

        // Display the vehicles using the displayVehicles() method
        displayVehicles(vehicles);

    }

    // Method to get all the vehicles within a certain year range
    public void processGetByYearRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY YEAR RANGE ~~"+ColorCodes.RESET);
        // Initialize the variables to store the min and max values of the year range
        int min, max;

        // Create a Scanner object to read user input
        Scanner scanNum = new Scanner(System.in);

        // Prompt the user to enter the min and max values of the year range
        System.out.print("Enter the min (year range): ");
        min = scanNum.nextInt();
        System.out.print("Enter the max (year range): ");
        max = scanNum.nextInt();

        // Get the vehicles within the specified year range and store them in an ArrayList
        ArrayList<Vehicle> vehicles = dealership.getVehicleByYear(min,max);

        // Display the vehicles using the displayVehicles() method
        displayVehicles(vehicles);

    }

    // Method to get all the vehicles of a specific color
    public void processGetByColorRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY COLOR ~~"+ColorCodes.RESET);
        // Initialize the variable to store the color of the vehicle
        String color;

        // Create a Scanner object to read user input
        Scanner scanNum = new Scanner(System.in);

        // Prompt the user to enter the color of the vehicle
        System.out.print("Enter the color of the vehicle: ");
        color = scanNum.nextLine();

        // Get the vehicles with the specified color and store them in an ArrayList
        ArrayList<Vehicle> vehicles = dealership.getVehicleByColor(color);

        // Display the vehicles using the displayVehicles() method
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY MILEAGE RANGE ~~"+ColorCodes.RESET);
        // Initialize the variables to store the min and max values of the mileage range
        int min, max;

        // Create a Scanner object to read user input
        Scanner scanNum = new Scanner(System.in);

        // Prompt user to enter min and max mileage
        System.out.print("Enter the min (Mileage range): ");
        min = scanNum.nextInt();
        System.out.print("Enter the max (Mileage range): ");
        max = scanNum.nextInt();

        // Get list of vehicles with mileage within the specified range
        ArrayList<Vehicle> vehicles = dealership.getVehicleByMileage(min,max);

        // Display the list of vehicles
        displayVehicles(vehicles);

    }

    // Prompt user to enter vehicle type
    public void processGetByVehicleTypeRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REQUEST BY VEHICLE TYPE ~~"+ColorCodes.RESET);
        // Initialize the variable to store the type of the vehicle
        String vehicleType;

        // Create a Scanner object to read user input
        Scanner scanNum = new Scanner(System.in);

        // Prompt user to enter vehicle type
        System.out.print("Enter the vehicle type: ");
        vehicleType = scanNum.nextLine();

        // Get list of vehicles of the specified type
        ArrayList<Vehicle> vehicles = dealership.getVehicleByType(vehicleType);

        // Display the list of vehicles
        displayVehicles(vehicles);

    }

    public void processAddVehicleRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ ADD A VEHICLE ~~"+ColorCodes.RESET);
        // Initialize the variable to store the vehicle details
        int vin;
        int year;
        String make;
        String model;
        String type;
        String color;
        int odometer;
        double price;
        Scanner scanCarDetails = new Scanner(System.in);

        // Prompt user to enter details of the new vehicle
        System.out.printf("Enter the vehicle vin: ");
        vin = scanCarDetails.nextInt();
        System.out.printf("Enter the vehicle year: ");
        year = scanCarDetails.nextInt();
        scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle make: ");
        make = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle model: ");
        model = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle type: ");
        type = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle color: ");
        color = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle odometer: ");
        odometer = scanCarDetails.nextInt();
        System.out.printf("Enter the vehicle price: ");
        price = scanCarDetails.nextDouble();

        // Add the new vehicle to the dealership's inventory
        dealership.addVehicle(new Vehicle(vin,year,make,model,type,color,odometer,price));

        // Save the updated dealership inventory to file
        dealershipFileManager.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest() {

        System.out.println(ColorCodes.WHITE_BACKGROUND+ColorCodes.BLACK+
                "~~ REMOVE A VEHICLE ~~"+ColorCodes.RESET);
        int vin;
        Scanner scanVin = new Scanner(System.in);

        // Prompt user to enter VIN of the vehicle to remove
        System.out.print("Enter the vehicles vin: ");
        vin = scanVin.nextInt();

        // Remove the specified vehicle from the dealership's inventory
        dealership.removeVehicle(vin);

        // Save the updated dealership inventory to file
        dealershipFileManager.saveDealership(dealership);


    }

}
