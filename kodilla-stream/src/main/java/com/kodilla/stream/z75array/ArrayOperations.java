package com.kodilla.stream.z75array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                //.forEach(System.out::println);
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