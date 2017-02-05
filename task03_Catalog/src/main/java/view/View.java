package view;


import controller.Controller;
import controller.command.CommandName;


public class View {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeCommand(CommandName.ADD_NEWS_ITEM, "book/The Old Man and the Sea/written by Ernest Hemingway/2015");
        controller.executeCommand(CommandName.SEARCH_BY_YEAR, "1951");
        controller.executeCommand(CommandName.SEARCH_BY_TITLE, "The_Martian");
    }
}
