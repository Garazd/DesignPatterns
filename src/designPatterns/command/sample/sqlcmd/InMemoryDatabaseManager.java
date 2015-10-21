package designPatterns.command.sample.sqlcmd;

import java.util.*;

public class InMemoryDatabaseManager implements DatabaseManager {

    private Map<String, List<DataSet>> tables = new LinkedHashMap<>();
    private boolean connected = false;

    @Override
    public List<DataSet> getTableData(String tableName) {
        return get(tableName);
    }

    @Override
    public int getSize(String tableName) {
        return get(tableName).size();
    }

    @Override
    public Set<String> getTableNames() {
        return tables.keySet();
    }

    @Override
    public void connect(String database, String userName, String password) {
        connected = true;
    }

    @Override
    public void clear(String tableName) {
        get(tableName).clear();
    }

    private List<DataSet> get(String tableName) {
        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new LinkedList<DataSet>());
        }
        return tables.get(tableName);
    }

    @Override
    public void create(String tableName, DataSet input) {
        get(tableName).add(input);
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        for (DataSet dataSet : get(tableName)) {
            if (dataSet.get("id") == id) {
                dataSet.updateFrom(newValue);
            }
        }
    }

    @Override
    public Set<String> getTableColumns(String tableName) {
        List<DataSet> table = get(tableName);
        if (table.isEmpty()) {
            return new LinkedHashSet<String>();
        } else {
            return new LinkedHashSet<String>(table.get(0).getNames());
        }
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public List<DataSet> remove(String tableName, String column, String value) {
        List<DataSet> table = get(tableName);
        List<DataSet> result = new LinkedList<DataSet>();
        for (DataSet dataSet : table) {
            if (dataSet.get(column).equals(value)) {
                result.add(dataSet);
            }
        }

        table.removeAll(result);
        return result;
    }
}