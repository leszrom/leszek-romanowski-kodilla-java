package com.kodilla.exception.z82test;

public class SecondChallenge {
    public String probablyIWillThrowException(double x, double y) throws Exception {
        if (x >= 2 || x < 1 || x == 1.5) {
            throw new Exception();
        }
        return "Done!";
    }
}
