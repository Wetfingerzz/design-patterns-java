package com.example.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ParmaRocketComboDecorator extends AbstractPizzaOrderDecorator {
    public ParmaRocketComboDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(12));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " sky-rockets to the Italy";
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + Parma Ham + Rocket";
    }
}
