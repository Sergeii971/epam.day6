package test.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.controller.command.impl.SortByAuthorCommand;
import com.verbovskiy.day6.controller.command.impl.SortByPageNumberCommand;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.entity.Library;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SortByPageNumberCommandTest {
    ActionCommand sortByPageNumberCommand;

    @BeforeClass
    public void setUp() {
        sortByPageNumberCommand = new SortByPageNumberCommand();
    }

    @Test
    public void executePositiveTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 200);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> books = new ArrayList<>();
        books.add(book3);
        books.add(book2);
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        Map<String, Object> actionParameters = new HashMap<>();
        Map<String, Object> actual = sortByPageNumberCommand.execute(actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Book book1 = new Book("Book3", "Ivan", "Moscow", 200);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        List<Book> books = new ArrayList<>();
        books.add(book2);
        books.add(book3);
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        Map<String, Object> actionParameters = new HashMap<>();
        Map<String, Object> actual = sortByPageNumberCommand.execute(actionParameters);
        assertNotEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        Library.getInstance().removeAll();
    }
}