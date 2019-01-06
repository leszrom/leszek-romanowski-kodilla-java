package com.kodilla.patterns2.aop.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divided by zero!");
        }
        return x / y;
    }
}
