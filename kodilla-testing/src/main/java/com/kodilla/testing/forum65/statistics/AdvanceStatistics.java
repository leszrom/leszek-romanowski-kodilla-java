package com.kodilla.testing.forum65.statistics;

public class AdvanceStatistics {
    private int numberOfUsers = 0;
    private int numberOfPosts = 0;
    private int numberOfComments = 0;
    private double averagePostsPerUser = 0;
    private double averageCommentsPerUser = 0;
    private double averageCommentsPerPost = 0;

    public void calculateAdvanceStatistics(Statistics statistics) {
        numberOfUsers = statistics.userNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        if (numberOfUsers != 0 && numberOfPosts != 0 && numberOfComments != 0) {
            averagePostsPerUser = (double) numberOfPosts / numberOfUsers;
            averageCommentsPerUser = (double) numberOfComments / numberOfUsers;
            averageCommentsPerPost = (double) numberOfComments / numberOfPosts;
        } else if (numberOfUsers != 0 && numberOfPosts != 0) {
            averagePostsPerUser = (double) numberOfPosts / numberOfUsers;
        }
    }

    public void showAdvanceStatistics() {
        System.out.println("Total quantity of users: " + numberOfUsers);
        System.out.println("Total quantity of posts: " + numberOfPosts);
        System.out.println("Total quantity of comments: " + numberOfComments);
        System.out.println("Average quantity of posts per user: " + averagePostsPerUser);
        System.out.println("Average quantity of comments per user: " + averageCommentsPerUser);
        System.out.println("Average quantity of comments per post: " + averageCommentsPerPost);
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
