package com.example.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class AbstractTaxiOrderDecorator implements TaxiOrder {
    private final TaxiOrder taxiOrder;

    @Override
    public BigDecimal getCost() {
        return taxiOrder.getCost();
    }

    @Override
    public String getDescription() {
        return taxiOrder.getDescription();
    }

    protected AbstractTaxiOrderDecorator(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;


    }
}
