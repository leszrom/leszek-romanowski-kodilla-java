package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieStoreTestSuite {

    @Test
    public void should_return_all_titles_separated_by_an_exclamation_mark() {
        //Given
        MovieStore movieStore = new MovieStore();
        String expectedResult = "[Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash]"
        //When
        String result = movieStore.printTitles();
        //Then
        Assert.assertEquals(expectedResult,result);

    }

}