package com.verbovskiy.day6.model.dao;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.model.entity.CustomBook;

import java.util.List;
import java.util.UUID;

public interface BookListDao {
    void add(CustomBook book) throws DaoException;

    void remove(CustomBook book) throws DaoException;

    CustomBook findById(UUID id) throws DaoException;

    List<CustomBook> findByName(String name) throws DaoException;

    List<CustomBook> findByAuthor(String author) throws DaoException;

    List<CustomBook> findByEdition(String edition) throws DaoException;

    List<CustomBook> findByPageNumber(int pageNumber) throws DaoException;

    List<CustomBook> sortBooksByName();

   List<CustomBook> sortBooksByAuthor();

    List<CustomBook> sortBooksByEdition();

    List<CustomBook> sortBooksByPageNumber();
}
