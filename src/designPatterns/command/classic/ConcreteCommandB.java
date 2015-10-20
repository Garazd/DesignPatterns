package designPatterns.command.classic;

// Вторая команда
public class ConcreteCommandB implements Command {
    private ReceiverB receiver;

    // тоже композит, но с ReceiverB
    public ConcreteCommandB(ReceiverB receiver) {
        this.receiver = receiver;
    }

    @Override
    // она вольна делать со своим Receiver, что пожелает
    // Команда - это контроллер для Receiver
    // но делает что-то одно простое - одну команду
    public Object execute(Object input) {
        receiver.otherMethod(input);
        return "CommandB result";
    }
}