package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteCreatorA;
import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteProductA;
import designPatterns.factoryMethod.classic.case2_abstractClass.Creator;
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