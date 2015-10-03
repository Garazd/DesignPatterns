package testPatterns.testStrategy.classic;

import designPatterns.strategy.classic.ConcreteStrategyB;
import designPatterns.strategy.classic.Strategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcreteStrategyBTest {

    private Strategy strategy = new ConcreteStrategyB();

    @Test
    public void test() {
        assertEquals("length:6", strategy.algorithm("String"));
        assertEquals("length:4", strategy.algorithm(true));
        assertEquals("length:3", strategy.algorithm(7.6));
    }
}