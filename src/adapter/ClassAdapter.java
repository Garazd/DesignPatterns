package adapter;

public class ClassAdapter {

    public static void main(String[] args) {

        RandomGeneratorAdapter adapter = new RandomGeneratorAdapter();
        SequenceGenerator generator = new SequenceGenerator(adapter);

        for (int i: generator.generate(10)) {
            System.out.print(i + " ");
        }
    }
}