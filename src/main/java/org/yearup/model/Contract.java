package org.yearup.model;

public abstract class Contract {

    private String date;
    private String name;
    private String email;
    private double sold;

    public Contract(String date, String name, String email, double sold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.sold = sold;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSold() {
        return sold;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

}
