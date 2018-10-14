package com.kodilla.good.patterns.challenges.solid;

public class OrderDto {
    private User user;
    private boolean isAvailableInStock;

    public OrderDto(final User user, final boolean isAvailableInStock) {
        this.user = user;
        this.isAvailableInStock = isAvailableInStock;
    }

    public User getUser() {
        return user;
    }

    public boolean isAvailableInStock() {
        return isAvailableInStock;
    }
}
