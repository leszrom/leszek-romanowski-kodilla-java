package com.kodilla.stream.z74world;

import java.math.BigDecimal;

public final class Country {
    private final String nameOfCountry;
    private final BigDecimal numberOfPeople;

    public Country(final String nameOfCountry, final BigDecimal numberOfPeople) {
        this.nameOfCountry = nameOfCountry;
        this.numberOfPeople = numberOfPeople;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public BigDecimal getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        final Country country = (Country) o;

        if (!nameOfCountry.equals(country.nameOfCountry)) return false;
        return numberOfPeople.equals(country.numberOfPeople);
    }

    @Override
    public int hashCode() {
        int result = nameOfCountry.hashCode();
        result = 31 * result + numberOfPeople.hashCode();
        return result;
    }
}
