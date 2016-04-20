package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteProductB;
import designPatterns.factoryMethod.classic.case2_abstractClass.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteProductBTest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductB();
        product.setup("config");

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductB[config]: data", result);
    }
}