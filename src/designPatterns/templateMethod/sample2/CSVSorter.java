package designPatterns.templateMethod.sample2;

// но что, если мы немного усложним?
// допустим нам на вход приходит не массив, а строка разделенная разделителем
// и на выходе мы должны посортированный массив так же вернуть как строчку
// при этом дадим возможность клиенту заменить символ-разделителя
public abstract class CSVSorter {

    private static final String DEFAULT_SEPARATOR = ",";

    // тут вся основная логика
    // final чтобы не переопределял никто из клиентов наш шаблонный метод
    public final String sort(String input) {
        Object[] array = split(input, getInputSeparator());
        Object[] sorted = sort(array);

        return join(sorted, getOutputSeparator());
    }

    // мы даем возможность заменить клиенту этот код, но если не заменит
    // будет разделитель по-умолчанию
    protected String getInputSeparator() {
        return DEFAULT_SEPARATOR;
    }
    protected String getOutputSeparator() {
        return DEFAULT_SEPARATOR;
    }

    // а это мы не даем переопределять, потому что у нас класс работает с
    // CSV форматом, а не JSON'ом
    private Object[] split(String input, String separator) {
        return input.split("\\Q" + separator + "\\E");
    }

    private String join(Object[] objects, String separator) {
        StringBuffer result = new StringBuffer();
        for (int index = 0; index < objects.length; index++) {
            Object object = objects[index];
            result.append(object);
            // в конце разделитель не ставим
            if (index < objects.length - 1) {
                result.append(separator);
            }
        }
        return result.toString();
    }

    // это алгоритм сортировки
    // он по-умолчанию и его можно переопределить, если не лень :)
    protected Object[] sort(Object[] input) {
        Object[] result = new Object[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
        }

        for (int c = 0; c < input.length - 1; c++) {
            for (int d = 0; d < input.length - c - 1; d++) {
                if (compare(result[d], result[d + 1])) {
                    Object swap = result[d];
                    result[d]   = result[d+1];
                    result[d+1] = swap;
                }
            }
        }
        return result;
    }

    // а тут "сдулись" и говорим клиенту пусть сам решит как сортировать
    protected abstract boolean compare(Object o1, Object o2);
}