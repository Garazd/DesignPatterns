package designPatterns.factoryMethod.sample.imageReader;

// класс-запускатор
public class Main {

    public static void main(String[] args) {
        Loader loader = new GrayScaleImageLoader();
        //Loader loader = new ColorImageLoader();

        // наш клиент
        Client client = new Client();

        // делаем с рисунком, что там надо
        client.process(Main.class.getResource("/uml1_2.png").getPath(), loader);
    }
}