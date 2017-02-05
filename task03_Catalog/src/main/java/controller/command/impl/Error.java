package controller.command.impl;


import controller.command.Command;

public class Error implements Command {
    public String execute(String request) {
        return "Wrong request";
    }
}
