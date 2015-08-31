package designPatterns.abstractFactory;

class MacOSLabel implements Label {
    @Override
    public void createLabel() {
        System.out.println("I'm a MacOSLabel");
    }
}