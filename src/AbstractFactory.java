interface Button {
    void button();
}

interface Label {
    void label();
}

interface AbstractFactory {
    Button createButton();
    Label createLabel();
}

class WindowsFactory implements AbstractFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }
}

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
