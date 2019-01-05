package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ExpressDecorator extends AbstractTaxiOrderDecorator {
    public ExpressDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    public String getDescription() {
        return super.getDescription().concat(" express service");
    }
}
