package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.View;

public class Help implements Command {

    private View view;
    private Command[] commands;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("help");
    }

    @Override
    public String description() {
        return "Вывод списка команд";
    }

    @Override
    public String format() {
        return "help";
    }

    @Override
    public void process(String input) {
        view.write("Существующие команды:");
        for (Command command : commands) {
            if (command.format() == null) continue;
            view.write("\t" + command.format());
            view.write("\t\t" + command.description());
        }
    }

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }
}