package designPatterns.composite.sample.windows;

// клиент
public class Main {
    
    public static void main(String[] args) {
        Window root = new HorizontalAlignment();    
        
        root.add(new StringMessage("one"));
        
        Window composite2 = new VerticalAlignment();
        root.add(composite2);
        
        composite2.add(new StringMessage("two"));
        composite2.add(new StringMessage("three"));
        
        root.add(new StringMessage("four"));
        composite2.add(new StringMessage("five"));
                                                                    
        Window composite3 = new VerticalAlignment();
        root.add(composite3);
        
        composite3.add(new StringMessage("six"));
        composite3.add(new StringMessage("seven"));
        
        Window composite4 = new VerticalAlignment();
        composite2.add(composite4);
        
        composite4.add(new StringMessage("eight"));

        System.out.println(root.draw());
        // вывод:
        // ┌───────────────────────────────┐
        // │┌───┐┌─────────┐┌────┐┌───────┐│
        // ││one││┌───┐    ││four││┌───┐  ││
        // │└───┘││two│    │└────┘││six│  ││
        // │     │└───┘    │      │└───┘  ││
        // │     │┌─────┐  │      │┌─────┐││
        // │     ││three│  │      ││seven│││
        // │     │└─────┘  │      │└─────┘││
        // │     │┌────┐   │      └───────┘│
        // │     ││five│   │               │
        // │     │└────┘   │               │
        // │     │┌───────┐│               │
        // │     ││┌─────┐││               │
        // │     │││eight│││               │
        // │     ││└─────┘││               │
        // │     │└───────┘│               │
        // │     └─────────┘               │
        // └───────────────────────────────┘
    }
}