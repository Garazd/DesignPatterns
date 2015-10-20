package designPatterns.command.sample.list;

// Любая команда будет реализовывать этот интерфейс
public interface Command {
    // что-то сделать с Receiver с заданными параметрами
    Object execute(Object... args);
}