package com.kodilla.patterns.strategy.broker.customers;

import com.kodilla.patterns.strategy.broker.Customer;
import com.kodilla.patterns.strategy.broker.predictors.AggressivePredictor;

public class IndividualYoungCustomer extends Customer {
    public IndividualYoungCustomer(final String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
