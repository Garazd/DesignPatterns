package designPatterns.templateMethod.sample2;

// еще один наследник уточняющий, как проводить сортировку
// а этот решил замахнуться на сам алгорим сортировки и делает ее вставками
// причем работает со своими разделителями
public class ToStringLengthCSVSorter extends CSVSorter {

    @Override
    protected String getInputSeparator() {
        return ",";
    }

    @Override
    protected String getOutputSeparator() {
        return "<sep>";
    }

    @Override
    protected boolean compare(Object o1, Object o2) {
        return o1.toString().length() > o2.toString().length();
    }

    @Override
    protected Object[] sort(Object[] input) {
        for (int i = 1; i < input.length; i++) {
            Object key = input[i];
            int j = i - 1;
            while (j >= 0 && compare(input[j], key)) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }
}