public class Builder {
    private static String name;
    private static String surname;
    private static String mail;
    private static String phone;
    private static String address;

    Builder(final ConcreteBuilder concreteBuilder) {
        this.name = concreteBuilder.getName();
        this.surname = concreteBuilder.getSurname();
        this.mail = concreteBuilder.getMail();
        this.phone = concreteBuilder.getPhone();
        this.address = concreteBuilder.getAddress();
    }
}

class ConcreteBuilder {
    private static String name;
    private static String surname;
    private static String mail;
    private static String phone;
    private static String address;

    public ConcreteBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public ConcreteBuilder surname(final String surname) {
        this.surname = surname;
        return this;
    }

    public ConcreteBuilder mail(final String mail) {
        this.mail = mail;
        return this;
    }

    public ConcreteBuilder phone(final String phone) {
        this.phone = phone;
        return this;
    }

    public ConcreteBuilder address(final String address) {
        this.address = address;
        return this;
    }

    public static String getName() {
        return name;
    }

    public static String getSurname() {
        return surname;
    }

    public static String getMail() {
        return mail;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getAddress() {
        return address;
    }

    public Builder builder() {
        return new Builder(this);
    }
}

class Contact {
    public static void main(String[] args) {
        final Builder contact = new ConcreteBuilder()
                .name("Vitaliy")
                .surname("Zlenko")
                .mail("test@gmail.com")
                .phone("0123456789")
                .address("test 27")
                .builder();
    }
}