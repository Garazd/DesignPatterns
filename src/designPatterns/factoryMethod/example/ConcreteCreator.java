package designPatterns.factoryMethod.example;

public class ConcreteCreator extends AbstractCreator{
    @Override
    public Logger createLogger() {
        Logger logger = new Logger();
        return logger;
    }
}