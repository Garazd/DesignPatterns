package designPatterns.command.sample.sqlcmd.command;

public interface Command {

    boolean canProcess(String command);

    void process(String command);

    String description();

    String format();
}