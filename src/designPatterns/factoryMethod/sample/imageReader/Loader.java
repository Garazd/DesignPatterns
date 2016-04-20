package designPatterns.factoryMethod.sample.imageReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// это наш Creator
public abstract class Loader {

    // это factory method
    public abstract Image createImage(BufferedImage image);

    // a это template method :)
    // метод загрузки рисунков из файлов одинаков для всех типов
    public Image loadImage(String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            return createImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}