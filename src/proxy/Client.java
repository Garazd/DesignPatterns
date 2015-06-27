package proxy;

public class Client {
    public static void main(String[] args) {
        Cell cells[][] = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (i + j % 2 == 0) {
                    cells[i][j] = new MineProxy(i, j);
                } else {
                    cells[i][j] = new EmptyProxy(i, j);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j].open();
            }
        }
    }
}