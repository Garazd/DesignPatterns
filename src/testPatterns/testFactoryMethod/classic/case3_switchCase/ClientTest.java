package testPatterns.testFactoryMethod.classic.case3_switchCase;

import designPatterns.factoryMethod.classic.case3_switchCase.Client;
import designPatterns.factoryMethod.classic.case3_switchCase.Creator;
import designPatterns.factoryMethod.classic.case3_switchCase.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    private String productName;

    @Test
    public void shouldProcess() {
        // given
        Client client = new Client();

        Creator creator = new Creator() {
            @Override
            public Product createProduct(String productName) {
                ClientTest.this.productName = productName;

                return new Product() {
                    @Override
                    public String process(String data) {
                        return data + "_changed";
                    }
                };
            }
        };

        // when
        String result = client.process("data", creator, "product");

        // then
        assertEquals("data_changed", result);
        assertEquals("product", productName);
    }
}