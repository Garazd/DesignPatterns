package designPatterns.abstractFactory;

class Application {
    public Application(AbstractFactory factory) {
        Button button = factory.createButton();
        Label label = factory.createLabel();
        button.createButton();
        label.createLabel();
    }
}