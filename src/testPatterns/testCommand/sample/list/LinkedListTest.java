package testPatterns.testCommand.sample.list;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.LinkedListReceiver;
import designPatterns.command.sample.list.command.linkedlist.*;

public class LinkedListTest extends ListTest {

    // наш приемник содержащий массив
    LinkedListReceiver receiver = new LinkedListReceiver();

    @Override
    protected Command getAddCommand() {
        return new Add(receiver);
    }

    @Override
    protected Command getToStringCommand() {
        return new ToString(receiver);
    }

    @Override
    protected Command getSizeCommand() {
        return new Size(receiver);
    }

    @Override
    protected Command getIsEmptyCommand() {
        return new IsEmpty(receiver);
    }

    @Override
    protected Command getGetCommand() {
        return new Get(receiver);
    }

    @Override
    protected Command getRemoveCommand() {
        return new Remove(receiver);
    }

    // тест (тот что template method) занаследуем от родителя
}