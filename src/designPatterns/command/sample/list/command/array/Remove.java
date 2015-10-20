package designPatterns.command.sample.list.command.array;

import designPatterns.command.sample.list.ArrayReceiver;
import designPatterns.command.sample.list.Command;

public class Remove implements Command {

    private ArrayReceiver receiver;

    public Remove(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof Integer)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        Integer index = (Integer)args[0];

        String old = receiver.get(index);
        for (int i = index + 1; i < receiver.size(); i++) {
            receiver.set(i - 1, receiver.get(i));
        }
        receiver.copyOf(receiver.size() - 1);

        return old;
    }
}