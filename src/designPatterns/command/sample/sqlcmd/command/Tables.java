package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.DatabaseManager;
import designPatterns.command.sample.sqlcmd.View;

import java.util.Set;

public class Tables implements Command {

    private DatabaseManager manager;
    private View view;

    public Tables(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("tables");
    }

    @Override
    public String description() {
        return "Вывод всех таблиц базы";
    }

    @Override
    public String format() {
        return "tables";
    }

    @Override
    public void process(String command) {
        Set<String> tableNames = manager.getTableNames();

        view.write(tableNames.toString());
    }
}