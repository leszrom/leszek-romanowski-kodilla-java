package com.kodilla.patterns.strategy.social;

public class User {
    private final String name;
    protected SocialPublisher socialPublisher;

    public User(final String name) {
        this.name = name;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setPreferredPublisher(SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }
}
