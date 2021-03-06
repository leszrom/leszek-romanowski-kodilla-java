package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;
import java.util.stream.Collectors;

public class FlightFinderService {
    private FlightsBoard flightsBoard;

    public FlightFinderService(final FlightsBoard flightsBoard) {
        this.flightsBoard = flightsBoard;
    }

    public HashSet<CombinedFlight> getCombinedFlights(String departureAirport, String arrivalAirport) {
        HashSet<CombinedFlight> combinedFlights = new HashSet<>();

        HashSet<Flight> flightsFrom = getFlightsFrom(departureAirport);
        if (flightsFrom.isEmpty()) return combinedFlights;

        HashSet<Flight> flightsTo = getFlightsTo(arrivalAirport);
        if (flightsTo.isEmpty()) return combinedFlights;


        for (Flight flightFrom : flightsFrom) {
            for (Flight flightTo : flightsTo) {
                if (flightFrom.getArrivalAirport().equals(flightTo.getDepartureAirport())) {
                    combinedFlights.add(new CombinedFlight(flightFrom, flightTo));
                }
            }
        }
        if (combinedFlights.isEmpty()) System.out.println("No matching flights found.");
        return combinedFlights;
    }

    public HashSet<Flight> getDirectFlights(String departureAirport, String arrivalAirport) {
        HashSet<Flight> directFlights = (HashSet<Flight>) flightsBoard.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
        if (directFlights.isEmpty()) System.out.println("No matching flights found.");
        return directFlights;
    }

    public HashSet<Flight> getFlightsTo(String arrivalAirport) {
        HashSet<Flight> flights = (HashSet<Flight>) flightsBoard.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
        if (flights.isEmpty()) System.out.println("No matching flights found.");
        return flights;
    }

    public HashSet<Flight> getFlightsFrom(String departureAirport) {
        HashSet<Flight> flights = (HashSet<Flight>) flightsBoard.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
        if (flights.isEmpty()) System.out.println("No matching flights found.");
        return flights;
    }

    public void printDirectFlights(HashSet<Flight> flights) {
        flights.forEach(System.out::println);
        System.out.println();
    }

    public void printCombinedFlights(HashSet<CombinedFlight> combinedFlights) {
        combinedFlights.forEach(System.out::println);
        System.out.println();
    }
}
