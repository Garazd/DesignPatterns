package designPatterns.command.classic;

// второй приемник c одним единственным методом
public class ReceiverB {

    public void otherMethod(Object input) {
        System.out.println("ReceiverB got a: " + input);
    }
}