package proxy;

public class Empty extends Cell {

    public Empty(int left, int top) {
        super(left, top);

        // Download large image empty cell
    }

    @Override
    public int getPoints() {
        return 10;  // 10 points for open an empty cell
    }
}