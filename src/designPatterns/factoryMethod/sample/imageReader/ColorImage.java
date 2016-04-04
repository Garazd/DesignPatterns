package designPatterns.factoryMethod.sample.imageReader;

import java.awt.image.BufferedImage;

// это ProductB
public class ColorImage extends Image {

    public ColorImage(BufferedImage image) {
        super(image);
    }

    // тут может быть что-то полезное для работы именно с этим форматом

    // но клиент увидит только то что объявлено в Image
}