package designPatterns.observer.sample.hard;

import java.util.Collection;

public class StivenPupkin extends AbstractCandidate implements Candidate {

    public StivenPupkin() {
        technologies.add("J2SE");
        technologies.add("Android");
    }

    @Override
    public void haveANew(Collection<Vacancy> vacancies) {
        System.out.println("StivenPupkin: Nice! New vacancies:");
        for (Vacancy vacancy : vacancies) {
            System.out.println("\t" + vacancy.toString());
        }
    }
}