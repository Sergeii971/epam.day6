package com.verbovskiy.day6.controller.command.impl;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.model.entity.CustomBook;
import com.verbovskiy.day6.model.service.LibraryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByAuthorCommand implements ActionCommand {
    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        LibraryService libraryService = new LibraryService();
        List<CustomBook> books = libraryService.sortBooksByAuthor();

        response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        response.put(CommandParameter.RESPONSE_RESULT, books);
        return response;
    }
}
