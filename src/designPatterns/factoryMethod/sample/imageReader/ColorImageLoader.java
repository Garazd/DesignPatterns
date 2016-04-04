package designPatterns.factoryMethod.sample.imageReader;

import java.awt.image.BufferedImage;

// это ConcreteCreatorB
public class ColorImageLoader extends Loader {

    @Override
    protected Image createImage(BufferedImage image) {
        // он оборачивает BufferedImage в ColorImage который сохраняет его в полном цвете
        return new ColorImage(image);
    }
}