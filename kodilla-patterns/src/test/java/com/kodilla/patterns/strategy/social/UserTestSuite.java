package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User john = new Millenials("John Smith");
        User emma = new YGeneration("Emma Wind");
        User rob = new ZGeneration("Rob Blue");
        //When
        String johnPublisher = john.sharePost();
        String emmaPublisher = emma.sharePost();
        String robPublisher = rob.sharePost();
        System.out.println("John prefer sharing by: " + johnPublisher);
        System.out.println("Emma prefer sharing by: " + emmaPublisher);
        System.out.println("Rob prefer sharing by: " + robPublisher);
        //Then
        Assert.assertEquals("Facebook", johnPublisher);
        Assert.assertEquals("Twitter", emmaPublisher);
        Assert.assertEquals("Snapchat", robPublisher);
    }

    @Test
    public void testIndividualSharingStrategies() {
        //Given
        User john = new Millenials("John Smith");
        String johnPublisher = john.sharePost();
        System.out.println("John prefer sharing by: " + johnPublisher);
        //When
        john.setPreferredPublisher(new SnapchatPublisher());
        johnPublisher = john.sharePost();
        System.out.println("Now John prefer sharing by: " + johnPublisher);
        //Then
        Assert.assertEquals("Snapchat", johnPublisher);
    }
}