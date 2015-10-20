package designPatterns.command.sample.list;

import java.util.Arrays;

// а это наш выполнятор, он будет выполнять команды
public class Invoker {
    // он хранит команду как абстракцию
    private Command command;

    // и с ней он агрегат - то есть ее можно заменить в runtime
    // заметил отличие? Я для DSL'ности вернул инвокер
    public Invoker setCommand(Command command) {
        this.command = command;
        return this;
    }

    // а это его единственный метод, его будет дергать клиент
    // мы тут просто чуть поработаем с
    public void doit(Object... args) {
        Object result = command.execute(args);

        System.out.printf("%s%s = %s\n",
                command.getClass().getSimpleName(),
                Arrays.toString(args), result);
    }
}