package com.verbovskiy.day6.controller.command;

import com.verbovskiy.day6.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK(new AddBookCommand()),
    REMOVE_BOOK(new RemoveBookCommand()),
    FIND_BY_ID(new FindByIdCommand()),
    FIND_BY_NAME(new FindByNameCommand()),
    FIND_BY_NUMBER_OF_PAGE(new FindByPageNumberCommand()),
    FIND_BY_AUTHOR(new FindByAuthorCommand()),
    SORT_BY_NAME(new SortByNameCommand()),
    SORT_BY_AUTHOR(new SortByAuthorCommand()),
    SORT_BY_EDITION(new SortByEditionCommand()),
    SORT_BY_PAGE_NUMBER(new SortByPageNumberCommand()),
    EMPTY_COMMAND(new EmptyCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
