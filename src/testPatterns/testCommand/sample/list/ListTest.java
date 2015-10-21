package testPatterns.testCommand.sample.list;

import designPatterns.command.sample.list.Command;
import designPatterns.command.sample.list.Invoker;
import org.junit.Test;
import testPatterns.testCommand.ConsoleMock;

import static org.junit.Assert.assertEquals;

public abstract class ListTest {

    // мокаем консольку
    private ConsoleMock console = new ConsoleMock();

    // а помнишь, что template method + test = contract test
    protected abstract Command getAddCommand();
    protected abstract Command getToStringCommand();
    protected abstract Command getSizeCommand();
    protected abstract Command getIsEmptyCommand();
    protected abstract Command getGetCommand();
    protected abstract Command getRemoveCommand();

    // а это наш тест-template-method
    @Test
    public final void test() {
        // given

        // наши алгоритмы работы с приемником
        // мы их спрашиваем у наследника, который укажет что именно мы тестим
        // благо у них интерфейс одинаковый
        Command add = getAddCommand();
        Command toString = getToStringCommand();
        Command size = getSizeCommand();
        Command isEmpty = getIsEmptyCommand();
        Command get = getGetCommand();
        Command remove = getRemoveCommand();
        // а наш приемник объявлен в наследниках,
        // потому что у обоих приемниках различные интерфейсы

        // наш выполнятор
        Invoker invoker = new Invoker();

        // when
        invoker.setCommand(isEmpty).doit();
        invoker.setCommand(add).doit("one");
        invoker.setCommand(add).doit("two");
        invoker.setCommand(add).doit("three");
        invoker.setCommand(toString).doit();
        invoker.setCommand(size).doit();
        invoker.setCommand(isEmpty).doit();
        invoker.setCommand(get).doit(2);
        invoker.setCommand(remove).doit(0);
        invoker.setCommand(remove).doit(1);
        invoker.setCommand(toString).doit();
        invoker.setCommand(add).doit("four");
        invoker.setCommand(add).doit("five");
        invoker.setCommand(add).doit("six");
        invoker.setCommand(add).doit("seven");
        invoker.setCommand(toString).doit();
        invoker.setCommand(remove).doit(4);
        invoker.setCommand(remove).doit(3);
        invoker.setCommand(remove).doit(0);
        invoker.setCommand(toString).doit();
        invoker.setCommand(add).doit("eight");
        invoker.setCommand(toString).doit();

        // then
        assertEquals("IsEmpty[] = true\n" +
                "Add[one] = 0\n" +
                "Add[two] = 1\n" +
                "Add[three] = 2\n" +
                "ToString[] = [one, two, three]\n" +
                "Size[] = 3\n" +
                "IsEmpty[] = false\n" +
                "Get[2] = three\n" +
                "Remove[0] = one\n" +
                "Remove[1] = three\n" +
                "ToString[] = [two]\n" +
                "Add[four] = 1\n" +
                "Add[five] = 2\n" +
                "Add[six] = 3\n" +
                "Add[seven] = 4\n" +
                "ToString[] = [two, four, five, six, seven]\n" +
                "Remove[4] = seven\n" +
                "Remove[3] = six\n" +
                "Remove[0] = two\n" +
                "ToString[] = [four, five]\n" +
                "Add[eight] = 2\n" +
                "ToString[] = [four, five, eight]\n",
                console.getOut());
    }
}