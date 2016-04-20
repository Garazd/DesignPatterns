package testPatterns.testFactoryMethod.classic.case1_interfaces;

import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteProductB;
import designPatterns.factoryMethod.classic.case1_interfaces.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteProductBTest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductB();

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductB: data", result);
    }
}