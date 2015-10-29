package testPatterns.testSingleton.case2_enumSingleton_notLazy;

import designPatterns.singleton.case2_enumSingleton_notLazy.Singleton;
import testPatterns.testSingleton.MultithreadingTest;

public class SingletonTest extends MultithreadingTest {

    @Override
    protected Object getSingleton() {
        return Singleton.INSTANCE;
    }
}