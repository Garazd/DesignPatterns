package testPatterns.testStrategy.classic;

import designPatterns.strategy.classic.Context;
import designPatterns.strategy.classic.Strategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContextTest {

    @Test
    public void testConstructorInjection() {
        // given
        Context context = new Context(new Strategy() {
            @Override
            public Object algorithm(Object input) {
                return input.toString().toUpperCase();
            }
        });

        // when
        Object actual = context.method("qwe");

        // then
        assertEquals("Object: qwe, QWE", actual);
    }
}