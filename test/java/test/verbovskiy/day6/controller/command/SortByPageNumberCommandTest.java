package test.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.controller.command.impl.SortByPageNumberCommand;
import com.verbovskiy.day6.model.entity.CustomBook;
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
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> books = new ArrayList<>();
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
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().add(book1);
        Library.getInstance().add(book2);
        Library.getInstance().add(book3);
        List<CustomBook> books = new ArrayList<>();
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