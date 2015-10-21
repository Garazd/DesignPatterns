package designPatterns.command.sample.sqlcmd.command;

import designPatterns.command.sample.sqlcmd.View;

public class Unsupported extends Processor {

    private View view;

    public Unsupported(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return true;
    }

    @Override
    public void process(String command) {
        view.write("Несуществующая команда: " + command);
    }
}