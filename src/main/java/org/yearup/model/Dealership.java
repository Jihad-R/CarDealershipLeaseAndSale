package org.yearup.model;

import org.yearup.JavaHelpers.ColorCodes;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Get vehicles within a specified price range
    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesInRange.add(vehicle);
            }

        }

        return vehiclesInRange;
    }

    // Get vehicles by make and model
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {

        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeModel.add(vehicle);
            }

        }

        return vehiclesByMakeModel;
    }

    // Get vehicles within a specified year range
    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesInRange.add(vehicle);
            }
        }

        return vehiclesInRange;
    }

    // Get vehicles by color
    public ArrayList<Vehicle> getVehicleByColor(String color){

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle: inventory) {

                if (vehicle.getColor().equalsIgnoreCase(color)) {
                    vehicles.add(vehicle);
                }
            }

                return vehicles;

        }

    // Get vehicles within a specified mileage range
    public ArrayList<Vehicle> getVehicleByMileage ( int min, int max)
        {
            ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
            for (Vehicle vehicle : inventory) {

                if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                    vehiclesInRange.add(vehicle);
                }

            }

            return vehiclesInRange;

        }

    // Get vehicles of a specific type
    public ArrayList<Vehicle> getVehicleByType (String vehicleType)
        {
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle: inventory) {

                if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                    vehicles.add(vehicle);
                }
            }

            return vehicles;
        }

    // Get all vehicles in the inventory
    public ArrayList<Vehicle> getAllVehicle ()
        {

            return inventory;
        }

    // Add a vehicle to the inventory
    public void addVehicle (Vehicle vehicle)
        {
            inventory.add(vehicle);

            System.out.println();
            //Success message
            System.out.println(ColorCodes.GREEN+"Vehicle ADDED, VIN: "+vehicle.getVin()+ColorCodes.RESET);
            System.out.println();
        }

    // Remove a vehicle from the inventory based on VIN
    public void removeVehicle (int vin)
        {
            boolean found = false;

            for (int i=0; i< inventory.size();i++){
                if(inventory.get(i).getVin() == vin){
                    inventory.remove(i);
                    found = true;
                }
            }

            System.out.println();
            if(found)
                System.out.println(ColorCodes.GREEN+"Vehicle REMOVED, VIN: "+vin+ColorCodes.RESET);
            else
                System.out.println(ColorCodes.YELLOW+"Vehicle not found!".toUpperCase()+ColorCodes.RESET);
            System.out.println();
        }

    // Getter method for dealership name
    public String getName () {
            return name;
        }

    // Getter method for dealership address
    public String getAddress () {
            return address;
        }

    // Getter method for dealership phone number
    public String getPhone () {
            return phone;
        }
    }
