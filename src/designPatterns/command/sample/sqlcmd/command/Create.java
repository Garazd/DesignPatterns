package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.DataSet;
import designPatterns.command.sample.sqlcmd.DataSetImpl;
import designPatterns.command.sample.sqlcmd.DatabaseManager;
import designPatterns.command.sample.sqlcmd.View;

public class Create implements Command {

    private final DatabaseManager manager;
    private final View view;

    public Create(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("create|");
    }

    @Override
    public String description() {
        return "Созание записи в таблице";
    }

    @Override
    public String format() {
        return "create|tableName|column1|value1|column2|value2|...|columnN|valueN";
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException(
                    String.format("Должно быть четное количество параметров в формате " +
                            "'%s', а ты ввел: '%s'", format(), command));
        }

        String tableName = data[1];

        DataSet dataSet = new DataSetImpl();
        for (int index = 1; index < (data.length / 2); index++) {
            String columnName = data[index * 2];
            String value = data[index * 2 + 1];

            dataSet.put(columnName, value);
        }
        manager.create(tableName, dataSet);

        view.write(String.format("Запись %s была успешно создана в таблице '%s'.", dataSet, tableName));
    }
}