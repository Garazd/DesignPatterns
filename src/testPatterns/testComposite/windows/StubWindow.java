package testPatterns.testComposite.windows;

import designPatterns.composite.sample.windows.Window;
import org.apache.commons.lang3.StringUtils;

public class StubWindow extends Window {

    private char ch;
    private int width;
    private int height;

    public StubWindow(char ch, int width, int height) {
        this.ch = ch;
        this.width = width;
        this.height = height;
    }

    @Override
    public String draw() {
        String result = "";

        for (int i = 0; i < height; i++) {
            result += StringUtils.leftPad("", width, ch) + "\n";
        }

        return result;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}