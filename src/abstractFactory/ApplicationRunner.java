package abstractFactory;

class ApplicationRunner {
    public static void main(String[] args) {
        new Application(createOsSpecificFactory());
    }

    public static AbstractFactory createOsSpecificFactory() {
        String osname = System.getProperty("os.name").toLowerCase();
        if(osname != null && osname.contains("windows"))
            return new WindowsFactory();
        else
            return new MacOSFactory();
    }
}