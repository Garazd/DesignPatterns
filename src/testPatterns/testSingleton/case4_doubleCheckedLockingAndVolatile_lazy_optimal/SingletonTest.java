package testPatterns.testSingleton.case4_doubleCheckedLockingAndVolatile_lazy_optimal;

import designPatterns.singleton.case4_doubleCheckedLockingAndVolatile_lazy_optimal.Singleton;
import testPatterns.testSingleton.MultithreadingTest;

public class SingletonTest extends MultithreadingTest {

    @Override
    protected Object getSingleton() {
        return Singleton.getInstance();
    }
}