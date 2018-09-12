package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvanceStatisticsTestSuite {

    private Statistics statisticsMock = mock(Statistics.class);
    private AdvanceStatistics advanceStatistics = new AdvanceStatistics();

    @Test
    public void testCalculateAdvanceStatistics() {
        //Given
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersList.add("User_" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(350);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        //When
        advanceStatistics.calculateAdvanceStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, advanceStatistics.getNumberOfUsers());
        Assert.assertEquals(350, advanceStatistics.getNumberOfPosts());
        Assert.assertEquals(1000, advanceStatistics.getNumberOfComments());
        Assert.assertEquals(3.5, advanceStatistics.getAveragePostsPerUser(), 0.01);
        Assert.assertEquals(10, advanceStatistics.getAverageCommentsPerUser(), 0.01);
        Assert.assertEquals(2.86, advanceStatistics.getAverageCommentsPerPost(), 0.01);
    }

    @Test
    public void testStatisticsWithoutUsers() {
        //Given
        List<String> usersList = new ArrayList<>();

        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        advanceStatistics.calculateAdvanceStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, advanceStatistics.getAveragePostsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerPost(), 0.01);
    }
    @Test
    public void testStatisticsWithoutPosts() {
        //Given
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersList.add("User_" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        advanceStatistics.calculateAdvanceStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, advanceStatistics.getAveragePostsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerPost(), 0.01);
    }
    @Test
    public void testStatisticsWithoutComments() {
        //Given
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersList.add("User_" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1250);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        advanceStatistics.calculateAdvanceStatistics(statisticsMock);
        //Then
        Assert.assertEquals(12.5, advanceStatistics.getAveragePostsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerUser(), 0.01);
        Assert.assertEquals(0, advanceStatistics.getAverageCommentsPerPost(), 0.01);
    }
    @Test
    public void testStatisticsLessCommentsThenPostsAndLessPostsThenUsers() {
        //Given
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            usersList.add("User_" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(650);
        when(statisticsMock.commentsCount()).thenReturn(60);
        //When
        advanceStatistics.calculateAdvanceStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0.65, advanceStatistics.getAveragePostsPerUser(), 0.001);
        Assert.assertEquals(0.06, advanceStatistics.getAverageCommentsPerUser(), 0.001);
        Assert.assertEquals(0.092, advanceStatistics.getAverageCommentsPerPost(), 0.001);
    }



}
