package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.DataSet;
import designPatterns.command.sample.sqlcmd.DatabaseManager;
import designPatterns.command.sample.sqlcmd.View;

import java.util.List;

public class Remove implements Command {

    private DatabaseManager manager;
    private View view;

    public Remove(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("remove|");
    }

    @Override
    public String description() {
        return "Удаление записей из таблицы по запросу";
    }

    @Override
    public String format() {
        return "remove|tableName|column|value";
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");
        if (data.length != 4) {
            throw new IllegalArgumentException(
                    String.format("Формат команды '%s', а ты ввел: '%s'", format(), command));
        }
        String tableName = data[1];
        String column = data[2];
        String value = data[3];

        List<DataSet> removed = manager.remove(tableName, column, value);
        if (removed.isEmpty()) {
            view.write(String.format("%s записей было успешно удалено", removed.size()) +
                    toString(removed));
        } else {
            view.write(String.format("Нечего удалять! Проверь запрос"));
        }
    }

    private String toString(List<DataSet> list) {
        StringBuffer result = new StringBuffer();
        for (DataSet data : list) {
            result.append('\n').append(data.toString());
        }
        return result.toString();
    }
}