package com.verbovskiy.day6.model.dao;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.model.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookListDao {
    void add(Book book) throws DaoException;

    void remove(Book book) throws DaoException;

    Book findById(UUID id) throws DaoException;

    List<Book> findByName(String name) throws DaoException;

    List<Book> findByAuthor(String author) throws DaoException;

    List<Book> findByEdition(String edition) throws DaoException;

    List<Book> findByPageNumber(int pageNumber) throws DaoException;

    List<Book> sortBooksByName();

   List<Book> sortBooksByAuthor();

    List<Book> sortBooksByEdition();

    List<Book> sortBooksByPageNumber();
}
