package com.kodilla.good.patterns.challenges;

import java.util.HashMap;

public interface ProductRepositoryDatabase {
    //Map of products with available quantity.
    HashMap<Product, Integer> getProducts();
}

