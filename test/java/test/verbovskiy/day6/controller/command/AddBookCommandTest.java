package test.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.controller.command.impl.AddBookCommand;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.entity.Library;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class AddBookCommandTest {
    ActionCommand addBookCommand;

    @BeforeClass
    public void setUp() {
        addBookCommand = new AddBookCommand();
    }

    @Test
    public void executePositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.BOOK_NAME,"Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = addBookCommand.execute(actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.BOOK_NAME, "Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = addBookCommand.execute(actionParameters);
        assertNotEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        Library.getInstance().removeAll();
    }
}