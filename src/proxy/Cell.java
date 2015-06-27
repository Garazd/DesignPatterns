package proxy;

public abstract class Cell {

    public static final int OPENED = 0;
    public static final int CLOSED = 1;

    int status, left, top;

    public Cell(int left, int top) {
        this.left = left;
        this.top = top;
        this.status = Cell.CLOSED;
    }

    public void open() {
        this.status = Cell.OPENED;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getStatus() {
        return status;
    }

    public abstract int getPoints();
}