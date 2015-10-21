package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.DatabaseManager;
import designPatterns.command.sample.sqlcmd.View;

public class IsConnected extends Processor {

    private DatabaseManager manager;
    private View view;

    public IsConnected(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return !manager.isConnected();
    }

    @Override
    public void process(String command) {
        view.write(String.format("Ты не можешь пользоваться командой '%s' пока " +
                "не подключишься с помощью комманды " +
                "connect|databaseName|userName|password", command));
    }
}