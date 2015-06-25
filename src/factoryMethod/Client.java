package factoryMethod;

public class Client {

    private void someMethodThatLogs(AbstractCreator logCreator)
    {
        Logger logger = logCreator.createLogger();
        logger.log("message");
    }

    public static void main(String[] args) {
        AbstractCreator creator = new ConcreteCreator();
        Client client = new Client();
        client.someMethodThatLogs(creator);
    }
}