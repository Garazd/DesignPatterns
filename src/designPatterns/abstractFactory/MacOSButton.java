package designPatterns.abstractFactory;

class MacOSButton implements Button {
    @Override
    public void createButton() {
        System.out.println("I'm a MacOSButton");
    }
}