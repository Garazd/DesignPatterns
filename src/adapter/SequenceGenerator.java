package adapter;

public class SequenceGenerator {

    private Generator generator;

    public SequenceGenerator(Generator generator) {
        super();
        this.generator = generator;
    }

    public int[] generate(int length) {
        int result[] = new int[length];

        for (int i=0; i<length; i++) {
            result[i] = generator.next();
        }
        return result;
    }
}