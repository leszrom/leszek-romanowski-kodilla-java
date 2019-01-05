package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {
    @Test
    public void should_return_cost_of_basic_taxi_order() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        BigDecimal calculatedCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void should_return_description_of_basic_taxi_cost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course", description);
    }

    @Test
    public void should_return_cost_of_taxi_order_from_Taxi_Network() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void should_return_description_of_taxi_order_from_Taxi_Network() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void should_return_cost_of_taxi_order_from_Uber_Network() {
        //Given
        TaxiOrder theOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    public void should_return_description_of_taxi_order_from_Uber_Network() {
        //Given
        TaxiOrder theOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by Uber Network", description);
    }

    @Test
    public void should_return_cost_of_taxi_order_from_MyTaxi_Network() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void should_return_description_of_taxi_order_from_MyTaxi_Network() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }
}
