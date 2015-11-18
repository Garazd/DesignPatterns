package designPatterns.composite.sample.windows;

import org.apache.commons.lang3.StringUtils;

// это StringMessage Window(Leaf)
public class StringMessage extends Window {

    // он хранит сообщение
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    // и умеет его печатать в рамочку
    @Override
    public String draw() {
        StringBuffer result = new StringBuffer();
        result.append('┌').append(StringUtils.leftPad("", message.length(), "─")).append('┐').append('\n');
        result.append('│').append(message).append('│').append('\n');
        result.append('└').append(StringUtils.leftPad("", message.length(), "─")).append('┘').append('\n');
        return result.toString();
    }

    // длинна и ширина окна учитывает рамочку торщиной в 1 символ

    @Override
    public int width() {
        return message.length() + 2;
    }

    @Override
    public int height() {
        return 3;
    }
}