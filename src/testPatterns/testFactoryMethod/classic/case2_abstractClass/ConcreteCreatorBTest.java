package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteCreatorB;
import designPatterns.factoryMethod.classic.case2_abstractClass.ConcreteProductB;
import designPatterns.factoryMethod.classic.case2_abstractClass.Creator;
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