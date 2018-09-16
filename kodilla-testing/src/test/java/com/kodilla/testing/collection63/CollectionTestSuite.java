package com.kodilla.testing.collection63;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suit: begin");
        System.out.println();
    }

    @Before
    public void before() {
        System.out.println("Test Case: begin");
        System.out.println(testName.getMethodName());
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
        System.out.println();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suit: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        //When
        oddNumbersExterminator.exterminateOdd(emptyList);
        //Then
        Assert.assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> integersList = new ArrayList<Integer>();
        ArrayList<Integer> evenIntegersList = new ArrayList<Integer>();

        int[] allNumbers = {-4, -3, -2, -1, 0, 1, 2, 3, 5, 7, 4};
        for (int number : allNumbers) integersList.add(number);

        int[] evenNumbers = {-4, -2, 0, 2, 4};
        for (int number : evenNumbers) evenIntegersList.add(number);
        //When
        oddNumbersExterminator.exterminateOdd(integersList);
        //Then
        Assert.assertEquals(evenIntegersList, integersList);
    }
}
