package designPatterns.templateMethod.sample2;

public class Main {

    public static void main(String[] args) {
        CSVSorter sorter = new ToStringLengthCSVSorter();
//        3<sep>6<sep>45<sep>123<sep>456<sep>12345
//        d<sep>y<sep>ds<sep>dsds<sep>sdseee<sep>sekfhseflj
//        true<sep>true<sep>true<sep>false

//        CSVSorter sorter = new FirstLetterCSVSorter();
//        123,12345,3,45,456,6
//        ds,d,dsds,sekfhseflj,sdseee,y
//        false,true,true,true

//        CSVSorter sorter = new CountNumbersCSVSorter(",");
//        12345,123,456,45,3,6
//        sekfhseflj,ds,sdseee,d,dsds,y
//        true,true,false,true

        System.out.println(sorter.sort("123,45,3,6,12345,456"));

        System.out.println(sorter.sort("sekfhseflj,ds,sdseee,d,dsds,y"));

        System.out.println(sorter.sort("true,true,false,true"));
    }
}