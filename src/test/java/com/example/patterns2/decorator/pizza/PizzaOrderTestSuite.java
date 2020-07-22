package com.example.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        //when
        BigDecimal cost = order.getCost();
        //then
        Assert.assertEquals(cost,new BigDecimal(15));
        System.out.println(cost);
    }
    @Test
    public void testBasicPizzaOrderGetDescription() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Simple yet weirdly satisfying");
        System.out.println(description);
    }
    @Test
    public void testBasicPizzaOrderGetIngredients() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        //when
        String ingredients = order.getIngredients();
        //then
        Assert.assertEquals(ingredients, "Tomato Sauce + Mozzarella");
        System.out.println(ingredients);
    }
    @Test
    public void testBasicChorizoOlivesComboGetCostDescriptionAndIngredients() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ChorizoOlivesComboDecorator(order);
        //when
        BigDecimal cost = order.getCost();
        String description = order.getDescription();
        String ingredients = order.getIngredients();
        //then
        Assert.assertEquals(cost, new BigDecimal(25));
        Assert.assertEquals(description, "Simple yet weirdly satisfying meets spicy and savory");
        Assert.assertEquals(ingredients, "Tomato Sauce + Mozzarella + Chorizo + Olives");
        System.out.println(cost);
        System.out.println(description);
        System.out.println(ingredients);
    }
    @Test
    public void testBasicChorizoOlivesParmaRocketComboGetCostDescriptionAndIngredients() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ChorizoOlivesComboDecorator(order);
        order = new ParmaRocketComboDecorator(order);
        //when
        BigDecimal cost = order.getCost();
        String description = order.getDescription();
        String ingredients = order.getIngredients();
        //then
        Assert.assertEquals(cost, new BigDecimal(37));
        Assert.assertEquals(description, "Simple yet weirdly satisfying meets spicy and savory sky-rockets to the Italy");
        Assert.assertEquals(ingredients, "Tomato Sauce + Mozzarella + Chorizo + Olives + Parma Ham + Rocket");
        System.out.println(cost);
        System.out.println(description);
        System.out.println(ingredients);
    }
    @Test
    public void testBasicChorizoOlivesParmaRocketDoubleCheeseComboGetCostDescriptionAndIngredients() {
        //given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ChorizoOlivesComboDecorator(order);
        order = new ParmaRocketComboDecorator(order);
        order = new DoubleCheeseDecorator(order);
        //when
        BigDecimal cost = order.getCost();
        String description = order.getDescription();
        String ingredients = order.getIngredients();
        //then
        Assert.assertEquals(cost, new BigDecimal(44));
        Assert.assertEquals(description,
                "Simple yet weirdly satisfying meets spicy and savory sky-rockets to the Italy sometimes tells us a cheesy joke");
        Assert.assertEquals(ingredients, "Tomato Sauce + Mozzarella + Chorizo + Olives + Parma Ham + Rocket + Double Cheese");
        System.out.println(cost);
        System.out.println(description);
        System.out.println(ingredients);
    }
}
