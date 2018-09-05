package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenia do testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("Simple User");
        String result = simpleUser.getUserName();

        if (result.equals("Simple User"))
            System.out.println("test OK");
        else
            System.out.println("test FAILED");

        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator();
        int firstNumber = 125;
        int secondNumber = 25;

        int addResult = calculator.add(firstNumber, secondNumber);
        int subtractResult = calculator.subtract(firstNumber, secondNumber);

        System.out.print("add() test - ");
        if (addResult == firstNumber + secondNumber)
            System.out.println("OK");
        else
            System.out.println("FAILED");

        System.out.print("subtract() test - ");
        if (subtractResult == firstNumber - secondNumber)
            System.out.println("OK");
        else
            System.out.println("FAILED");
    }
}
