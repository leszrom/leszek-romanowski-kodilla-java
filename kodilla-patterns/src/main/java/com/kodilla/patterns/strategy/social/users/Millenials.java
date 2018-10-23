package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.User;
import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class Millenials extends User {
    public Millenials(final String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
