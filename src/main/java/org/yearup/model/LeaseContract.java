package org.yearup.model;

public class LeaseContract extends Contract{

    private double expectedEnding;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, double sold, double expectedEnding, double leaseFee) {
        super(date, name, email, sold);
        this.expectedEnding = expectedEnding;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEnding() {
        return expectedEnding;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }
}
