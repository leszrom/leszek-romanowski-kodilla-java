package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;

public class FlightsBoardCreator {

    public FlightsBoard createFlightsBoard(){
        return new FlightsBoard(getFlights());
    }
    private HashSet<Flight> getFlights() {
        HashSet<Flight> flights = new HashSet<>();
        flights.add(new Flight("1A","WAW","KRK"));
        flights.add(new Flight("1B","WAW","KRK"));
        flights.add(new Flight("1C","WAW","KTW"));
        flights.add(new Flight("1D","WAW","KTW"));
        flights.add(new Flight("2A","WAW","GDN"));
        flights.add(new Flight("2B","WAW","GDN"));
        flights.add(new Flight("2C","KRK","WAW"));
        flights.add(new Flight("2D","KRK","GDN"));
        flights.add(new Flight("3A","GDN","WAW"));
        flights.add(new Flight("3B","GDN","KTW"));
        flights.add(new Flight("3C","GDN","KRK"));
        flights.add(new Flight("3D","KTW","KRK"));
        flights.add(new Flight("3E","KTW","GDN"));
        return flights;
    }
}
