package designPatterns.abstractFactory;

class WindowsButton implements Button {
    @Override
    public void createButton() {
        System.out.println("I'm a WindowsButton");
    }
}