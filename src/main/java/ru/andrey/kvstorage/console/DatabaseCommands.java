package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.commands_implementation.*;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            return new CreateDatabase();
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length == 3) {
                return new CreateTable(env, args[1], args[2]);
            } else {
                return new FakeCommand();
            }
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length == 4) {
                return new ReadKey(env, args[1], args[2], args[3]);
            } else {
                return new FakeCommand();
            }
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length == 5) {
                return new UpdateKey(env, args[1], args[2], args[3], args[4]);
            } else {
                return new FakeCommand();
            }
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String... args);
}
