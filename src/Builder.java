public class Builder {
    private static String name;
    private static String surname;
    private static String mail;
    private static String phone;
    private static String address;

    public Builder(final String name,
                   final String surname,
                   final String mail,
                   final String phone,
                   final String address) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }
}