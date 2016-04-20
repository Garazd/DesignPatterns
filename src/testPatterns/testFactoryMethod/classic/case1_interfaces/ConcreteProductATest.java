package testPatterns.testFactoryMethod.classic.case1_interfaces;

import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteProductA;
import designPatterns.factoryMethod.classic.case1_interfaces.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteProductATest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductA();

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductA: data", result);
    }
}