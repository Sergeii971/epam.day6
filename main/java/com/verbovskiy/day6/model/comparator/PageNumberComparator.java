package com.verbovskiy.day6.model.comparator;

import com.verbovskiy.day6.model.entity.Book;

import java.util.Comparator;

public class PageNumberComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getPageNumber(),book2.getPageNumber());
    }
}
