package designPatterns.composite.sample.windows;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

// этот контейнер-компоновщик компонует окна вертикально в ряд
public class VerticalAlignment extends Frame {

    // сложная функция отрисовки рисует рамочку вокруг всех дочерних окон,
    // расположенных вертикально в ряд
    @Override
    public String draw() {
        int maxWidth = width();

        List<String> windows = new LinkedList<String>();         
        for (Window component : this.windows) {
            windows.add(component.draw());
        }
        
        StringBuffer result = new StringBuffer();
        result.append('┌').append(StringUtils.leftPad("", maxWidth - 2, "─")).append('┐').append('\n');
        
        for (String window : windows) {
            String[] lines = window.split("\n");
            for (String line : lines) {
                result.append('│').append(line).append(StringUtils.leftPad("", maxWidth - line.length() - 2, " ")).append('│').append('\n');
            }
        }
        result.append('└').append(StringUtils.leftPad("", maxWidth - 2, "─")).append('┘').append('\n');
        
        return result.toString();
    }

    // высота и ширина считаются соответственно

    @Override
    public int width() {
        int result = 0;
        for (Window component : windows) {
            result = Math.max(result, component.width());
        }
        return result + 2;
    }

    @Override
    public int height() {
        int result = 0;
        for (Window component : windows) {
            result += component.height();
        }
        return result + 2;
    }
}