package designPatterns.observer.sample.hard;

import java.util.Collection;

public interface Candidate {
    
    // кандидат умеет получать уведомления о вакансиях
	void haveANew(Collection<Vacancy> vacancies);
}