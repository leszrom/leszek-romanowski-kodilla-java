package com.kodilla.patterns.factory.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void should_create_circle_using_shape_factory() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        Assert.assertEquals(Math.PI * Math.pow(4.5, 2), circle.getArea(), 0.01);
        Assert.assertEquals("The rounded circle", circle.getName());
    }

    @Test
    public void should_create_square_using_shape_factory() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        Assert.assertEquals(28, square.getCircumference(), 0.01);
        Assert.assertEquals("The angular square", square.getName());
    }

    @Test
    public void should_create_rectangle_using_shape_factory() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        Assert.assertEquals(37.5, rectangle.getArea(), 0.01);
        Assert.assertEquals("The long rectangle", rectangle.getName());
    }
}