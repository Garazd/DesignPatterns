package designPatterns.observer.sample.hard;

import java.util.Set;

public class NufNufProject implements Vacancy {

    @Override
    public boolean check(Set<String> technologies) {
        return technologies.contains("J2SE");
    }

    @Override
    public String toString() {
        return "NufNufProject{'J2SE', trainee}";
    }
}