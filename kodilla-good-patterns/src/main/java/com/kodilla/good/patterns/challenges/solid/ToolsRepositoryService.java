package com.kodilla.good.patterns.challenges.solid;

public class ToolsRepositoryService implements ProductRepositoryService {

    @Override
    public void createOrder(final User user, final Product product, final int quantity) {
        System.out.println("Creating an order for: " + user.getFirstName()
                + " " + user.getLastName());
        System.out.println("Product: " + product.getName());
        System.out.println("Quantity: " + quantity + " pcs.");
        System.out.println("Total price: " + quantity*product.getUnitPrice());
        System.out.println();
        System.out.println("Reducing quantity in database");
    }
}
