package designPatterns.singleton;

public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;

    private DoubleCheckedLocking() {
    }

    private synchronized static void doSync() {
        //It is only to synchronize
    }

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {
            DoubleCheckedLocking.doSync();
            if (instance == null)
                instance = new DoubleCheckedLocking();
        }
        return instance;
    }
}