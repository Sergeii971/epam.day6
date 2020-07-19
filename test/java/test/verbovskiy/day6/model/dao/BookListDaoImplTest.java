package test.verbovskiy.day6.model.dao;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.model.dao.BookListDao;
import com.verbovskiy.day6.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.entity.Library;
import com.verbovskiy.day6.util.IdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BookListDaoImplTest {
    BookListDao bookListDao;

    @BeforeMethod
    public void setUp() {
        bookListDao = new BookListDaoImpl();
    }

    @Test(expectedExceptions = DaoException.class)
    public void addExceptionTest() throws DaoException {
        bookListDao.add(null);
    }

    @Test(expectedExceptions = DaoException.class)
    public void removeExceptionTest() throws DaoException {
        bookListDao.remove(null);
    }

    @Test
    public void findByIdPositiveTest() throws DaoException {
        Book actual = bookListDao.findById(IdGenerator.createId());
        Book expected = new Book();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws DaoException {
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book actual = bookListDao.findById(IdGenerator.createId());
        Book expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByIdExceptionTest() throws DaoException {
        bookListDao.findById(null);
    }

    @Test
    public void findByNamePositiveTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByName("Book2");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByName("Book2");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByNameExceptionTest() throws DaoException {
        bookListDao.findByName(null);
    }

    @Test
    public void findByAuthorPositiveTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByAuthor("Dima");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByAuthor("Dima");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByAuthorExceptionTest() throws DaoException {
        bookListDao.findByAuthor(null);
    }

    @Test
    public void findByEditionPositiveTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByEdition("New-York");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByEdition("New_York");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByEditionExceptionTest() throws DaoException {
        bookListDao.findByEdition(null);
    }

    @Test
    public void findByPageNumberPositiveTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByPageNumber(150);
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws DaoException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.findByPageNumber(150);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByPageNumberExceptionTest() throws DaoException {
        bookListDao.findByPageNumber(-1);
    }

    @Test
    public void sortBooksByNamePositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByName();
        List<Book> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByNameNegativeTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByName();
        List<Book> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorPositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByAuthor();
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        expected.add(book3);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorNegativeTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByAuthor();
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionPositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByEdition();
        List<Book> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionNegativeTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByEdition();
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageNumberPositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 200);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByPageNumber();
        List<Book> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageNumberNegativeTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 200);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = bookListDao.sortBooksByPageNumber();
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        assertNotEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        Library.getInstance().removeAll();
    }
}