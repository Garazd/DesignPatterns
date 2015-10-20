package designPatterns.command.classic;

// Главная абстракция, за которой мы прячем любой Receiver от Invoker
public interface Command {
    Object execute(Object input);
}