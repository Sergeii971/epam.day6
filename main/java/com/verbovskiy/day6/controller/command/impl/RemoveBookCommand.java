package com.verbovskiy.day6.controller.command.impl;

import com.verbovskiy.day6.controller.command.ActionCommand;
import com.verbovskiy.day6.controller.command.CommandParameter;
import com.verbovskiy.day6.exception.ServiceException;
import com.verbovskiy.day6.model.entity.Book;
import com.verbovskiy.day6.model.service.LibraryService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RemoveBookCommand implements ActionCommand {
    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        LibraryService libraryService = new LibraryService();

        Book book = new Book((String) actionParameters.get(CommandParameter.BOOK_NAME),
                (String) actionParameters.get(CommandParameter.AUTHOR),
                (String) actionParameters.get(CommandParameter.EDITION),
                (int) actionParameters.get(CommandParameter.NUMBER_OF_PAGE));
        book.setId((UUID) actionParameters.get(CommandParameter.ID));
        try {
            libraryService.remove(book);
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        } catch (ServiceException e) {
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        }
        return response;
    }
}
