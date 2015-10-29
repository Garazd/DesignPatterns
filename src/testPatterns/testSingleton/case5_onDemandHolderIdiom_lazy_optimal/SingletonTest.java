package testPatterns.testSingleton.case5_onDemandHolderIdiom_lazy_optimal;

import designPatterns.singleton.case5_onDemandHolderIdiom_lazy_optimal.Fail;
import testPatterns.testSingleton.MultithreadingTest;

public class SingletonTest extends MultithreadingTest {

    @Override
    protected Object getSingleton() {
        return Fail.Singleton.getInstance();
    }
}