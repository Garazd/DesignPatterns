package testPatterns.testFactoryMethod.sample.imageReader;

import designPatterns.factoryMethod.sample.imageReader.GrayScaleImage;
import designPatterns.factoryMethod.sample.imageReader.GrayScaleImageLoader;
import designPatterns.factoryMethod.sample.imageReader.Image;
import designPatterns.factoryMethod.sample.imageReader.Loader;
import java.awt.image.BufferedImage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GrayScaleImageLoaderTest {

    // проверяем, что загрузчик обернет исходный BufferedImage
    // предварительно переведя его в оттенки серого
    @Test
    public void shouldWrapImage() {
        // given
        Loader loader = new GrayScaleImageLoader();
        BufferedImage bufferedImage = new BufferedImage(100, 100,
                BufferedImage.TYPE_INT_RGB);

        // when
        Image image = loader.createImage(bufferedImage);

        // then
        assertEquals(GrayScaleImage.class, image.getClass());

        BufferedImage grayScaleImage = image.getImage();
        assertEquals(BufferedImage.TYPE_BYTE_GRAY, grayScaleImage.getType());

        assertEquals(100, grayScaleImage.getWidth());
        assertEquals(100, grayScaleImage.getHeight());

        // тут бы по хорошему еще проверить попиксельно как случился перевод
        // но то не в этой серии TODO может быть как-нибудь
    }
}