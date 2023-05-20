package org.yearup.model;

public class LeaseContract extends Contract{


    DealershipFileManager dealershipFileManager = new DealershipFileManager();
    Dealership dealership = dealershipFileManager.getDealership();

    public LeaseContract(String date, String name, String email, int VID) {
        super(date, name, email,VID );

    }

    public double getExpectedEnding() {

        double originalPrice = 0;
        for(Vehicle vehicle: dealership.getAllVehicle())
        {
            if(vehicle.getVin() == super.getVehicleID())
            {
                originalPrice = vehicle.getPrice();

            }
        }

        if (originalPrice != 0)
        return 0.5 * originalPrice;

        throw new RuntimeException();
    }

    public double getLeaseFee() {

        double originalPrice = 0;
        for(Vehicle vehicle: dealership.getAllVehicle())
        {
            if(vehicle.getVin() == super.getVehicleID())
            {
                originalPrice = vehicle.getPrice();
            }
        }

        if (originalPrice != 0)
            return 0.07 * originalPrice;

        throw new RuntimeException();
    }

    @Override
    public double getMonthlyPayment() {

        //monthlyPrinciplePay = (principle * interestRate) / (1 - Math.pow((1 + interestRate), (-loanLength)));
        double monthlyPercentageDepreciation = (4/12)/100;
        return getTotalPrice()*monthlyPercentageDepreciation / (1 - Math.pow(1+monthlyPercentageDepreciation,-36));
    }

    @Override
    public double getTotalPrice() {

        return  ((2*getExpectedEnding()) - getExpectedEnding()) + getLeaseFee();
    }
}
