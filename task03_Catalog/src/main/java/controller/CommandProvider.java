package controller;

import controller.command.Command;
import controller.command.CommandName;
import controller.command.impl.AddNewsItem;
import controller.command.impl.SearchNewsItemByTitle;
import controller.command.impl.SearchNewsItemByYear;
import controller.command.impl.Error;

public final class CommandProvider {

    public Command getCommand(CommandName name) {
        Command command;
        switch (name) {
            case ADD_NEWS_ITEM:
                command = new AddNewsItem();
                break;
            case SEARCH_BY_YEAR:
                command = new SearchNewsItemByYear();
                break;
            case SEARCH_BY_TITLE:
                command = new SearchNewsItemByTitle();
                break;
            default:
                command = new Error();
        }
        return command;
    }
}
