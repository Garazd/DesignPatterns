package designPatterns.command.classic;

// наш конфиг
public class Main {
    public static void main(String[] args) {
        // эти алгоритмы мы хотим как-то run'ать из Invoker
        // но при этом мы не хотим, чтобы Invoker про них знал лично
        ReceiverA receiverA = new ReceiverA();
        ReceiverB receiverB = new ReceiverB();

        // это "как-то" (то, как мы будем выполнять алгоритмы)
        // мы инкапсулируем в команды
        // по одному кейзу использования на 1 команду
        Command commandA = new ConcreteCommandA(receiverA);
        Command commandB = new ConcreteCommandB(receiverB);
        Command commandC = new ConcreteCommandC(receiverA);

        // вот наш запускатор
        Invoker invoker = new Invoker();

        // печать разделителя для красивого вывода (не обращай внимания :))
        printBreak();

        // вставляем в него команду, под видом абстракциии
        invoker.setCommand(commandA);
        // и выполняем
        invoker.doit();
        // Вывод
        // Processed by ReceiverA: data

        printBreak();

        // потом переключили команду
        invoker.setCommand(commandB);
        // и выполнение будет совсем другим
        invoker.doit();
        // Вывод
        // ReceiverB got a: data
        // CommandB result

        printBreak();

        // и так далее
        invoker.setCommand(commandC);
        invoker.doit();
        // Вывод
        // Processed by ReceiverA: Changed in CommandC: data

        printBreak();

        // в любой момент можем вернуть назад
        invoker.setCommand(commandA);
        invoker.doit();
        // Вывод
        // Processed by ReceiverA: data

        printBreak();
    }

    private static void printBreak() {
        System.out.println("--------------------");
    }
}