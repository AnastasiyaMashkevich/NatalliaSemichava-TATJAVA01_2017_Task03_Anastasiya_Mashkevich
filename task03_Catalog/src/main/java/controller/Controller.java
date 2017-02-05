package controller;

import controller.command.Command;
import controller.command.CommandName;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeCommand(CommandName command, String data) {
        Command executionCommand = provider.getCommand(command);
        return executionCommand.execute(data);
    }
}
