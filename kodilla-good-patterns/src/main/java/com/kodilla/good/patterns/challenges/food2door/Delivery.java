package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class Delivery {
    private HashMap<Product, Integer> listOfProducts;

    public Delivery(final HashMap<Product, Integer> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public HashMap<Product, Integer> getListOfProducts() {
        return listOfProducts;
    }

}
