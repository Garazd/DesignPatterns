package testPatterns.testFactoryMethod.classic.case3_switchCase;

import designPatterns.factoryMethod.classic.case3_switchCase.ConcreteProductA;
import designPatterns.factoryMethod.classic.case3_switchCase.Product;
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