package test.verbovskiy.day6.model.dao;

import com.verbovskiy.day6.exception.DaoException;
import com.verbovskiy.day6.model.dao.BookListDao;
import com.verbovskiy.day6.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day6.model.entity.CustomBook;
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
        CustomBook actual = bookListDao.findById(IdGenerator.createId());
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws DaoException {
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook actual = bookListDao.findById(IdGenerator.createId());
        CustomBook expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByIdExceptionTest() throws DaoException {
        bookListDao.findById(null);
    }

    @Test
    public void findByNamePositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByName("Book2");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByName("Book2");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByNameExceptionTest() throws DaoException {
        bookListDao.findByName(null);
    }

    @Test
    public void findByAuthorPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByAuthor("Dima");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByAuthor("Dima");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByAuthorExceptionTest() throws DaoException {
        bookListDao.findByAuthor(null);
    }

    @Test
    public void findByEditionPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByEdition("New-York");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByEdition("New_York");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByEditionExceptionTest() throws DaoException {
        bookListDao.findByEdition(null);
    }

    @Test
    public void findByPageNumberPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void findByPageNumberExceptionTest() throws DaoException {
        bookListDao.findByPageNumber(-1);
    }

    @Test
    public void sortBooksByNamePositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByNameNegativeTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorPositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        expected.add(book3);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorNegativeTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionPositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByEdition();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionNegativeTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByEdition();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageNumberPositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByPageNumber();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageNumberNegativeTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<CustomBook> actual = bookListDao.sortBooksByPageNumber();
        List<CustomBook> expected = new ArrayList<>();
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