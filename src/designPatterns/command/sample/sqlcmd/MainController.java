package designPatterns.command.sample.sqlcmd;

import designPatterns.command.sample.sqlcmd.command.Command;
import designPatterns.command.sample.sqlcmd.command.ExitException;

public class MainController {

    private DatabaseManager manager;
    private Command[] commands;
    private View view;

    public MainController(View view, DatabaseManager manager, Command... commands) {
        this.view = view;
        this.manager = manager;
        this.commands = commands;
    }

    public void run() {
        try {
            doWork();
        } catch (ExitException e) {
            // do nothing
        }
    }

    private void doWork() {
        view.write("Привет юзер!");
        view.write("Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password");

        while (true) {
            view.write("-->");
            String input = view.read();

            for (Command command : commands) {
                try {
                    if (command.canProcess(input)) {
                        command.process(input);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        throw e;
                    }
                    printError(e);
                    break;
                }
            }
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        Throwable cause = e.getCause();
        if (cause != null) {
            message += " " + cause.getMessage();
        }
        view.write("Неудача! по причине: " + message);
        view.write("Повтори попытку.");
    }
}