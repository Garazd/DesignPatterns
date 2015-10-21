package designPatterns.command.sample.sqlcmd.command;

public abstract class Processor implements Command {

    @Override
    public String description() {
        return null;
    }

    @Override
    public String format() {
        return null;
    }
}