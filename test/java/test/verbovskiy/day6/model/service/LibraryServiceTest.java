package test.verbovskiy.day6.model.service;

import com.verbovskiy.day6.exception.ServiceException;
import com.verbovskiy.day6.model.entity.CustomBook;
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
        CustomBook actual = libraryService.findById(IdGenerator.createId());
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws ServiceException {
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook actual = libraryService.findById(IdGenerator.createId());
        CustomBook expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByIdExceptionTest() throws ServiceException {
        libraryService.findById(null);
    }

    @Test
    public void findByNamePositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByName("Book2");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByName("Book2");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByNameExceptionTest() throws ServiceException {
        libraryService.findByName(null);
    }

    @Test
    public void findByAuthorPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByAuthor("Dima");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByAuthor("Dima");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByAuthorExceptionTest() throws ServiceException {
        libraryService.findByAuthor(null);
    }

    @Test
    public void findByEditionPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByEdition("New-York");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByEdition("New_York");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByEditionExceptionTest() throws ServiceException {
        libraryService.findByEdition(null);
    }

    @Test
    public void findByPageNumberPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByPageNumberExceptionTest() throws ServiceException {
        libraryService.findByPageNumber(-1);
    }

    @Test
    public void sortBooksByNamePositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 200);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByName();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByName();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByAuthor();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByAuthor();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByEdition();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByEdition();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByPageNumber();
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
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> actual = libraryService.sortBooksByPageNumber();
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