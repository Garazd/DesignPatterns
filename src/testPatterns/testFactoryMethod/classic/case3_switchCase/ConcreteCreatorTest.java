package testPatterns.testFactoryMethod.classic.case3_switchCase;

import designPatterns.factoryMethod.classic.case3_switchCase.ConcreteCreator;
import designPatterns.factoryMethod.classic.case3_switchCase.ConcreteProductA;
import designPatterns.factoryMethod.classic.case3_switchCase.ConcreteProductB;
import designPatterns.factoryMethod.classic.case3_switchCase.Creator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConcreteCreatorTest {

    @Test
    public void shouldCreateA() {
        // given
        Creator creator = new ConcreteCreator();

        // when then
        assertEquals(ConcreteProductA.class,
                creator.createProduct("Product A").getClass());
    }

    @Test
    public void shouldCreateB() {
        // given
        Creator creator = new ConcreteCreator();

        // when then
        assertEquals(ConcreteProductB.class,
                creator.createProduct("Product B").getClass());
    }

    @Test
    public void shouldErrorWhenNotExistsProdct() {
        // given
        Creator creator = new ConcreteCreator();

        // when
        try {
            creator.createProduct("Product C");
            fail("Expected exception!");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unexpected product: Product C", e.getMessage());
        }
    }
}