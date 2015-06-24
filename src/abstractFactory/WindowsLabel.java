package abstractFactory;

class WindowsLabel implements Label {
    @Override
    public void createLabel() {
        System.out.println("I'm a WindowsLabel");
    }
}