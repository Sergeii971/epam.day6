package com.verbovskiy.day6.model.comparator;

import com.verbovskiy.day6.model.entity.CustomBook;

import java.util.Comparator;

public class AuthorComparator implements Comparator<CustomBook> {
    @Override
    public int compare(CustomBook book1, CustomBook book2) {
        return book1.getAuthor().compareTo(book2.getAuthor());
    }
}
