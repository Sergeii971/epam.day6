package com.verbovskiy.day6.model.comparator;

import com.verbovskiy.day6.model.entity.CustomBook;

import java.util.Comparator;

public class PageNumberComparator implements Comparator<CustomBook> {
    @Override
    public int compare(CustomBook book1, CustomBook book2) {
        return Integer.compare(book1.getPageNumber(),book2.getPageNumber());
    }
}
