package com.kodilla.stream.z74world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {
    private final Set<Continent> setOfContinents = new HashSet<>();

    public BigDecimal getPeopleQuantity() {
        return setOfContinents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getNumberOfPeople)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public Set<Continent> getSetOfContinents() {
        return setOfContinents;
    }

    public void addContinent(Continent continent) {
        setOfContinents.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return setOfContinents.remove(continent);
    }

}

