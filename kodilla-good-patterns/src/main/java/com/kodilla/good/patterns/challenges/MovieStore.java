package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStore {
    public Map<String, List<String>> getMovies() {
        List<String> ironManTranstaltion = new ArrayList<>();
        ironManTranstaltion.add("Żelazny Człowiek");
        ironManTranstaltion.add("Iron Man");

        List<String> avengersTranslation = new ArrayList<>();
        avengersTranslation.add("Mściciele");
        avengersTranslation.add("Avengers");

        List<String> flahTranslation = new ArrayList<>();
        flahTranslation.add("Błyskawica");
        flahTranslation.add("Flash");

        Map<String, List<String>> bookTitleWithTranslation = new HashMap<>();
        bookTitleWithTranslation.put("IM", ironManTranstaltion);
        bookTitleWithTranslation.put("AV", avengersTranslation);
        bookTitleWithTranslation.put("FL", flahTranslation);

        return bookTitleWithTranslation;
    }

    public String printTitles() {
        return getMovies().entrySet().stream()
                .flatMap(stringListEntry -> stringListEntry.getValue().stream())
                .collect(Collectors.joining("!","[","]"));
    }
}
