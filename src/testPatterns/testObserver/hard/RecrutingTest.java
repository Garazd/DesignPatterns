package testPatterns.testObserver.hard;

import designPatterns.observer.sample.hard.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RecrutingTest {

    // внутренний клас-кандидат всего лишь сохраняет вакансию. 
    // так позже проверят информаровали ли кандидата
    class SomeCandidate implements Candidate {

        // внутренний клас-кандидат всего лишь сохраняет вакансию. 
        // так позже проверят информаровали ли кандидата
        Vacancy vacancy;
        
        @Override
        // когда кандидата уведомят о новой вакансии, он ее сохранят
        public void haveANew(Collection<Vacancy> vacancies) {
            assertEquals("Ожидается одна вакансия", 1, vacancies.size());
            this.vacancy = vacancies.iterator().next();
        }
    }
    
    // а этот внутренний клас-кандидат сохраняет ВСЕ ваканси в список 
    // так позже можно будет проверить как именно информаровали кандидата
    class VacanciesRecorder implements Candidate {

        List<Vacancy> vacancies = new LinkedList<Vacancy>();
        
        @Override
        // когда кандидата уведомляют о вакансиях, он их сохраняет
        public void haveANew(Collection<Vacancy> vacancies) {
           this.vacancies.addAll(vacancies);
        }
    }
    
    // а этот внутренний клас-кандидат удаляет ВСЕ ваканси из списка, которй ему вручает  
    // рекрутер в надежде на то, что его шансы попасть на собеседование возрастут  
    class VacanciesEraser implements Candidate {
        
        Collection<Vacancy> vacancies = null;
        
        @Override
        // когда кандидата уведомляют о вакансиях, он их удаляет
        public void haveANew(Collection<Vacancy> vacancies) {
            this.vacancies = vacancies; 
        }
        
        public void clearVacanсiesList() {
            vacancies.clear();
        }
    }    
    
    // вакансия, которая подойдет всем кандидатам - пустая
    class EmptyVacancy implements Vacancy {        
        
		@Override
	    // ей все подходит!
		public boolean check(Set<String> technologies) {
			return true;
		}
    }
    
    // вакансия, с заданным списком технологий
    class ConcreteVacancy implements Vacancy {        
        
        private Set<String> technologies;

        // вакансия создается для конкретного списка технологий
        public ConcreteVacancy(String...technologies) {
            this.technologies = new HashSet<String>(Arrays.asList(technologies));
        }
        
		@Override
		// только если весь список совпадает - тогда нас утраивает
		public boolean check(Set<String> technologies) {
			return this.technologies.containsAll(technologies);
		}
    }    
    
    // резюме кандидата, который что-то знает
    class CandidateResume extends FresherResume implements Resume {

        private HashSet<String> technologies;

        // сохраняем имя кандидата и список технологий ему известных
        public CandidateResume(Candidate candidate, String...technologies) {
            super(candidate);
            this.technologies = new HashSet<String>(Arrays.asList(technologies));
        }
        
        @Override
        // в ответ на список технологий мы скажем что знаем 
        public Set<String> getTechnologies() {
            return technologies;
        }
    }
    
    // это резюме кандидата, который ничего не знает
    class FresherResume implements Resume {

        // тут будем хранить кандидата 
        private Candidate candidate;

        // кандидат вписывается в резюме в момент его создания  
        public FresherResume(Candidate candidate) {
            this.candidate = candidate;
        }
        
        @Override
        // вернем кандидата если спросят
        public Candidate getCandidate() {
            return candidate;
        }

        @Override
        // в ответ на список технологий мы скажем что ничего не знаем 
        public Set<String> getTechnologies() {
            return new HashSet<String>();
        }
    }
    
    @Test
    // проверяем что зарегистрированный кандидат получит уведомление 
    public void testRegisterAndNotify() {
        // есть некий ректрутинг департамент 
        Recruiter recruiter = new RecruitingDepartment();

        // есть ты - потенциальный кандидат.
        SomeCandidate candidate = new SomeCandidate();

        // мы регистрируемся у рекрутера
        recruiter.register(new FresherResume(candidate));

        // а теперь рекрутеру упала новая вакансия
        Vacancy someVacancy = new EmptyVacancy();        
        recruiter.addNew(someVacancy);
        
        // тут же оповещаем об этом
        recruiter.notice();

        // вот тут мы и проверяем, как отработал наш рекрутинг
        assertSame("Кандидат не был информирован о новой вакансии",
                someVacancy, candidate.vacancy);
    }
    
    @Test
    // проверяем что все зарегистрированные кандидаты получают уведомления
    public void testRegisterAndNotifyAll() {
        // есть некий ректрутинг департамент 
        Recruiter recruiter = new RecruitingDepartment();

        // один потенциальный кандидат.
        SomeCandidate candidate1 = new SomeCandidate();
        
        // второй потенциальный кандидат.
        SomeCandidate candidate2 = new SomeCandidate();

        // оба кандидата регистрируются у рекрутера
        recruiter.register(new FresherResume(candidate1));
        recruiter.register(new FresherResume(candidate2));

        // а теперь рекрутеру упала новая вакансия
        Vacancy someVacancy = new EmptyVacancy();        
        recruiter.addNew(someVacancy);

        // тут же оповещаем об этом
        recruiter.notice();
        
        // вот тут мы и проверяем, как отработал наш рекрутинг
        assertSame("Первый кандидат не был информирован о новой вакансии",
                someVacancy, candidate1.vacancy);        
        assertSame("Второй кандидат не был информирован о новой вакансии",
                someVacancy, candidate2.vacancy);
    }
    
    @Test
    // проверяем что удаленный кандидат перестает получать уведомление
    public void testUnregisterCandidate() {
        // все тот же ректрутинг департамент 
        Recruiter recruiter = new RecruitingDepartment();

        // кандидат
        SomeCandidate candidate = new SomeCandidate();
        
        // регистрируемся у рекрутера
        recruiter.register(new FresherResume(candidate));        
        
        // и тут же передумываем
        recruiter.remove(candidate);
        
        // рекрутеру упала новая вакансия
        Vacancy someVacancy = new EmptyVacancy();        
        recruiter.addNew(someVacancy);
        
        // тут же оповещаем об этом
        recruiter.notice();
        
        // а кандидат ничего и не узнал
        assertNull("Кандидат получил уведомление, а не должен был",
                candidate.vacancy);        
    }
    
    @Test
    // проверяем, что после удаления перестает получать уведомление только 
    // удаленный кандидат
    public void testUnregisterOnlyOneCandidate() {
        // есть некий ректрутинг департамент 
        Recruiter recruiter = new RecruitingDepartment();

        // раз кандидат
        SomeCandidate candidate1 = new SomeCandidate();
        
        // два кандидат
        SomeCandidate candidate2 = new SomeCandidate();

        // оба регистрируются
        recruiter.register(new FresherResume(candidate1));
        recruiter.register(new FresherResume(candidate2));
        
        // один передумал
        recruiter.remove(candidate1);

        // тем временем рекрутеру упала новая вакансия
        Vacancy someVacancy = new EmptyVacancy();        
        recruiter.addNew(someVacancy);
        
        // тут же оповещаем об этом
        recruiter.notice();
        
        // второго проинформировали
        assertSame("Второй кандидат не был информирован о новой вакансии, хотя подписан",
                someVacancy, candidate2.vacancy);
        
        // а первый остался в неведении
        // assertNull("Первый кандидат после исключения из расписки не должен " +
        //         "был получать уведомление, а получил", 
        //         candidate1.vacancy);
        // но мы это проверять не будем, потому как у нас уже есть тест на этот случай
        // повторяться в коде - плохая примета.         
    }
    
    @Test
    // проверяем что зарегистрированный кандидат получит уведомление 
    // но только по новым вакансиям 
    public void testNotifyOnlyWithNewVacancies() {
        // все как обычно 
        Recruiter recruiter = new RecruitingDepartment();
        VacanciesRecorder candidate = new VacanciesRecorder();
        recruiter.register(new FresherResume(candidate));

        // рекрутеру упала новая вакансия и тут же информируем       
        recruiter.addNew(new EmptyVacancy());
        recruiter.notice();

        // очищаем список сохраненный у кандидата
        candidate.vacancies.clear();
        
        // позже упали две вакансии и тут же информируем
        Vacancy someVacancy1 = new EmptyVacancy();        
        recruiter.addNew(someVacancy1);        
        Vacancy someVacancy2 = new EmptyVacancy();        
        recruiter.addNew(someVacancy2);        
        recruiter.notice();
        
        // вот тут мы и проверяем, что получили новости
        assertEquals("Кандидат должен был быть информарован двумя вакансиями",
                2, candidate.vacancies.size());
        assertTrue("Кандидат был информирован не о новых вакансиях",
                candidate.vacancies.contains(someVacancy1));
        assertTrue("Кандидат был информирован не о новых вакансиях",
                candidate.vacancies.contains(someVacancy2));        
    }
    
    @Test
    // проверяем что новенький кандидат получит уведомление 
    // по всем вакансиям, которые когда либо были добавлены в системе
    // даже если они уже высылались его коллегам
    public void testNotifyAllVacanciesForEachNewCandidate() {
        // все как обычно 
        Recruiter recruiter = new RecruitingDepartment();
        recruiter.register(new FresherResume(new VacanciesRecorder()));

        // рекрутеру упала новая вакансия. тут же информируем       
        Vacancy someVacancy1 = new EmptyVacancy();
        recruiter.addNew(someVacancy1);
        recruiter.notice();

        // но тут зарегистрировался еще один кандидат. 
        VacanciesRecorder candidate = new VacanciesRecorder();
        recruiter.register(new FresherResume(candidate));
        
        // и после упали еще две вакансии.
        Vacancy someVacancy2 = new EmptyVacancy();        
        recruiter.addNew(someVacancy2);        
        Vacancy someVacancy3 = new EmptyVacancy();        
        recruiter.addNew(someVacancy3);                

        // информируем всех
        recruiter.notice();
        
        // проверяем, что наш новенький кандидат получил все "до копеечки"
        assertEquals("Кандидат должен был быть информарован тремя вакансиями",
                3, candidate.vacancies.size());
        assertTrue("Кандидат был информирован не о всех вакансиях",
                candidate.vacancies.contains(someVacancy1));
        assertTrue("Кандидат был информирован не о всех вакансиях",
                candidate.vacancies.contains(someVacancy2));
        assertTrue("Кандидат был информирован не о всех вакансиях",
                candidate.vacancies.contains(someVacancy3));
    }
    
    @Test 
    // Никто из кандидатов нe может влиять на списки рекрутера
    public void testDoNotFixRecruterList() {
        Recruiter recruiter = new RecruitingDepartment();
        
        // первый кандидант - хитрый, он удаляет все, что ему попадается в руки 
        VacanciesEraser candidate1 = new VacanciesEraser();
        recruiter.register(new FresherResume(candidate1));       
      
        // появилась вакансия, тут же оповестили
        Vacancy someVacancy = new EmptyVacancy();        
        recruiter.addNew(someVacancy);             
        recruiter.notice();
        
        // появился второй кандидант
        VacanciesRecorder candidate2 = new VacanciesRecorder();
        recruiter.register(new FresherResume(candidate2));
        
        // но тут злостный кандидат почистил список!
        candidate1.clearVacanсiesList();
        
        // прошла вторая фаза уведомления
        recruiter.notice();        
        
        // проверяем, что наш новый кандидат получил все - справедливость восторжествовала
        assertEquals("Кандидат должен был быть информарован вакансией",
                1, candidate2.vacancies.size());
        assertTrue("Кандидат был информирован не о той вакансии",
                candidate2.vacancies.contains(someVacancy));        
    }
    
    @Test
    public void testFilteringCandidatesByVacationTechnologies() {
        Recruiter recruiter = new RecruitingDepartment();
        
        VacanciesRecorder javaEECandidate = new VacanciesRecorder();
        recruiter.register(new CandidateResume(javaEECandidate, "Java", "SQL", "Hibernate", "XML"));
        
        VacanciesRecorder phpCandidate = new VacanciesRecorder();
        recruiter.register(new CandidateResume(phpCandidate, "PHP"));                
        
        Vacancy javaEEVacancy = new ConcreteVacancy("Java", "SQL", "XML", "Hibernate");        
        recruiter.addNew(javaEEVacancy);
        
        Vacancy pnpVacancy = new ConcreteVacancy("PHP");        
        recruiter.addNew(pnpVacancy);
        
        Vacancy fresherVacancy = new EmptyVacancy();        
        recruiter.addNew(fresherVacancy);
        
        recruiter.notice();
        
        assertEquals(2, javaEECandidate.vacancies.size());
        assertTrue(javaEECandidate.vacancies.contains(javaEEVacancy));        
        assertTrue(javaEECandidate.vacancies.contains(fresherVacancy));
        
        assertEquals(2, phpCandidate.vacancies.size());
        assertTrue(phpCandidate.vacancies.contains(pnpVacancy));        
        assertTrue(phpCandidate.vacancies.contains(fresherVacancy));
    }
}