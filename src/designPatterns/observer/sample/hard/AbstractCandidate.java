package designPatterns.observer.sample.hard;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCandidate implements Candidate {

    protected Set<String> technologies = new HashSet<String>();

    public Resume getResume() {
        return new Resume() {
            @Override
            public Candidate getCandidate() {
                return AbstractCandidate.this;
            }

            @Override
            public Set<String> getTechnologies() {
                return AbstractCandidate.this.technologies;
            }
        };
    }
}