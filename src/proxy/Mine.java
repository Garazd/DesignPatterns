package proxy;

public class Mine extends Cell {

    public Mine(int left, int top) {
        super(left, top);

        // Heavy load cell image c mine
    }

    @Override
    public int getPoints() {
        return 100;   // 100 points for the open mine
    }
}
