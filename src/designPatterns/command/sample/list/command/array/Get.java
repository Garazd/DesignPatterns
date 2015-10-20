package designPatterns.command.sample.list.command.array;

import designPatterns.command.sample.list.ArrayReceiver;
import designPatterns.command.sample.list.Command;

public class Get implements Command {

    private ArrayReceiver receiver;

    public Get(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof Integer)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        Integer index = (Integer)args[0];

        return receiver.get(index);
    }
}