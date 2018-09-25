package com.kodilla.stream.m75book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookDirectoryTestSuite {
    @Test
    public void should_return_number_of_books_after_2007_using_for_each_loop() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        int numberOfBooksPublicatedAfter2007 = 0;
        for (Book book : books)
            if (book.getYearOfPublication() > 2007)
                numberOfBooksPublicatedAfter2007++;
        //Then
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void should_return_number_of_books_after_2007_using_Int_Stream_sum() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        //Then
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void should_return_number_of_books_after_2007_using_Int_Stream_count() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        //Then
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}