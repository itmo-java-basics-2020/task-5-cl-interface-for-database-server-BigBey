package ru.andrey.kvstorage.commands_implementation;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class ReadKey implements DatabaseCommand {

    private static final String MESSAGE = "Table already exists";

    private ExecutionEnvironment executionEnvironment;
    private String databaseName;
    private String tableName;
    private String objectKey;

    public ReadKey(ExecutionEnvironment executionEnvironment, String databaseName, String tableName, String objectKey) {
        this.executionEnvironment = executionEnvironment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.objectKey = objectKey;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (executionEnvironment.getDatabase(databaseName).isPresent()) {
            Database db = executionEnvironment.getDatabase(databaseName).get();
            try {
                DatabaseCommandResult result = DatabaseCommandResult.success(db.read(tableName, objectKey));
                return result;
            } catch (DatabaseException e) {
                return DatabaseCommandResult.error(MESSAGE);
            }
        } else {
            return DatabaseCommandResult.error(MESSAGE);
        }
    }
}
