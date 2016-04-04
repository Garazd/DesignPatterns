package designPatterns.factoryMethod.sample.imageReader;

import java.awt.image.BufferedImage;

// это наше абстрактное изображение (Product)
// так как оно основано на BufferedImage то у всех наследников будет общая часть
// нет смысла ее копипастить во все Image и делать Image интерфейсом
public abstract class Image {

    // мало ли наследнику понадобится
    protected BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    // все изображения имеют ширину и высоту

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    // можно прочитать/записать любой его пиксель

    public int get(int x, int y) {
        return image.getRGB(x, y);
    }

    public void set(int x, int y, int color) {
        image.setRGB(x, y, color);
    }

    // ну и мало ли кому-то понадобится что-то больше
    public BufferedImage getImage() {
        return image;
    }
}