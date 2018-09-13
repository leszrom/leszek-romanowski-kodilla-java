package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void should_return_list_of_books_which_title_contain_given_fragment() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void should_return_empty_list_of_books_if_result_list_is_more_than_20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void should_return_empty_list_of_books_if_given_fragment_is_shorter_than_3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks10 = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOfBooks10);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, never()).listBooksWithCondition(anyString());
    }

    @Test
    public void should_return_empty_list_if_the_user_has_no_books_from_library() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUserHasNoBooksMock = mock(LibraryUser.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooksEmpty = new ArrayList<Book>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserHasNoBooksMock)).thenReturn(resultListOfBooksEmpty);

        //Whet
        List<Book> theListOfBooksEmpty = bookLibrary.listBooksInHandsOf(libraryUserHasNoBooksMock);
        //Then
        Assert.assertEquals(0,theListOfBooksEmpty.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUserHasNoBooksMock);
    }

    @Test
    public void should_return_list_with_1_book_if_the_user_has_one_book_from_library() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUserHasOneBookMock = mock(LibraryUser.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks1 = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserHasOneBookMock)).thenReturn(resultListOfBooks1);

        //Whet
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUserHasOneBookMock);
        //Then
        Assert.assertEquals(1,theListOfBooks1.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUserHasOneBookMock);
    }

    @Test
    public void should_return_list_with_5_books_if_the_user_has_five_books_from_library() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUserHasFiveBooksMock = mock(LibraryUser.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks5 = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserHasFiveBooksMock)).thenReturn(resultListOfBooks5);

        //Whet
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUserHasFiveBooksMock);
        //Then
        Assert.assertEquals(5,theListOfBooks5.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUserHasFiveBooksMock);
    }
}