package testPatterns.testSingleton.case3_synchronizedAccessor_lazy_notOptimal;

import designPatterns.singleton.case3_synchronizedAccessor_lazy_notOptimal.Singleton;
import testPatterns.testSingleton.MultithreadingTest;

public class SingletonTest extends MultithreadingTest {

    @Override
    protected Object getSingleton() {
        return Singleton.getInstance();
    }
}