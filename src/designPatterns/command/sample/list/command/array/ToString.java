package designPatterns.command.sample.list.command.array;

import designPatterns.command.sample.list.ArrayReceiver;
import designPatterns.command.sample.list.Command;

public class ToString implements Command {

    private ArrayReceiver receiver;

    public ToString(ArrayReceiver receiver) {
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

        for (int index = 0; index < receiver.size(); index++) {
            result.append(receiver.get(index));
            if (index != receiver.size() - 1) {
                result.append(", ");
            }
        }

        result.append(']');
        return result.toString();
    }
}