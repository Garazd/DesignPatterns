package designPatterns.composite.classic.case2;

// клиент
public class Main {
    
    public static void main(String[] args) {
        // тут заметь у нас "Component root = ",
        // а в прошлом примере было "Composite root = "
        Component root = new Composite();    
        
        root.add(new Leaf("one"));
        
        Component composite2 = new Composite();    
        root.add(composite2);
        
        composite2.add(new Leaf("two"));
        composite2.add(new Leaf("three"));
        
        root.add(new Leaf("four"));
        composite2.add(new Leaf("five"));
        
        Component composite3 = new Composite();    
        root.add(composite3);
        
        composite3.add(new Leaf("six"));
        composite3.add(new Leaf("seven"));
        
        Component composite4 = new Composite();    
        composite2.add(composite4);
        
        composite4.add(new Leaf("eight"));
        
        System.out.println(root.operation1("data1"));
        // вывод:
        // [one.op1(data1), [two.op1(data1), three.op1(data1), five.op1(data1), [eight.op1(data1)]], four.op1(data1), [six.op1(data1), seven.op1(data1)]]

        System.out.println(root.operation2("data2"));
        // вывод:
        // [one.op2(data2), [two.op2(data2), three.op2(data2), five.op2(data2), [eight.op2(data2)]], four.op2(data2), [six.op2(data2), seven.op2(data2)]]

        // вот ради чего все делалось!
        System.out.println(root.get(1).get(1).operation1("data3"));
        // вывод:
        // three.op1(data3)
        // в прошлом примере этого бы у нас не получилось
    }
}