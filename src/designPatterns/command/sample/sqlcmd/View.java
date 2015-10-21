package designPatterns.command.sample.sqlcmd;

public interface View {

    void write(String message);

    String read();
}