package com.kodilla.stream.z74world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void should_return_number_of_people_all_over_the_world() {
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);
        europe.addCountry(new Country("Poland", new BigDecimal("100")));
        europe.addCountry(new Country("France", new BigDecimal("100")));
        europe.addCountry(new Country("Spain", new BigDecimal("100")));
        africa.addCountry(new Country("Kenya", new BigDecimal("100")));
        africa.addCountry(new Country("Egypt", new BigDecimal("100")));
        africa.addCountry(new Country("RSA", new BigDecimal("100")));
        asia.addCountry(new Country("Turkey", new BigDecimal("100")));
        asia.addCountry(new Country("India", new BigDecimal("100")));
        asia.addCountry(new Country("China", new BigDecimal("100")));
        //When
        BigDecimal peopleAllOverTheWorld = world.getPeopleQuantity();
        //Then
        Assert.assertEquals(new BigDecimal("900"), peopleAllOverTheWorld);
    }

}
