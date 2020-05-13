package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultImplementation(result, null, DatabaseCommandStatus.SUCCESS);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultImplementation(null, message, DatabaseCommandStatus.FAILED);
    }

    class DatabaseCommandResultImplementation implements DatabaseCommandResult {

        private String result;
        private String message;
        private DatabaseCommandStatus status;

        public DatabaseCommandResultImplementation(String result, String message, DatabaseCommandStatus status) {
            this.result = result;
            this.message = message;
            this.status = status;
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return result != null;
        }

        @Override
        public String getErrorMessage() {
            return message;
        }
    }
}