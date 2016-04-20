package testPatterns.testFactoryMethod.sample.imageReader;

import designPatterns.factoryMethod.sample.imageReader.ColorImage;
import designPatterns.factoryMethod.sample.imageReader.ColorImageLoader;
import designPatterns.factoryMethod.sample.imageReader.Image;
import designPatterns.factoryMethod.sample.imageReader.Loader;
import java.awt.image.BufferedImage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

public class ColorImageLoaderTest {

    // проверяем, что загрузчик обернет исходный BufferedImage без изменений
    @Test
    public void shouldWrapImage() {
        // given
        Loader loader = new ColorImageLoader();
        BufferedImage bufferedImage = mock(BufferedImage.class);

        // when
        Image image = loader.createImage(bufferedImage);

        // then
        assertEquals(ColorImage.class, image.getClass());
        assertSame(bufferedImage, image.getImage());
    }
}