package com.kodilla.good.patterns.challenges;

public class Product {
    private int idNumber;
    private String name;
    private double unitPrice;

    public Product(final int idNumber, final String name, final double unitPrice) {
        this.idNumber = idNumber;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}