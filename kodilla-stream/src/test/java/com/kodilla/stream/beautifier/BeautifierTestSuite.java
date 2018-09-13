package com.kodilla.stream.beautifier;

import org.junit.Assert;
import org.junit.Test;

public class BeautifierTestSuite {
    @Test
    public void should_return_text_with_ABC_added() {
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        //When
        String abcDecorated = poemBeautifier.beautify("john smith", textToDecorate -> "ABC-" + textToDecorate + "-ABC");
        //Then
        Assert.assertEquals("ABC-john smith-ABC", abcDecorated);
    }

    @Test
    public void should_return_text_with_uppercase_all_letters() {
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        //When
        String allUppercaseDecorated = poemBeautifier.beautify("john smith", String::toUpperCase);
        //Then
        Assert.assertEquals("JOHN SMITH", allUppercaseDecorated);
    }

    @Test
    public void should_return_text_with_uppercase_first_letters() {
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        //When
        String firstUpperCaseDecorated = poemBeautifier.beautify("john smith", textToDecorate -> textToDecorate.replace("j", "J").replace("s", "S"));
        //Then
        Assert.assertEquals("John Smith", firstUpperCaseDecorated);
    }

    @Test
    public void should_return_text_shortened_and_uppercase() {
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        //When
        String shortenedAndUppercaseDecorated = poemBeautifier.beautify("john smith", textToDecorate -> textToDecorate.substring(0, 4)
                .toUpperCase());
        //Then
        Assert.assertEquals("JOHN", shortenedAndUppercaseDecorated);
    }
}
