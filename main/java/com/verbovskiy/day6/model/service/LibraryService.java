package com.verbovskiy.day6.model.service;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.exception.ServiceException;
import com.verbovskiy.day6.model.dao.BookListDao;
import com.verbovskiy.day6.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day6.model.entity.CustomBook;

import java.util.List;
import java.util.UUID;

public class LibraryService {
    public void add(CustomBook book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            bookListDao.add(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void remove(CustomBook book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            bookListDao.remove(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public CustomBook findById(UUID id) throws ServiceException {
        CustomBook book;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            book = bookListDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return book;
    }

    public List<CustomBook> findByName(String name) throws ServiceException {
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByAuthor(String author) throws ServiceException {
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByAuthor(author);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByEdition(String edition) throws ServiceException {
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByEdition(edition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByPageNumber(int pageNumber) throws ServiceException {
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByPageNumber(pageNumber);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> sortBooksByName() {
        BookListDao bookListDao = new BookListDaoImpl();

        return bookListDao.sortBooksByName();
    }

    public List<CustomBook> sortBooksByAuthor() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> foundBooks = bookListDao.sortBooksByAuthor();

        return foundBooks;
    }

    public List<CustomBook> sortBooksByEdition() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> foundBooks = bookListDao.sortBooksByEdition();

        return foundBooks;
    }

    public List<CustomBook> sortBooksByPageNumber() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> foundBooks = bookListDao.sortBooksByPageNumber();

        return foundBooks;
    }
}
