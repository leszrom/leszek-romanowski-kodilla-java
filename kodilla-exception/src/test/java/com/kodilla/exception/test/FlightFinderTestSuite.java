package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightFinderTestSuite {
    private static int testCounter = 0;

    @Before
    public void setUp() {
        System.out.println("Preparing to execute test #" + ++testCounter);
    }

    @Test
    public void should_return_true_case_both_airports_found() {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Modlin Airport", "Warsaw Chopin Airport");
        //When
        try {
            boolean found = flightFinder.findFlight(flight);
            //Then

            Assert.assertEquals(true, found);

        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void should_throw_exception_case_arrival_airport_not_exist() {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Modlin Airport", "Not Exist");
        //When
        try {
            boolean found = flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
            //Then
            Assert.assertEquals("Arrival airport not found", e.getMessage());
        }
    }
    @Test
    public void should_throw_exception_case_departure_airport_not_available() {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Poznan Lawica Airport", "Modlin Airport");
        //When
        try {
            boolean found = flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
            //Then
            Assert.assertEquals("Departure airport not found", e.getMessage());
        }
    }
    @Test
    public void should_throw_exception_case_both_airport_not_found() {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Not exist", "Poznan Lawica Airport");
        //When
        try {
            boolean found = flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
            //Then
            Assert.assertEquals("Departure and arrival airports not found", e.getMessage());
        }
    }
}
