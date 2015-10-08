package designPatterns.templateMethod.sample;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BubbleSorter sorter = new ToStringLengthBubbleSorter();
//        [3, 6, 45, 123, 456, 12345]
//        [d, y, ds, dsds, sdseee, sekfhseflj]
//        [true, true, true, false]

//        BubbleSorter sorter = new FirstLetterBubbleSorter();
//        [123, 12345, 3, 45, 456, 6]
//        [ds, d, dsds, sekfhseflj, sdseee, y]
//        [false, true, true, true]

//        BubbleSorter sorter = new CountNumbersBubbleSorter();
//        [12345, 123, 456, 45, 3, 6]
//        [sekfhseflj, ds, sdseee, d, dsds, y]
//        [true, true, false, true]

        System.out.println(Arrays.toString(sorter.sort(
                new Integer[]{123, 45, 3, 6, 12345, 456})));

        System.out.println(Arrays.toString(sorter.sort(
                new String[]{"sekfhseflj", "ds", "sdseee", "d", "dsds", "y"})));

        System.out.println(Arrays.toString(sorter.sort(
                new Boolean[]{true, true, false, true})));
    }
}