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
        return new DatabaseCommandResultImplementation(result, null);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultImplementation(null, message);
    }

    class DatabaseCommandResultImplementation implements ru.andrey.kvstorage.console.DatabaseCommandResult {

        private String result;
        private String message;

        DatabaseCommandResultImplementation(String result, String message) {
            this.result = result;
            this.message = message;
        }


        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            if (result != null) {
                return DatabaseCommandStatus.SUCCESS;
            } else {
                return DatabaseCommandStatus.FAILED;
            }
        }

        @Override
        public boolean isSuccess() {
            return result != null;
        }

        @Override
        public String getErrorMessage() {
            if (message != null) {
                return message;
            } else {
                return null;
            }
        }
    }
}