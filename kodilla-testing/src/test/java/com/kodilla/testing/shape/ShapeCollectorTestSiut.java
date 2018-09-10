package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSiut {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(new Triangle(6.2, 3));
        //Then
        Assert.assertEquals(1, shapeCollector.getFigureQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape theFigure = new Triangle(6.2, 3);
        shapeCollector.addFigure(theFigure);
        //When
        Shape retrievedFigure = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(theFigure, retrievedFigure);
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape figureToRemove = shapeCollector.getFigure(0);
        //When
        boolean result = shapeCollector.removeFigure(figureToRemove);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape theFigure = new Triangle(6.2, 3);
        shapeCollector.addFigure(theFigure);
        Shape figureToRemove = shapeCollector.getFigure(0);
        //When
        boolean result = shapeCollector.removeFigure(figureToRemove);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFigureQuantity());
    }
}
