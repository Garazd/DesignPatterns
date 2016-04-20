package testPatterns.testFactoryMethod.sample.imageReader;

import designPatterns.factoryMethod.sample.imageReader.Image;
import java.awt.image.BufferedImage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageTest {

    private BufferedImage sourceImage;
    private Image image;

    @Before
    public void setup() {
        // given

        // исходное изображение
        sourceImage = mock(BufferedImage.class);

        // анонимно дореализованный абстрактный класс
        // его мы будем тестить
        image = new Image(sourceImage) { };
    }

    @Test
    public void shouldWrapBufferedImage() {
        assertSame(sourceImage, image.getImage());
    }

    @Test
    public void shouldSameWidthAndHeight() {
        // given
        when(sourceImage.getHeight()).thenReturn(101);
        when(sourceImage.getWidth()).thenReturn(102);

        // when then
        assertEquals(101, image.getHeight());
        assertEquals(102, image.getWidth());
    }

    @Test
    public void shouldGetPixel() {
        // when
        image.get(11, 12);

        // then
        verify(sourceImage).getRGB(11, 12);
    }

    @Test
    public void shouldSetPixel() {
        // when
        image.set(11, 12, 13);

        // then
        verify(sourceImage).setRGB(11, 12, 13);
    }
}