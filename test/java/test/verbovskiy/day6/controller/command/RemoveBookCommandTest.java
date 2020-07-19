package test.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.controller.command.impl.RemoveBookCommand;
import com.verbovskiy.day6.model.entity.CustomBook;
import com.verbovskiy.day6.model.entity.Library;
import com.verbovskiy.day6.util.IdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RemoveBookCommandTest {
    ActionCommand removeBookCommand;

    @BeforeClass
    public void setUp() {
        removeBookCommand = new RemoveBookCommand();
    }

    @Test
    public void executePositiveTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.ID, IdGenerator.createId());
        actionParameters.put(CommandParameter.BOOK_NAME,"Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = removeBookCommand.execute(actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        CustomBook book1 = new CustomBook("Book3", "Ivan", "Moscow", 200);
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook book3 = new CustomBook("Book1", "Sasha", "Minsk", 100);
        Library.getInstance().addBook(book1);
        Library.getInstance().addBook(book2);
        Library.getInstance().addBook(book3);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.ID, IdGenerator.createId());
        actionParameters.put(CommandParameter.BOOK_NAME,"Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = removeBookCommand.execute(actionParameters);
        assertNotEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        Library.getInstance().removeAll();
    }

}