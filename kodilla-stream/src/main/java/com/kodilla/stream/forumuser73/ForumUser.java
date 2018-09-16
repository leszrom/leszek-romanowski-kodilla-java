package com.kodilla.stream.forumuser73;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    ForumUser(final int userID, final String username, final char sex, final int year, final int month, final int dayOfMonth, final int numberOfPosts) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, dayOfMonth);
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
