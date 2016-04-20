package testPatterns.testFactoryMethod.classic.case1_interfaces;

import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteCreatorB;
import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteProductB;
import designPatterns.factoryMethod.classic.case1_interfaces.Creator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteCreatorBTest {

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new ConcreteCreatorB();

        // when then
        assertEquals(ConcreteProductB.class,
                creator.factoryMethod().getClass());
    }
}