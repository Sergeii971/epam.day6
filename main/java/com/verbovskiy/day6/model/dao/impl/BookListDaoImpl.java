package com.verbovskiy.day6.model.dao.impl;

import com.verbovskiy.day6.model.dao.BookListDao;
import com.verbovskiy.day6.model.comparator.AuthorComparator;
import com.verbovskiy.day6.model.comparator.EditionComparator;
import com.verbovskiy.day6.model.comparator.NameComparator;
import com.verbovskiy.day6.model.comparator.PageNumberComparator;
import com.verbovskiy.day6.model.entity.CustomBook;
import com.verbovskiy.day6.model.entity.Library;
import com.verbovskiy.day6.exception.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookListDaoImpl implements BookListDao {

    @Override
    public void add(CustomBook book) throws DaoException {
        if ((book == null) || (!Library.getInstance().addBook(book))) {
            throw new DaoException("incorrect data");
        }
    }

    @Override
    public void remove(CustomBook book) throws DaoException {
       if ((book == null) || (!Library.getInstance().removeBook(book))) {
           throw new DaoException("incorrect data");
       }
    }

    @Override
    public CustomBook findById(UUID id) throws DaoException {
        if (id == null) {
            throw new DaoException("incorrect data");
        }
        CustomBook foundBook = new CustomBook();
        List<CustomBook> booksFromLibrary = Library.getInstance().getBooks();

        for (CustomBook book : booksFromLibrary) {
            if (book.getId().equals(id)) {
                foundBook = book;
                break;
            }
        }
        return foundBook;
    }

    @Override
    public List<CustomBook> findByName(String name) throws DaoException {
        if (name == null) {
            throw new DaoException("incorrect data");
        }
        List<CustomBook> foundBooks = new ArrayList<>();
        List<CustomBook> booksFromLibrary = Library.getInstance().getBooks();

        for (CustomBook book : booksFromLibrary) {
            if (book.getName().toUpperCase().equals(name.toUpperCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) throws DaoException {
        if (author == null) {
            throw new DaoException("incorrect data");
        }
        List<CustomBook> foundBooks = new ArrayList<>();
        List<CustomBook> booksFromLibrary = Library.getInstance().getBooks();

        for (CustomBook book : booksFromLibrary) {
            if (book.getAuthor().toUpperCase().equals(author.toUpperCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<CustomBook> findByEdition(String edition) throws DaoException {
        if (edition == null) {
            throw new DaoException("incorrect data");
        }
        List<CustomBook> foundBooks = new ArrayList<>();
        List<CustomBook> booksFromLibrary = Library.getInstance().getBooks();

        for (CustomBook book : booksFromLibrary) {
            if (book.getEdition().toUpperCase().equals(edition.toUpperCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<CustomBook> findByPageNumber(int pageNumber) throws DaoException {
        if (pageNumber <= 0) {
            throw new DaoException("incorrect data");
        }
        List<CustomBook> foundBooks = new ArrayList<>();
        List<CustomBook> booksFromLibrary = Library.getInstance().getBooks();

        for (CustomBook book : booksFromLibrary) {
            if (book.getPageNumber() == pageNumber) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<CustomBook> sortBooksByName() {
        List<CustomBook> books = new ArrayList<>(Library.getInstance().getBooks());
        books.sort(new NameComparator());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() {
        List<CustomBook> books = new ArrayList<>(Library.getInstance().getBooks());
        books.sort(new AuthorComparator());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByEdition() {
        List<CustomBook> books = new ArrayList<>(Library.getInstance().getBooks());
        books.sort(new EditionComparator());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByPageNumber() {
        List<CustomBook> books = new ArrayList<>(Library.getInstance().getBooks());
        books.sort(new PageNumberComparator());
        return books;
    }
}
