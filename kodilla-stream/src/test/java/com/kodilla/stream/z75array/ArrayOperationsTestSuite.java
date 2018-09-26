package com.kodilla.stream.z75array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    private static int testCounter = 0;

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void should_return_average_value_from_array_with_numbers() {
        //Given
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        //When
        double averageValue = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(10.5, averageValue, 0.1);
    }

    @Test
    public void should_return_zero_if_array_contain_only_zeros() {
        //Given
        int[] numbers = {0, 0, 0};
        //When
        double average_Value = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(0, average_Value, 0.1);

    }

    @Test
    public void should_return_0_if_array_is_empty() {
        //Given
        int[] numbers = {};
        //When
        double average_Value = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(0, average_Value, 0.1);
    }
}
