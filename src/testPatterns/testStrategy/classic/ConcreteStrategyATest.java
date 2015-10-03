package testPatterns.testStrategy.classic;

import designPatterns.strategy.classic.ConcreteStrategyA;
import designPatterns.strategy.classic.Strategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcreteStrategyATest {

    private Strategy strategy = new ConcreteStrategyA();

    @Test
    public void test() {
        assertEquals("toString:'String'", strategy.algorithm("String"));
        assertEquals("toString:'true'", strategy.algorithm(true));
        assertEquals("toString:'7.6'", strategy.algorithm(7.6));
    }
}