package testPatterns.testFactoryMethod.classic.case2_abstractClass;

import designPatterns.factoryMethod.classic.case2_abstractClass.Client;
import designPatterns.factoryMethod.classic.case2_abstractClass.Creator;
import designPatterns.factoryMethod.classic.case2_abstractClass.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    private String config;

    @Test
    public void shouldProcess() {
        // given
        Client client = new Client();

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
                        ClientTest.this.config = config;
                    }
                };
            }
        };

        // when
        String result = client.process("data", "config", creator);

        // then
        assertEquals("data_changed", result);
        assertEquals("config", config);
    }
}