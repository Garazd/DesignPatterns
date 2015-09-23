package designPatterns.factoryMethod;

public class Logger implements ILogger {

    public void log(String message) {
        System.err.println("logging");
    }
}