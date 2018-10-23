package com.kodilla.patterns.strategy.broker.customers;

import com.kodilla.patterns.strategy.broker.Customer;
import com.kodilla.patterns.strategy.broker.predictors.BalancedPredictor;

public class CorporateCustomer extends Customer {
    public CorporateCustomer(final String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
