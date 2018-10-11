package com.kodilla.spring.intro.shape;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawerTestSuite {

    @Test
    public void testDoDrawingWithCircle() {
        //Given
        Drawer drawer = new Drawer(new Circle());
        //When
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a circle", result);
    }
    @Test
    public void testDoDrawingWithTriangle() {
        //Given
        Drawer drawer = new Drawer(new Triangle());
        //When
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a triangle", result);
    }

}