package ru.andrey.kvstorage.commands_implementation;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.exception.DatabaseException;

public class FakeCommand implements DatabaseCommand {
    private static final String MESSAGE = "Table already exists";

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        return DatabaseCommandResult.error(MESSAGE);
    }
}
