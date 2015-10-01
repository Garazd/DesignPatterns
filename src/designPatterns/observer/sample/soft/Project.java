package designPatterns.observer.sample.soft;

import java.util.*;

public class Project implements Vacancy {

    private Set<String> technologies = new HashSet<String>();
    private String name;

    public Project(String name, String... technologies) {
        this.name = name;
        this.technologies.addAll(Arrays.asList(technologies));
    }

    @Override
    public boolean check(Set<String> technologies) {
        return technologies.containsAll(this.technologies);
    }

    @Override
    public String toString() {
        return String.format("%sProject%s", name, technologies);
    }
}