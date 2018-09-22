package com.kodilla.stream.z74world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final String nameOfContinent;
    private final Set<Country> setOfCountries = new HashSet<>();

    public Continent(final String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }

    public String getNameOfContinent() {
        return nameOfContinent;
    }

    public Set<Country> getCountries() {
        return setOfCountries;
    }

    public void addCountry(Country country) {
        setOfCountries.add(country);
    }

    public boolean removeCountry(Country country) {
        return setOfCountries.remove(country);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;

        final Continent continent = (Continent) o;

        if (!nameOfContinent.equals(continent.nameOfContinent)) return false;
        return setOfCountries.equals(continent.setOfCountries);
    }

    @Override
    public int hashCode() {
        int result = nameOfContinent.hashCode();
        result = 31 * result + setOfCountries.hashCode();
        return result;
    }
}
