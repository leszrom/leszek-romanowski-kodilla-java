package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void should_return_publication_year_median_when_number_of_books_is_odd() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        Set<BookA> books = new HashSet<>();
        books.add(new BookA("author_1", "title_1", 1998, "sign_1"));
        books.add(new BookA("author_2", "title_2", 1999, "sign_2"));
        books.add(new BookA("author_3", "title_3", 1995, "sign_3"));
        books.add(new BookA("author_4", "title_4", 2000, "sign_4"));
        books.add(new BookA("author_5", "title_5", 2000, "sign_5"));

        //When
        int median = medianAdapter.publicationYearMedian(books);

        //Then
        Assert.assertEquals(1999, median);

    }

    @Test
    public void should_return_publication_year_median_when_number_of_books_is_even() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        Set<BookA> books = new HashSet<>();
        books.add(new BookA("author_2", "title_2", 1999, "sign_2"));
        books.add(new BookA("author_3", "title_3", 1995, "sign_3"));
        books.add(new BookA("author_4", "title_4", 2000, "sign_4"));
        books.add(new BookA("author_5", "title_5", 2000, "sign_5"));

        //When
        int median = medianAdapter.publicationYearMedian(books);

        //Then
        Assert.assertEquals(2000, median);
    }

}