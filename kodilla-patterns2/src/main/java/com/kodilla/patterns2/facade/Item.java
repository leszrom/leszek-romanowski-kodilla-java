package com.kodilla.patterns2.facade;

public class Item {
    private final Long productId;
    private final double quantity;

    public Item(Long productId, double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }
}
