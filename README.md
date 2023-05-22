# Car Dealership Management System 🏢

This is a Car Dealership Management System that allows users to manage a vehicle inventory for a dealership. It provides functionalities to add vehicles, remove vehicles, and perform various searches based on different criteria such as price, make, model, year, color, mileage, and vehicle type.
## Getting Started 🚀

To run this application, you'll need to have Java installed on your computer. You can download the latest version of Java [here](https://www.java.com/en/download/).

Once you have Java installed, open the IntellJ IDE. Then navigate to the main.java file and press run.

## Interesting Code <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
      @Override
    public double getMonthlyPayment() {
        double monthlyPercentageDepreciation = (4.0 / 12) / 100;

        // Calculate the monthly payment using the total price
        double principle = getTotalPrice();
        return principle * monthlyPercentageDepreciation / (1 - Math.pow(1 + monthlyPercentageDepreciation, -36));
    }
    
This code snippet is interesting because it calculates the monthly payment for a financial transaction based on a total price and a fixed monthly percentage depreciation rate. It demonstrates the application of financial calculations in programming, utilizes mathematical functions, and promotes modular code design.

## CLI Screenshots 📷
### Home Screen UI

![HomeScreen UI](screenshots/homeCar.png)

### List All Vehicles

![ListAllVehicle](screenshots/allCars.png)

### Add Vehicle

![AddVehicle](screenshots/AddCar.png)

### Remove Vehicle

![RemoveVehicle](screenshots/RemoveCar.png)

### Find Vehicle by Price

![findVehiclebyPrice](screenshots/priceCar.png)

### Find Vehicle by Year

![findVehiclebyYear](screenshots/yearCar.png)

#### Find Vehicle by Mileage

![findVehiclebyMileage](screenshots/MileageCar.png)

#### Find Vehicle by Color

![findVehiclebyColor](screenshots/colorCar.png)

#### Find Vehicle by Type

![findVehiclebyColor](screenshots/typeCar.png)

### Find Vehicle by Make-Model

![findVehiclebyMakeModel](screenshots/makemodel.png)

### Manage Contract Screen
![ManageContractScreen](screenshots/ManageContractScrn.png)

### Lease Vehicle
![LeaseVehicle](screenshots/LeaseVehicle.png)

### Sale Vehicle
![SaleVehicle](screenshots/SaleVehicle.png)

### Exit the application
![exitApplication](screenshots/ExitApp.png)

## How to use📋

Once the application is running, you can interact with the Dealership Management System through the command-line interface. The available commands are:

- `1`: Manage Dealership.
- `2`: Manage Lease/Sale Contracts.
- `3`: Exit.

Simply enter the corresponding command number and follow the prompts to perform the desired action.

## Code Structure 📁
The code is organized into several classes:

- `Main`: Contains the main method to start the application.
- `Dealership`: Represents a dealership and provides methods to manage the vehicle inventory.
- `Vehicle`: Represents a vehicle with its properties and getters.
- `DealershipFileManager`: Handles file operations to load and save dealership data.
- `DealershipUI`: Handles user input and displays the dealership management command-line interface.
- `MainMenuUI`: Handles user input and displays the main menu command-line interface.
- `ContractUI`: Handles user input and displays the contract management command-line interface.
- `ContractFileManager`: Handles file operations to load and save contract data.

## Class Relationship Diagram
The class relationship diagram illustrates the relationships of the Contract class with other classes in the application. It provides an overview of how the Contract class interacts with and depends on other classes for functionality.
![Class Diagram](screenshots/contractLeaseSaleUML.png)
- The `Contract` class represents a general contract and serves as the base class for LeaseContract and SaleContract.
- The `LeaseContract` class extends the Contract class and adds specific properties such as expectedEnding and leaseFee for lease contracts.
- The `SaleContract` class extends the Contract class and includes additional properties like recordingFee, isFinance, and salesTax for sale contracts.
