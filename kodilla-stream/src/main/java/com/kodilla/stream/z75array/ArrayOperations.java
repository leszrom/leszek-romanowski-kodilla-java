package com.kodilla.stream.z75array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        if (numbers.length == 0) return 0;

        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(n -> System.out.print(n + ", "));
        double average = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .getAsDouble();
        System.out.println();
        System.out.println("Average: " + average);
        return average;
    }

}