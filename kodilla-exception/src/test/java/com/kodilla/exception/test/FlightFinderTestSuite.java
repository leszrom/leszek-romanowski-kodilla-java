package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.CatchException.verifyException;


public class FlightFinderTestSuite {
    private static int testCounter = 0;

    @Before
    public void setUp() {
        System.out.println("Preparing to execute test #" + ++testCounter);
    }

    @Test
    public void should_return_true_case_both_airports_found() throws Exception {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Modlin Airport", "Warsaw Chopin Airport");
        //When
        boolean found = flightFinder.findFlight(flight);
        //Then
        Assert.assertTrue(found);
    }

    @Test
    public void should_throw_exception_case_arrival_airport_not_exist() throws Exception {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Modlin Airport", "Not Exist");
        //When
        verifyException(flightFinder).findFlight(flight);
        //Then
        assert caughtException() instanceof RouteNotFoundException;
        Assert.assertEquals("Arrival airport not found", caughtException().getMessage());
    }

    @Test
    public void should_throw_exception_case_departure_airport_not_available() throws Exception {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Poznan Lawica Airport", "Modlin Airport");
        //When
        verifyException(flightFinder).findFlight(flight);
        //Then
        assert caughtException() instanceof RouteNotFoundException;
        Assert.assertEquals("Departure airport not found", caughtException().getMessage());
    }

    @Test
    public void should_throw_exception_case_both_airport_not_found() throws Exception {
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("Not exist", "Poznan Lawica Airport");
        //When
        verifyException(flightFinder).findFlight(flight);
        //Then
        assert caughtException() instanceof RouteNotFoundException;
        Assert.assertEquals("Departure and arrival airports not found", caughtException().getMessage());
    }
}
