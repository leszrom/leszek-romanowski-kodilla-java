package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("John", "Smith", "john_smith@mail.com");

        Product product = new Product(432,"Brash", 12.40);
        int quantity = 6;

        return new OrderRequest(user, product, quantity);
    }

}
