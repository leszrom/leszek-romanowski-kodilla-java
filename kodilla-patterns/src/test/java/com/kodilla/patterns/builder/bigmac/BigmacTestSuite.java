package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void should_create_burger_with_indicated_products() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bread(Bread.BUN_SESAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredient.BACON)
                .ingredients(Ingredient.CHILLI)
                .ingredients(Ingredient.CHEESE)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String bread = bigmac.getBread().getType();
        int howManyBurgers = bigmac.getBurgers();
        String sauceTaste = bigmac.getSauce().getTaste();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(Bread.BUN_SESAME, bread);
        Assert.assertEquals(2, howManyBurgers);
        Assert.assertEquals(Sauce.BARBECUE, sauceTaste);
    }
}