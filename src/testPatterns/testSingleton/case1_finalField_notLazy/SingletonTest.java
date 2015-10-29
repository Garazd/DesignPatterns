package testPatterns.testSingleton.case1_finalField_notLazy;

import designPatterns.singleton.case1_finalField_notLazy.Singleton;
import testPatterns.testSingleton.MultithreadingTest;

public class SingletonTest extends MultithreadingTest {

    @Override
    protected Object getSingleton() {
        return Singleton.getInstance();
    }
}