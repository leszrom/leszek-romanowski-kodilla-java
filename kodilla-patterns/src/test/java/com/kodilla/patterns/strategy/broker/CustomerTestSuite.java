package com.kodilla.patterns.strategy.broker;

import com.kodilla.patterns.strategy.broker.customers.CorporateCustomer;
import com.kodilla.patterns.strategy.broker.customers.IndividualCustomer;
import com.kodilla.patterns.strategy.broker.customers.IndividualYoungCustomer;
import com.kodilla.patterns.strategy.broker.predictors.AggressivePredictor;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Smith");
        Customer kodilla = new CorporateCustomer("Kodilla");
        //When
        String stevenShouldBuy = steven.predict();
        String johnShouldBuy = john.predict();
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        System.out.println("John should: " + johnShouldBuy);
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //Then
        Assert.assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        Assert.assertEquals("[Aggressive predictor] buy stock of XYZ", johnShouldBuy);
        Assert.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    public void testIndividualInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        //When
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);
        //Then
        Assert.assertEquals("[Aggressive predictor] buy stock of XYZ", stevenShouldBuy);
    }
}