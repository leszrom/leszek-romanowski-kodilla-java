package com.kodilla.patterns.strategy.broker.customers;

import com.kodilla.patterns.strategy.broker.Customer;
import com.kodilla.patterns.strategy.broker.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {
    public IndividualCustomer(final String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
