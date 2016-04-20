package testPatterns.testFactoryMethod.classic.case3_switchCase;

import designPatterns.factoryMethod.classic.case3_switchCase.ConcreteProductB;
import designPatterns.factoryMethod.classic.case3_switchCase.Product;
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