package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;
import java.util.HashSet;

public class ApplicationFlightsFinder {

    public static void main(String[] args) {
        FlightsBoardCreator flightsBoardCreator = new FlightsBoardCreator();
        FlightsBoard flightsBoard = flightsBoardCreator.createFlightsBoard();

        FlightFinderService flightFinderService = new FlightFinderService(flightsBoard);
        String from = "WAW";
        String to = "KRK";

        System.out.println("Flights from " + from + ":");
        HashSet<Flight> flightsFrom = flightFinderService.getFlightsFrom(from);
        flightFinderService.printDirectFlights(flightsFrom);

        System.out.println("Flights to " + to + ":");
        HashSet<Flight> flightsTo = flightFinderService.getFlightsTo(to);
        flightFinderService.printDirectFlights(flightsTo);

        System.out.println("Direct flights " + from + "-" + to + ":");
        HashSet<Flight> directFlightsFromTo = flightFinderService.getDirectFlights(from, to);
        flightFinderService.printDirectFlights(directFlightsFromTo);

        System.out.println("Combined flights " + from + "-" + to + ":");
        HashMap<Flight, Flight> combinedFlightsFromTo = flightFinderService.getCombinedFlights(from, to);
        flightFinderService.printCombinedFlights(combinedFlightsFromTo);
    }


}
