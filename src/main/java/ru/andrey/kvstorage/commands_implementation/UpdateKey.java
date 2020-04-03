package ru.andrey.kvstorage.commands_implementation;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class UpdateKey implements DatabaseCommand {

    private ExecutionEnvironment executionEnvironment;
    private String databaseName;
    private String tableName;
    private String objectKey;
    private String objectValue;

    public UpdateKey(ExecutionEnvironment executionEnvironment, String databaseName, String tableName, String objectKey, String objectValue){
        this.executionEnvironment = executionEnvironment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.objectKey = objectKey;
        this.objectValue = objectValue;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if(executionEnvironment.getDatabase(databaseName).isPresent()) {
            Database db = executionEnvironment.getDatabase(databaseName).get();
            db.write(tableName, objectKey, objectValue);
        }
        return null;
    }
}
