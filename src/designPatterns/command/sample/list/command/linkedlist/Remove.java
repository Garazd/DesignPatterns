package designPatterns.command.sample.list.command.linkedlist;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.LinkedListReceiver;

public class Remove implements Command {

    private LinkedListReceiver receiver;

    public Remove(LinkedListReceiver receiver) {
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

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == receiver.getFirst()) {
            receiver.setFirst(node.next);
        }
        if (node == receiver.getLast()) {
            receiver.setLast(node.prev);
        }

        return node.value;
    }
}