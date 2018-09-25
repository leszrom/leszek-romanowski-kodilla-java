package com.kodilla.stream.z75array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void should_return_average_value_from_array() {
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
}
