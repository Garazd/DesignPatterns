package proxy;

public class Mine extends Cell {

    public Mine(int left, int top) {
        super(left, top);

        // загружаем тяжелое изображение ячейки c миной
    }

    @Override
    public int getPoints() {
        return 100;   // 100 очков за открытую мину
    }
}
