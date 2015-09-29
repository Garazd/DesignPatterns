package designPatterns.strategy.sample;

public class BubbleSorter {

    private Comparator comparator;

    public BubbleSorter(Comparator comparator) {
        this.comparator = comparator;
    }

    public Object[] sort(Object[] input) {
        Object[] result = new Object[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
        }

        for (int c = 0; c < input.length - 1; c++) {
            for (int d = 0; d < input.length - c - 1; d++) {
                if (comparator.compare(result[d], result[d+1])) {
                    Object swap = result[d];
                    result[d]   = result[d+1];
                    result[d+1] = swap;
                }
            }
        }
        return result;
    }
}