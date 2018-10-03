package com.kodilla.exception.index;

import org.junit.Test;

import java.util.List;

public class VideoCollectorTestSuite {
    @Test
    public void should_return_() {
        //Given
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();
        //When
        if (collection.size() > 2) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(2);
            System.out.println(anotherMovie);
        }
        //Then

    }
}
