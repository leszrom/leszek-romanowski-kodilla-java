package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianaAdapter extends MedianaAdaptee implements Classifier {
    @Override
    public int publicationYearMadian(Set<BookA> bookSet) {
        Map<BookSignature, BookB> books = bookSet.stream()
                .collect(Collectors.toMap(
                        bookA -> new BookSignature(bookA.getSignature()),
                        bookA -> new BookB(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear())));
        return medianPublicationYear(books);
    }
}
