package org.yearup.model;
public class LeaseContract extends Contract {
    private DealershipFileManager dealershipFileManager;
    private Dealership dealership;

    public LeaseContract(String date, String name, String email, int VID) {
        super(date, name, email, VID);
        initializeDealership();
    }

    // Initialize DealershipFileManager and Dealership objects
    private void initializeDealership() {
        dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    // Retrieve the original price of the vehicle from the dealership
    private double getOriginalPrice() {
        for (Vehicle vehicle : dealership.getAllVehicle()) {
            if (vehicle.getVin() == super.getVehicleID()) {
                return vehicle.getPrice();
            }
        }
        return 0.0;
    }

    // Calculate the expected ending value of the vehicle
    public double getExpectedEnding() {
        double originalPrice = getOriginalPrice();
        return originalPrice != 0 ? 0.5 * originalPrice : 0.0;
    }

    // Calculate the lease fee based on the original price of the vehicle
    public double getLeaseFee() {
        double originalPrice = getOriginalPrice();
        return originalPrice != 0 ? 0.07 * originalPrice : 0.0;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPercentageDepreciation = (4.0 / 12) / 100;

        // Calculate the monthly payment using the total price
        double principle = getTotalPrice();
        return principle * monthlyPercentageDepreciation / (1 - Math.pow(1 + monthlyPercentageDepreciation, -36));
    }

    @Override
    public double getTotalPrice() {
        double expectedEnding = getExpectedEnding();
        double leaseFee = getLeaseFee();

        // Calculate the total price including expected ending and lease fee
        return (2 * expectedEnding) - expectedEnding + leaseFee;
    }
}