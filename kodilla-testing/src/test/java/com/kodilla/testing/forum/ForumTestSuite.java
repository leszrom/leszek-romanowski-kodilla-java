package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;

public class ForumTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suit: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suit: end");
    }

    @Test
    public void testCaseUserName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("User Name", "Real Name");
        //When
        String result = simpleUser.getUserName();
        //Then
        Assert.assertEquals("User Name", result);
    }

    @Test
    public void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("User Name", "Real Name");
        //When
        String result = simpleUser.getRealName();
        //Then
        Assert.assertEquals("Real Name", result);
    }
}
