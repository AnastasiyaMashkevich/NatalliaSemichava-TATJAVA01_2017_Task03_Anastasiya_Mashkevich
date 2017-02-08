package controller.command.impl;


import controller.command.Command;

public class Error implements Command {// не надо так классы называть
    public String execute(String request) {
        return "Wrong request";
    }
}
