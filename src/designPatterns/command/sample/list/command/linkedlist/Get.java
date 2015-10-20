package designPatterns.command.sample.list.command.linkedlist;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.LinkedListReceiver;

public class Get implements Command {

    private LinkedListReceiver receiver;

    public Get(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof Integer)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        Integer index = (Integer)args[0];

        int i = 0;
        LinkedListReceiver.Node node = receiver.getFirst();
        while (i != index) {
            i++;
            node = node.next;
        }

        return node.value;
    }
}