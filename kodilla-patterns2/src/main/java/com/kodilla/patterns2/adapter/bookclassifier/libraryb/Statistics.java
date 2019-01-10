package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, BookB> books) {
        return (int) books.entrySet().stream()
                .map(entrySet -> entrySet.getValue().getPublicationYear())
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookB> books) {
        List<Integer> sortedYears = books.entrySet().stream()
                .map(entrySet -> entrySet.getValue().getPublicationYear())
                .sorted()
                .collect(Collectors.toList());

        return sortedYears.stream()
                .skip(sortedYears.size() / 2)
                .findFirst()
                .orElse(0);
    }
}
