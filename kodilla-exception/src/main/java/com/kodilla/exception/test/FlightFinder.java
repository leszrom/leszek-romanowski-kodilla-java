package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flights = getAirportsMap();

        List<String> departure = flights.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .filter(airport -> airport == flight.getDepartureAirport())
                .collect(Collectors.toList());

        List<String> arrival = flights.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .filter(airport -> airport == flight.getArrivalAirport())
                .collect(Collectors.toList());

        if (departure.size() == 0 && arrival.size() == 0) {
            throw new RouteNotFoundException("Departure and arrival airports not found");
        } else if (departure.size() == 0) {
            throw new RouteNotFoundException("Departure airport not found");
        } else if (arrival.size() == 0) {
            throw new RouteNotFoundException("Arrival airport not found");
        }

        System.out.println(flight);
        return true;
    }

    public Map<String, Boolean> getAirportsMap() {
        Map<String, Boolean> airportsMap = new HashMap<>();

        airportsMap.put("Modlin Airport", true);
        airportsMap.put("Warsaw Chopin Airport", true);
        airportsMap.put("Poznan Lawica Airport", false);
        airportsMap.put("Cracow Balice Airport", true);

        return airportsMap;
    }
}
