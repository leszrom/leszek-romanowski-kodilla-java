package com.kodilla.good.patterns.challenges.food2door;

public class DeliveryRequest {

    private Customer customer;
    private Supplier supplier;
    private Delivery delivery;

    public DeliveryRequest(final Customer customer, final Supplier supplier, final Delivery delivery) {
        this.customer = customer;
        this.supplier = supplier;
        this.delivery = delivery;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Customer getCustomer() {
        return customer;
    }
}
