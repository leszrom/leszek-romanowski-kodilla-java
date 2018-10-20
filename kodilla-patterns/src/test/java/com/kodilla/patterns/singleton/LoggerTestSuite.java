package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTestSuite {

    @Test
    public void should_return_last_log() {
        //Given
        Logger.getInstance().log("First log");
        Logger.getInstance().log("Second log");
        Logger.getInstance().log("Last log");
        //When
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Last log",lastLog);
    }
}