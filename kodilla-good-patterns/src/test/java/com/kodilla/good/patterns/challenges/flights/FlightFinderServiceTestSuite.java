package com.kodilla.good.patterns.challenges.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class FlightFinderServiceTestSuite {

    @Test
    public void should_return_exactly_one_combined_flight_between_WAW_and_KRK_through_KTW() {
        //Given
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        HashSet<Flight> flights = new HashSet<>();
        flights.add(new Flight("1", "WAW", "KTW"));
        flights.add(new Flight("2", "KTW", "KRK"));
        flights.add(new Flight("3", "WRW", "KRK"));

        FlightsBoard flightsBoard = new FlightsBoard(flights);
        //When
        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";
        HashSet<CombinedFlight> combinedFlights = flightFinderService.getCombinedFlights(from, to);

        Flight firstFlight = new Flight("1","WAW","KTW");
        Flight secondFlight = new Flight("2","KTW","KRK");
        CombinedFlight combinedFlight = new CombinedFlight(firstFlight, secondFlight);
        //Then
        Assert.assertEquals(1, combinedFlights.size());
        Assert.assertTrue(combinedFlights.contains(combinedFlight));
    }
    @Test
    public void should_return_four_combined_flights() {
        //Given
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        FlightsBoard flightsBoard = flightsBoardCreator.createFlightsBoard();
        //When
        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";
        HashSet<CombinedFlight> combinedFlights = flightFinderService.getCombinedFlights(from, to);
        //Then
        Assert.assertEquals(4, combinedFlights.size());

    }
    @Test
    public void should_return_zero_combined_flights() {
        //Given
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        FlightsBoard flightsBoard = new FlightsBoard(new HashSet<>());
        //When
        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";
        HashSet<CombinedFlight> combinedFlights = flightFinderService.getCombinedFlights(from, to);
        //Then
        Assert.assertEquals(0, combinedFlights.size());
    }
}