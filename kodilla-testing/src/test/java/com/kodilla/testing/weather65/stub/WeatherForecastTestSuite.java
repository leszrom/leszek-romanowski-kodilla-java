package com.kodilla.testing.weather65.stub;

import org.junit.Assert;
import org.junit.Test;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStube();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
