package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class VipCarDecorator extends AbstractTaxiOrderDecorator {
    public VipCarDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    public String getDescription() {
        return super.getDescription().concat(" variant VIP");
    }
}
