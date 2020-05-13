package ru.andrey.kvstorage;

import ru.andrey.kvstorage.commands_implementation.FakeCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) throws DatabaseException {
        if (commandText == null) {
            return DatabaseCommandResult.error("Command not set.");
        } else {
            String[] args = commandText.split(" ");
            try {
                DatabaseCommandResult result = DatabaseCommands.valueOf(args[0]).getCommand(env, args).execute();
                return result;
            } catch (IllegalArgumentException e) {
                return DatabaseCommandResult.error(e.getMessage());
            }
        }
    }
}
