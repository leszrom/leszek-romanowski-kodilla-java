package com.kodilla.good.patterns.challenges.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class FlightFinderServiceTestSuite {

    @Test
    public void should_return_combined_flights_hash_map() {
        //Given
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        FlightsBoard flightsBoard = flightsBoardCreator.createFlightsBoard();
        //When
        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";
        HashMap<Flight, Flight> combinedFlights = flightFinderService.getCombinedFlights(from, to);
        //Then
        Assert.assertEquals(4, combinedFlights.size());
    }
    @Test
    public void should_return_empty_combined_flights_hash_map() {
        //Given
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        FlightsBoard flightsBoard = new FlightsBoard(new HashSet<>());
        //When
        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";
        HashMap<Flight, Flight> combinedFlights = flightFinderService.getCombinedFlights(from, to);
        //Then
        Assert.assertEquals(0, combinedFlights.size());
    }

}