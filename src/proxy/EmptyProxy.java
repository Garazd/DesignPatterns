package proxy;

public class EmptyProxy extends Cell {
    private Empty proxy; // ссылка на пустую ячейку

    public EmptyProxy(int left, int top) {
        super(left, top);
        this.proxy = null;
    }

    @Override
    public void open() {
        if (proxy == null) {
            proxy = new Empty(left, top);
        }

        proxy.open();
    }

    @Override
    public int getLeft() {
        if (proxy == null) {
            return left;
        } else {
            return proxy.getLeft();
        }

    }

    @Override
    public int getTop() {
        if (proxy == null) {
            return top;
        } else {
            return proxy.getTop();
        }
    }

    @Override
    public int getStatus() {
        if (proxy == null) {
            return status;
        } else {
            return proxy.getStatus();
        }
    }

    @Override
    public int getPoints() {
        if (proxy == null) {
            return 10;
        } else {
            return proxy.getPoints();
        }
    }
}