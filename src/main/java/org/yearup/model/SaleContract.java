package org.yearup.model;

public class SaleContract extends Contract{

    private double recordingFee;
    private double processingFee;
    private boolean isFinance;

    public SaleContract(String date, String name, String email, double sold, double recordingFee, double processingFee, boolean isFinance) {
        super(date, name, email, sold);
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinance = isFinance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
