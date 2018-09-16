package com.kodilla.testing.library66;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookListEmpty = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookListEmpty;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookListEmpty;
        return resultList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
