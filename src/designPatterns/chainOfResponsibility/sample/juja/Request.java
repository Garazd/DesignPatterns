package designPatterns.chainOfResponsibility.sample.juja;

public class Request {

    // у нас есть разные риквесты
    public enum Type {
        SPAM, BUG_REPORT, LEAD, PAYMENT, TRAINEE, NEW_IDEA, UNKNOWN;
    }

    // а это инфа, которую мы получаем от клиента
    private String message;
    private Type type;
    private String name;
    private int amount;
    private int debt;

    // в самом начале клиент делится с нами текстовым сообщением
    // а мы парсим его, уточняя детали
    public Request(String message) {
        System.out.println("Q: " + message);
        this.message = message;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        if (name != null) {
            result.append(name).append(": ").append(message).append('\n');
        } else {
            result.append("anonym: ").append(message).append('\n');
        }
        result.append("Type: ").append(type.name().toUpperCase()).append('\n');
        if (amount > 0 || debt > 0) {
            result.append("Amount: ").append(amount).append('\n');
            result.append("Debt: ").append(debt).append('\n');
        }
        return result.toString();
    }
}