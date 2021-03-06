package designPatterns.factoryMethod.example;

public abstract class AbstractCreator {

    public abstract Logger createLogger();

    public Logger getLogger() {
        Logger logger = createLogger();
        return logger;
    }
}