package test.verbovskiy.day6.model.service;

import com.verbovskiy.day6.exception.ServiceException;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.entity.Library;
import com.verbovskiy.day6.model.service.LibraryService;
import com.verbovskiy.day6.util.IdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LibraryServiceTest {
    LibraryService libraryService;

    @BeforeMethod
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test(expectedExceptions = ServiceException.class)
    public void addExceptionTest() throws ServiceException {
        libraryService.add(null);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void removeExceptionTest() throws ServiceException {
        libraryService.remove(null);
    }

    @Test
    public void findByIdPositiveTest() throws ServiceException {
        Book actual = libraryService.findById(IdGenerator.createId());
        Book expected = new Book();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws ServiceException {
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book actual = libraryService.findById(IdGenerator.createId());
        Book expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByIdExceptionTest() throws ServiceException {
        libraryService.findById(null);
    }

    @Test
    public void findByNamePositiveTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByName("Book2");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByName("Book2");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByNameExceptionTest() throws ServiceException {
        libraryService.findByName(null);
    }

    @Test
    public void findByAuthorPositiveTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByAuthor("Dima");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByAuthor("Dima");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByAuthorExceptionTest() throws ServiceException {
        libraryService.findByAuthor(null);
    }

    @Test
    public void findByEditionPositiveTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByEdition("New-York");
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByEdition("New_York");
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByEditionExceptionTest() throws ServiceException {
        libraryService.findByEdition(null);
    }

    @Test
    public void findByPageNumberPositiveTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByPageNumber(150);
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws ServiceException {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.findByPageNumber(150);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByPageNumberExceptionTest() throws ServiceException {
        libraryService.findByPageNumber(-1);
    }

    @Test
    public void sortBooksByNamePositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> actual = libraryService.sortBooksByName();
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
        List<Book> actual = libraryService.sortBooksByName();
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
        List<Book> actual = libraryService.sortBooksByAuthor();
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
        List<Book> actual = libraryService.sortBooksByAuthor();
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
        List<Book> actual = libraryService.sortBooksByEdition();
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
        List<Book> actual = libraryService.sortBooksByEdition();
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
        List<Book> actual = libraryService.sortBooksByPageNumber();
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
        List<Book> actual = libraryService.sortBooksByPageNumber();
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