package designPatterns.command.classic;

// первый приемник
// по воле случая содержит два полезных метода
public class ReceiverA {
    public Object method1(Object input) {
        return "Processed by ReceiverA in method 1: " + input;
    }

    public Object method2(Object input) {
        return "Processed by ReceiverA in method 2: " + input;
    }
}