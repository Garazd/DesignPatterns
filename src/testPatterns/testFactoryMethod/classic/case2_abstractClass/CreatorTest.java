package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.Creator;
import designPatterns.factoryMethod.classic.case2_abstractClass.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreatorTest {

    private String config;

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new Creator() {
            @Override
            public Product factoryMethod() {
                return new Product() {
                    @Override
                    public String process(String data) {
                        return data + "_changed";
                    }

                    @Override
                    public void setup(String config) {
                        CreatorTest.this.config = config;
                    }
                };
            }
        };

        // when
        Product product = creator.create("config");
        String result = product.process("data");

        // then
        assertEquals("data_changed", result);
        assertEquals("config", config);
    }
}