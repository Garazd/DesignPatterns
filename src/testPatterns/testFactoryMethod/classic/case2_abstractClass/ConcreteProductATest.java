package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteProductA;
import designPatterns.factoryMethod.classic.case2_abstractClass.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteProductATest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductA();
        product.setup("config");

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductA[config]: data", result);
    }
}
