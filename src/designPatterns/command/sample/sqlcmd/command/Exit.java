package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.View;

public class Exit implements Command {

    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals(format());
    }

    @Override
    public String description() {
        return "Выход из программы";
    }

    @Override
    public String format() {
        return "exit";
    }

    @Override
    public void process(String command) {
        view.write("До скорой встречи!");
        throw new ExitException();
    }
}