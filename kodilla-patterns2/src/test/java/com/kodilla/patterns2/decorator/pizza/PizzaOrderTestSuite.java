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

}