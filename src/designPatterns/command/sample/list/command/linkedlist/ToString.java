package designPatterns.command.sample.list.command.linkedlist;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.LinkedListReceiver;

public class ToString implements Command {

    private LinkedListReceiver receiver;

    public ToString(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        StringBuffer result = new StringBuffer();
        result.append('[');

        LinkedListReceiver.Node node = receiver.getFirst();
        while (node != null) {
            result.append(node.value);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }

        result.append(']');
        return result.toString();
    }
}