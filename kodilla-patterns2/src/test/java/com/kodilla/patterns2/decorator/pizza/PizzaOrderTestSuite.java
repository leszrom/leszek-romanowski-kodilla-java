package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    private static final String BASIC_DESCRIPTION = "Basic pizza with tomato sauce and cheese";

    @Test
    public void should_return_cost_and_description_of_pizza_with_cheese_added() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);


        //When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals(new BigDecimal(18), cost);
        Assert.assertEquals(BASIC_DESCRIPTION.concat("\n+ cheese"), description);
    }

    @Test
    public void should_return_cost_and_description_of_pizza_with_cheese_cactus_and_chocolate() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new CactusDecorator(theOrder);
        theOrder = new ChocolateDecorator(theOrder);

        //When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals(new BigDecimal(36), cost);
        Assert.assertEquals(BASIC_DESCRIPTION
                .concat("\n+ cheese")
                .concat("\n+ cactus in the middle")
                .concat("\n+ chocolate covered"), description);
    }
}