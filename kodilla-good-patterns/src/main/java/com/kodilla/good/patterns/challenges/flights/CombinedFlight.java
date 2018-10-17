package com.kodilla.good.patterns.challenges.flights;

public class CombinedFlight {
    private Flight firstFlight;
    private Flight secondFlight;

    public CombinedFlight(final Flight firstFlight, final Flight secondFlight) {
        this.firstFlight = firstFlight;
        this.secondFlight = secondFlight;
    }

    public Flight getFirstFlight() {
        return firstFlight;
    }

    public Flight getSecondFlight() {
        return secondFlight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CombinedFlight)) return false;

        final CombinedFlight that = (CombinedFlight) o;

        if (!firstFlight.equals(that.firstFlight)) return false;
        return secondFlight.equals(that.secondFlight);
    }

    @Override
    public int hashCode() {
        int result = firstFlight.hashCode();
        result = 31 * result + secondFlight.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CombinedFlight{" +
                "firstFlight=" + firstFlight +
                ", secondFlight=" + secondFlight +
                '}';
    }
}
