package designPatterns.templateMethod.sample;

 // еще один наследник уточняющий, как проводить сортировку
public class ToStringLengthBubbleSorter extends BubbleSorter {

    @Override
    protected boolean compare(Object o1, Object o2) {
        return o1.toString().length() > o2.toString().length();
    }
}