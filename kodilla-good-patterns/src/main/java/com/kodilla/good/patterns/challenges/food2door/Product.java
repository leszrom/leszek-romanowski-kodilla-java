package com.kodilla.good.patterns.challenges.food2door;

public class Product {
    private String productName;
    private String units;

    public Product(final String productName, final String units) {
        this.productName = productName;
        this.units = units;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnits() {
        return units;
    }
}
