package com.kodilla.stream.forumuser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumTestSuite {
    private static int testCounter = 0;

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing test #" + testCounter);
    }

    @Test
    public void should_return_only_male_forum_users() {
        //Given
        ForumDatabase forumDatabaseMock = mock(ForumDatabase.class);

        List<ForumUser> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new ForumUser(1, "Username1", 'M', 1986, 9, 24, 2));
        mockListOfUsers.add(new ForumUser(2, "Username2", 'F', 1989, 5, 13, 2));
        mockListOfUsers.add(new ForumUser(3, "Username3", 'M', 1994, 7, 3, 2));

        when(forumDatabaseMock.getUsers()).thenReturn(mockListOfUsers);

        //When
        Forum forum = new Forum(forumDatabaseMock);
        List<ForumUser> theResultList = ForumFilter.getMaleForumUsers(forum.getTheForumUserList());

        //Then
        Assert.assertEquals(2, theResultList.size());
        Assert.assertEquals(1, theResultList.get(0).getUserID());
        Assert.assertEquals(3, theResultList.get(1).getUserID());
    }

    @Test
    public void should_return_only_users_at_least_20_years_old() {
        //Given
        ForumDatabase forumDatabaseMock = mock(ForumDatabase.class);

        List<ForumUser> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new ForumUser(1, "Username1", 'M', 1998, 9, 15, 2));
        mockListOfUsers.add(new ForumUser(2, "Username2", 'F', 1998, 9, 16, 2));
        mockListOfUsers.add(new ForumUser(3, "Username3", 'F', 2000, 2, 10, 2));

        when(forumDatabaseMock.getUsers()).thenReturn(mockListOfUsers);

        //When
        Forum forum = new Forum(forumDatabaseMock);
        List<ForumUser> theResultList = ForumFilter.getForumUsersAtLeast20YearsOld(forum.getTheForumUserList());

        //Then
        Assert.assertEquals(2, theResultList.size());
        Assert.assertEquals(1, theResultList.get(0).getUserID());
        Assert.assertEquals(2, theResultList.get(1).getUserID());
    }

    @Test
    public void should_return_users_with_at_least_1_post() {
        //Given
        ForumDatabase forumDatabaseMock = mock(ForumDatabase.class);

        List<ForumUser> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new ForumUser(1, "Username1", 'M', 1998, 9, 15, 15));
        mockListOfUsers.add(new ForumUser(2, "Username2", 'F', 1998, 9, 16, 0));
        mockListOfUsers.add(new ForumUser(3, "Username3", 'F', 2000, 2, 10, 1));

        when(forumDatabaseMock.getUsers()).thenReturn(mockListOfUsers);

        //When
        Forum forum = new Forum(forumDatabaseMock);
        List<ForumUser> theResultList = ForumFilter.getForumUsersWithAtLeast1Post(forum.getTheForumUserList());

        //Then
        Assert.assertEquals(2, theResultList.size());
        Assert.assertEquals(15, theResultList.get(0).getNumberOfPosts());
        Assert.assertEquals(1, theResultList.get(1).getNumberOfPosts());
    }

    @Test
    public void should_return_map_of_users() {
        //Given
        ForumDatabase forumDatabaseMock = mock(ForumDatabase.class);

        List<ForumUser> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new ForumUser(1, "Username1", 'M', 1998, 9, 15, 15));
        mockListOfUsers.add(new ForumUser(2, "Username2", 'F', 1998, 9, 16, 0));
        mockListOfUsers.add(new ForumUser(3, "Username3", 'F', 2000, 2, 10, 1));

        when(forumDatabaseMock.getUsers()).thenReturn(mockListOfUsers);

        //When
        Forum forum = new Forum(forumDatabaseMock);
        Map<Integer, ForumUser> theResultMap = ForumFilter.getMapOfForumUsers(forum.getTheForumUserList());

        //Then
        Assert.assertEquals(3, theResultMap.size());
    }

}
