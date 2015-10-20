package designPatterns.command.sample.list;

import designPatterns.command.sample.list.command.linkedlist.Add;
import designPatterns.command.sample.list.command.linkedlist.Get;
import designPatterns.command.sample.list.command.linkedlist.IsEmpty;
import designPatterns.command.sample.list.command.linkedlist.Remove;
import designPatterns.command.sample.list.command.linkedlist.Size;
import designPatterns.command.sample.list.command.linkedlist.ToString;

public class MainLinkedList {
    public static void main(String[] args) {
        // в его основе лежит двусвязный список
        // я вот тут немного наметил маршрут

        // наш приемник содержащий массив
        LinkedListReceiver linkedList = new LinkedListReceiver();

        // наши алгоритмы работы с приемником
        Command add = new Add(linkedList);
        Command toString = new ToString(linkedList);
        Command size = new Size(linkedList);
        Command isEmpty = new IsEmpty(linkedList);
        Command get = new Get(linkedList);
        Command remove = new Remove(linkedList);

        // наш выполнятор
        Invoker invoker = new Invoker();

        // и то, как мы им пользуемся
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
        // Вывод
        // IsEmpty[] = true
        // Add[one] = 0
        // Add[two] = 1
        // Add[three] = 2
        // ToString[] = [one, two, three]
        // Size[] = 3
        // IsEmpty[] = false
        // Get[2] = three
        // Remove[0] = one
        // Remove[1] = three
        // ToString[] = [two]
        // Add[four] = 2
        // Add[five] = 3
        // Add[six] = 4
        // Add[seven] = 5
        // ToString[] = [two, four, five, six, seven]
        // Remove[4] = seven
        // Remove[3] = six
        // Remove[0] = two
        // ToString[] = [four, five]
        // Add[eight] = 3
        // ToString[] = [four, five, eight]

        // TODO домашка - реализовать все остальные команды List
        // Remove(Object o) Удаляющий первый найденный элемент, который и вернет
        // Contains(Object o) проверяющий есть ли такой объект в нашем ArrayReceiver
        // Iterator() возвращающий объект итератор, йаху!
        // Clear() очищающий весь массив
        // Set(Integer index, String o) изменяюзий элемент в заданной позиции (старый возвращаем)
        // Add(Integer index, String o) вставляющий элемент в заданную позицию
        // IndexOf(Object o) должен вернуть индекс искомого элемента, или -1 если не найдено
    }
}