package com.verbovskiy.day6.model.service;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.exception.ServiceException;
import com.verbovskiy.day6.model.dao.BookListDao;
import com.verbovskiy.day6.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day6.model.entity.Book;

import java.util.List;
import java.util.UUID;

public class LibraryService {
    public void add(Book book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            bookListDao.add(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void remove(Book book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            bookListDao.remove(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Book findById(UUID id) throws ServiceException {
        Book book;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            book = bookListDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return book;
    }

    public List<Book> findByName(String name) throws ServiceException {
        List<Book> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<Book> findByAuthor(String author) throws ServiceException {
        List<Book> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByAuthor(author);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<Book> findByEdition(String edition) throws ServiceException {
        List<Book> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByEdition(edition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<Book> findByPageNumber(int pageNumber) throws ServiceException {
        List<Book> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByPageNumber(pageNumber);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<Book> sortBooksByName() {
        BookListDao bookListDao = new BookListDaoImpl();

        return bookListDao.sortBooksByName();
    }

    public List<Book> sortBooksByAuthor() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> foundBooks = bookListDao.sortBooksByAuthor();

        return foundBooks;
    }

    public List<Book> sortBooksByEdition() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> foundBooks = bookListDao.sortBooksByEdition();

        return foundBooks;
    }

    public List<Book> sortBooksByPageNumber() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> foundBooks = bookListDao.sortBooksByPageNumber();

        return foundBooks;
    }
}
