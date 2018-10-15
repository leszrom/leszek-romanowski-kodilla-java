package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;

public class FlightsBoard {
    private HashSet<Flight> flights;

    public FlightsBoard(final HashSet<Flight> flights) {
        this.flights = flights;
    }

    public HashSet<Flight> getFlights() {
        return flights;
    }
}
