package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Test;

public class FirstChallengeTestSuite {

    @Test
    public void should_throw_arithmeticException() {
        //Given
        FirstChallenge firstChallenge = new FirstChallenge();
        ArithmeticException expectedException = new ArithmeticException();
        try {
            //When
            firstChallenge.divide(3, 0);

        } catch (Exception e) {
            //Then
            Assert.assertEquals(expectedException.getClass(), e.getClass());
        }
    }

}
