package factoryMethod;

public class Creator extends AbstractCreator{
    @Override
    public Logger createLogger() {
        Logger logger = new Logger();
        return logger;
    }
}