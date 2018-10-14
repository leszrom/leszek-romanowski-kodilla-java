package com.kodilla.good.patterns.challenges.food2door;

public class DeliveryDto {
    private Customer customer;
    private Delivery delivery;
    private boolean isDeliveryPossible;

    public DeliveryDto(final Customer customer, final Delivery delivery, final boolean isDeliveryPossible) {
        this.customer = customer;
        this.delivery = delivery;
        this.isDeliveryPossible = isDeliveryPossible;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public boolean isDeliveryPossible() {
        return isDeliveryPossible;
    }
}
