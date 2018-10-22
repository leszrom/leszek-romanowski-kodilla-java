package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void should_return_shallow_and_deep_copy_of_library() {
        //Given
        Library library = new Library("Library");

        library.getBooks().add(new Book("Title_1", "Author_1", LocalDate.parse("2016-08-16")));
        library.getBooks().add(new Book("Title_2", "Author_2", LocalDate.parse("2015-07-11")));
        library.getBooks().add(new Book("Title_3", "Author_3", LocalDate.parse("2014-01-28")));

        // shallowCopy
        Library libraryShallowCopy = null;
        try {
            libraryShallowCopy = library.shallowCopy();
            libraryShallowCopy.setName("Library - shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // deepCopy
        Library libraryDeepCopy = null;
        try {
            libraryDeepCopy = library.deepCopy();
            libraryDeepCopy.setName("Library - deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library.getBooks().remove(new Book("Title_1", "Author_1", LocalDate.parse("2016-08-16")));
        //Then
        System.out.println(library);
        System.out.println(libraryShallowCopy);
        System.out.println(libraryDeepCopy);

        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, libraryShallowCopy.getBooks().size());
        Assert.assertEquals(3, libraryDeepCopy.getBooks().size());
        Assert.assertEquals(libraryShallowCopy.getBooks(), library.getBooks());
        Assert.assertNotEquals(libraryDeepCopy.getBooks(), library.getBooks());
    }
}