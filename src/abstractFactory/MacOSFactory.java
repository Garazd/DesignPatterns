package abstractFactory;

class MacOSFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Label createLabel() {
        return new MacOSLabel();
    }
}