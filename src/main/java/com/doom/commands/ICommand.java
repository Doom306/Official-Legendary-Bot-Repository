package com.doom.commands;

import java.util.List;

public interface ICommand {
    void handle(CommandContext ctx) throws InterruptedException;

    String getName();

    String getHelp();

    default List<String> getAliases() { return List.of(); }
}
