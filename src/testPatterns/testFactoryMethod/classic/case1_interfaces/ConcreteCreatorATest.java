package testPatterns.testFactoryMethod.classic.case1_interfaces;

import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteCreatorA;
import designPatterns.factoryMethod.classic.case1_interfaces.ConcreteProductA;
import designPatterns.factoryMethod.classic.case1_interfaces.Creator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConcreteCreatorATest {

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new ConcreteCreatorA();

        // when then
        assertEquals(ConcreteProductA.class,
                creator.factoryMethod().getClass());
    }
}