package com.kodilla.exception.z82test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        double x = 1.5;
        double y = 4;

        try {
            secondChallenge.probablyIWillThrowException(x, y);
            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Variable is out of domain of a function!");
            System.out.println("Domain: x ∈ (2,1> ∧ x ≠ 1.5");
        }
    }
}
