package com.kodilla.good.patterns.challenges;

public class ToolsOrderService implements ProductOrderService {
    @Override
    public boolean order(User user, Product product, int quantity) {
        System.out.println("Checking if requested quantity is available...");
        System.out.println("Products are available.");
        System.out.println();
        return true;
    }
}
