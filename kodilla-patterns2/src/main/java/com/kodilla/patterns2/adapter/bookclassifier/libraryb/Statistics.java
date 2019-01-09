package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Arrays;
import java.util.Map;

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
        if (books.size() == 0) {
            return 0;
        }
        int[] years = new int[books.size()];
        int n = 0;
        for (Map.Entry<BookSignature, BookB> entry : books.entrySet()) {
            years[n] = entry.getValue().getPublicationYear();
            n++;
        }
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int) (years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }
}
