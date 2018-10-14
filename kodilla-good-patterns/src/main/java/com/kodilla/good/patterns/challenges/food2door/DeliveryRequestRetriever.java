package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class DeliveryRequestRetriever {

    public DeliveryRequest retrieveDeliveryRequest() {
        Customer customer = new Customer("John Smith", "john@john.com");
        Supplier supplier = new Supplier("Extra Food Shop");
        Delivery delivery = new Delivery(getListProducts());
        return new DeliveryRequest(customer, supplier, delivery);
    }

    private HashMap<Product, Integer> getListProducts() {
        HashMap<Product, Integer> products = new HashMap<>();
        products.put(new Product("Milk", "liters"), 15);
        products.put(new Product("Potato", "kg"), 30);
        products.put(new Product("Carrot", "kg"), 30);
        products.put(new Product("Cabbage", "pcs."), 30);
        return products;
    }

}
