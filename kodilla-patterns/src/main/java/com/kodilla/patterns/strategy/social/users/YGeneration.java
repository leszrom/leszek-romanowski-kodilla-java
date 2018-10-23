package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.User;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public class YGeneration extends User {
    public YGeneration(final String name) {
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}
