package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;

    public Book(final String author, final String title, final int publicationYear) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
