package testPatterns.testFactoryMethod.classic.case1_interfaces;

import designPatterns.factoryMethod.classic.case1_interfaces.Client;
import designPatterns.factoryMethod.classic.case1_interfaces.Creator;
import designPatterns.factoryMethod.classic.case1_interfaces.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClientTest {

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
                };
            }
        };

        // when
        String result = client.process("data", creator);

        // then
        assertEquals("data_changed", result);
    }
}