package designPatterns.abstractFactory;

interface Button {
    void createButton();
}

interface Label {
    void createLabel();
}

interface AbstractFactory {
    Button createButton();
    Label createLabel();
}










