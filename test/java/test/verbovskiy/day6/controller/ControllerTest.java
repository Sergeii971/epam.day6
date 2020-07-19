package test.verbovskiy.day6.controller;

import com.verbovskiy.day6.controller.Controller;
import com.verbovskiy.day6.controller.command.CommandParameter;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ControllerTest {
    @Test
    public void processRequestPositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        String currentCommand = "add_book";
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.BOOK_NAME,"Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = Controller.getInstance().processRequest(currentCommand, actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void processRequestNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        String currentCommand = "book";
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.BOOK_NAME,"Book1");
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        actionParameters.put(CommandParameter.EDITION, "Moscow");
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = Controller.getInstance().processRequest(currentCommand, actionParameters);
        assertNotEquals(actual, expected);
    }
}