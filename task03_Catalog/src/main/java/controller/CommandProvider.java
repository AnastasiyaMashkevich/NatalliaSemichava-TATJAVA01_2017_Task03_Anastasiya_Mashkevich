package controller;

import controller.command.Command;
import controller.command.CommandName;
import controller.command.impl.AddNewsItem;
import controller.command.impl.SearchNewsItemByTitle;
import controller.command.impl.SearchNewsItemByYear;
import controller.command.impl.Error;

public final class CommandProvider {

    public Command getCommand(CommandName name) {// я шаблон Command зачем объявняла? а если у тебя 300 команд будет, тоже switch использовать?
        Command command;
        switch (name) {
            case ADD_NEWS_ITEM:
                command = new AddNewsItem();// НЕ ПЛОЖИТЕ СУЩНОСТЕЙ СВЕРХ НЕОБХОДИМОГО, зачем на каждый запрос создавать новую команду?
                // это как на каждый гвоздь покупать новый молоток
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
