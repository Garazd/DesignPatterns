package designPatterns.command.sample.list.command.array;

import designPatterns.command.sample.list.ArrayReceiver;
import designPatterns.command.sample.list.Command;

public class Size implements Command {

    private ArrayReceiver receiver;

    public Size(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        return receiver.size();
    }
}