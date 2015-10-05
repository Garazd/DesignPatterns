package designPatterns.iterator.classic;

public class Main {

    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(5);

        aggregate.set(0, "one");
        aggregate.set(1, "two");
        aggregate.set(2, "three");
        aggregate.set(3, "four");
        aggregate.set(4, "five");

        printAggregate(aggregate);
    }

    private static void printAggregate(Aggregate aggregate) {
        Iterator<String> iterator = aggregate.createIterator();

        while (!iterator.isDone()) {
            String value = iterator.currentItem();
            System.out.println(value);

            iterator.next();
        }
    }
}