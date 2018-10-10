package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class ToolsOrderService implements ProductOrderService {

//    private ProductRepositoryDatabase productRepositoryDatabase;
//
//    public ToolsOrderService(final ProductRepositoryDatabase productRepositoryDatabase) {
//        this.productRepositoryDatabase = productRepositoryDatabase;
//    }

    @Override
    public boolean order(User user, Product product, int quantity) {
        System.out.println("Checking if requested quantity is available...");
        System.out.println("Products are available.");
        System.out.println();
        return true;
//        return productRepositoryDatabase.getProducts().get(product) >= quantity;
    }
}
