package com.example.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DoubleCheeseDecorator extends AbstractPizzaOrderDecorator {
    public DoubleCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " sometimes tells us a cheesy joke";
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + Double Cheese";
    }
}
