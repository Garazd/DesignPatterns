package designPatterns.templateMethod.sample2;

// наследник сортировщика, который делает сортировку по своему
// он дает возможность определять разделитель через конструктор
public class CountNumbersCSVSorter extends CSVSorter {

    private final String separator;

    public CountNumbersCSVSorter(String separator) {
        this.separator = separator;
    }

    @Override
    protected boolean compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return (s1.length() - s1.replaceAll("[0-9]", "").length()) <
                (s2.length() - s2.replaceAll("[0-9]", "").length());
    }

    @Override
    protected String getInputSeparator() {
        return separator;
    }

    @Override
    protected String getOutputSeparator() {
        return separator;
    }
}