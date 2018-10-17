package com.kodilla.spring.calculator;

import com.googlecode.catchexception.CatchException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

    @Test
    public void should_return_correct_results_of_each_operation() throws Exception {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double a = 3.5;
        double b = 7.0;
        double addResult = calculator.add(a, b);
        double subResult = calculator.sub(a, b);
        double mulResult = calculator.mul(a, b);
        double divResult = calculator.div(a, b);
        //Then
        Assert.assertEquals(10.5, addResult, 0.1);
        Assert.assertEquals(-3.5, subResult, 0.1);
        Assert.assertEquals(24.5, mulResult, 0.1);
        Assert.assertEquals(0.5, divResult, 0.1);
    }

    @Test
    public void should_throw_exception_when_divide_by_zero() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        try {
            calculator.div(3, 0);
        } catch (Exception e) {
            //Then
            assert e instanceof DivideByZeroException;
            Assert.assertEquals("Divide by zero not allowed!", e.getMessage());
        }
    }

    @Test
    public void should_throw_exception_when_divide_by_zero_google_code() throws Exception {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        CatchException.verifyException(calculator).div(3, 0);
        //Then
        assert CatchException.caughtException() instanceof DivideByZeroException;
    }
}