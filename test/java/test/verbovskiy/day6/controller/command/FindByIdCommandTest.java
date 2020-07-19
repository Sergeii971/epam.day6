package test.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.controller.command.impl.FindByIdCommand;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.entity.Library;
import com.verbovskiy.day6.util.IdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FindByIdCommandTest {
    ActionCommand findByIdCommand;

    @BeforeClass
    public void setUp() {
        findByIdCommand = new FindByIdCommand();
    }

    @Test
    public void executePositiveTest() {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        Book book = new Book();
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, book);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.ID, IdGenerator.createId());
        Map<String, Object> actual = findByIdCommand.execute(actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Book book1 = new Book("Book1", "Ivan", "Moscow", 100);
        Book book2 = new Book("Book2", "Dima", "New-York", 150);
        Book book3 = new Book("Book3", "Sasha", "Minsk", 200);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, book1);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.ID, IdGenerator.createId());
        Map<String, Object> actual = findByIdCommand.execute(actionParameters);
        assertNotEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        Library.getInstance().removeAll();
    }
}