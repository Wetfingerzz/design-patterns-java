package com.example.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ChorizoOlivesComboDecorator extends AbstractPizzaOrderDecorator {
    public ChorizoOlivesComboDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " meets spicy and savory";
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + Chorizo + Olives";
    }
}
