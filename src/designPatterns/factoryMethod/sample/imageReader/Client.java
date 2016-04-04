package designPatterns.factoryMethod.sample.imageReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Image
    // ни про реализацию Loader - кругом одни абстракции
    public void process(String path, Loader loader) {
        System.out.println("Обабатываем: " + path);

        Image image = loader.loadImage(path);

        // делаем что-то с изображением что душе угодно

        // и сохраняемся
        saveImage(path, image);
    }

    private void saveImage(String path, Image image) {
        try {

            BufferedImage newImage = new BufferedImage(image.getWidth(),
                    image.getHeight(), BufferedImage.TYPE_INT_RGB);
            newImage.createGraphics().drawImage(image.getImage(), 0, 0, Color.WHITE, null);

            File output = new File(path + ".jpeg");
            ImageIO.write(newImage, "jpeg", output);

            System.out.println("Сохранено в: " + output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}