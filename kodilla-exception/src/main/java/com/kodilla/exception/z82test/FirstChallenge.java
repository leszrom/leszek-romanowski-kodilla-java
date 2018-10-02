package com.kodilla.exception.z82test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0;

        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException aEx) {
            System.out.println("Something went wrong. Error: " + aEx);
        } finally {
            System.out.println("Result: " + result);
        }
    }
}