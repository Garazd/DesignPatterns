package designPatterns.factoryMethod.sample.imageReader;

import java.awt.image.BufferedImage;

// это ConcreteCreatorA
public class GrayScaleImageLoader extends Loader {

    @Override
    public Image createImage(BufferedImage image) {
        // он оборачивает BufferedImage в BlackAndWhiteImage,
        // который сохранит только ЧБ составляющую
        return new GrayScaleImage(image);
    }
}