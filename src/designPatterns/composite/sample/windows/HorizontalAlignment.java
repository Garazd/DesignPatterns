package designPatterns.composite.sample.windows;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

// этот контейнер-компоновщик компонует окна горизонтально в ряд
public class HorizontalAlignment extends Frame {

    // сложная функция отрисовки рисует рамочку вокруг всех дочерних окон,
    // расположенных горизонтально в ряд
    @Override
    public String draw() {
        int maxWidth = width();
        int maxHeight = height();
        
        List<String> windows = new LinkedList<String>();         
        for (Window component : this.windows) {
            windows.add(component.draw());
        }
        
        StringBuffer result = new StringBuffer();
        result.append('┌').append(StringUtils.leftPad("", maxWidth - 2, "─")).append('┐').append('\n');
        
        int line = 0;
        while (line + 2 < maxHeight) {
            result.append('│');
            for (String window : windows) {
                String[] lines = window.split("\n");
                if (line < lines.length) {
                    result.append(lines[line]);
                } else {
                    result.append(StringUtils.leftPad("", lines[0].length(), " "));
                }
            }
            result.append('│').append('\n');
            line++;
        }   
        result.append('└').append(StringUtils.leftPad("", maxWidth - 2, "─")).append('┘').append('\n');
        
        return result.toString();
    }

    // высота и ширина считаются соответственно
    @Override
    public int width() {
        int result = 0;
        for (Window component : windows) {
            result += component.width();
        }
        return result + 2;
    }

    @Override
    public int height() {
        int result = 0;
        for (Window component : windows) {
            result = Math.max(result, component.height());
        }
        return result + 2;
    }
}