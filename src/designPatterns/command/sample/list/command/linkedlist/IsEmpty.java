package designPatterns.command.sample.list.command.linkedlist;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.LinkedListReceiver;

public class IsEmpty implements Command {

    private LinkedListReceiver receiver;

    public IsEmpty(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Boolean execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        return receiver.getFirst() == null;
    }
}