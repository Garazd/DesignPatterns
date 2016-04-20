package testPatterns.testFactoryMethod.sample.imageReader;

import designPatterns.factoryMethod.sample.imageReader.Client;
import designPatterns.factoryMethod.sample.imageReader.Image;
import designPatterns.factoryMethod.sample.imageReader.Loader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

// иначе нам не замокать статиеческий класс одним лишь мокито
// спасибо http://stackoverflow.com/a/21116014/4728425
@RunWith(PowerMockRunner.class)
@PrepareForTest(ImageIO.class)
public class ClientTest {

    @Test
    public void shouldProcessImage() throws IOException {
        // given

        // исходное изображение
        BufferedImage sourceImage = new BufferedImage(100, 100,
                BufferedImage.TYPE_INT_RGB);

        // тестируемый клиент
        Client client = new Client();

        // мокаем статический класс, тестить который нам не надо
        // потому что он сохраняет все на винт, а это просто не протестишь
        PowerMockito.mockStatic(ImageIO.class);
        when(ImageIO.read(any(File.class))).thenReturn(sourceImage);

        // наш продукт - обертка над BufferedImage
        final Image image = new Image(sourceImage) {};

        // наш загрузчик
        Loader loader = new Loader() {
            @Override
            public Image createImage(BufferedImage sourceImage) {
                return image;
            }
        };

        // when
        client.process("image.png", loader);

        // then

        // прочитали изображение
        PowerMockito.verifyStatic();
        ImageIO.read(new File("image.png"));

        // записали изображение в новый файл
        ArgumentCaptor<BufferedImage> captor = ArgumentCaptor.forClass(BufferedImage.class);
        PowerMockito.verifyStatic();
        ImageIO.write(captor.capture(), eq("jpeg"), eq(new File("image.png.jpeg")));
        BufferedImage savedImage = captor.getValue();

        // изображения идентичны
        assertEquals(savedImage.getWidth(), sourceImage.getWidth());
        assertEquals(savedImage.getHeight(), sourceImage.getHeight());
        assertEquals(savedImage.getType(), sourceImage.getType());

        assertTrue(compareImages(savedImage, sourceImage));
    }

    // сравнивает два BufferedImage попиксульно
    // спасибо http://stackoverflow.com/a/29886786/4728425
    /**
     * Compares two images pixel by pixel.
     *
     * @param imgA - the first image.
     * @param imgB - the second image.
     * @return whether the images are both the same.
     */
    public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
        // The images mush be the same size.
        if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            int width = imgA.getWidth();
            int height = imgA.getHeight();

            // Loop over every pixel.
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Compare the pixels for equality.
                    if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}