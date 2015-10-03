package testPatterns.testStrategy.classic;

import designPatterns.strategy.classic.ConcreteStrategyC;
import designPatterns.strategy.classic.Strategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcreteStrategyCTest {

    private Strategy strategy = new ConcreteStrategyC();

    @Test
    public void test() {
        assertEquals("class:String", strategy.algorithm("String"));
        assertEquals("class:Boolean", strategy.algorithm(true));
        assertEquals("class:Double", strategy.algorithm(7.6));
    }
}