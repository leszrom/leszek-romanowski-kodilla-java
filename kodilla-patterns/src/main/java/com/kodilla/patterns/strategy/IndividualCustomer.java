package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {
    public IndividualCustomer(final String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
