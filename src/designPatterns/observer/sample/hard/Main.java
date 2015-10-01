package designPatterns.observer.sample.hard;

public class Main {

    public static void main(String[] args) {
        // наш рекрутинг
        Recruiter recruiter = new RecruitingDepartment();

        // двое кандидатов каждый со своим опытом
        AbstractCandidate candidate1 = new StivenPupkin();
        AbstractCandidate candidate2 = new EvaPupkina();

        // подготовили и отправили резюме рекрутеру
        recruiter.register(candidate1.getResume());
        recruiter.register(candidate2.getResume());

        // рекрутер за день собрал три компании
        recruiter.addNew(new NifNifProject());
        recruiter.addNew(new NafNafProject());
        recruiter.addNew(new NufNufProject());

        // и вечером отправил рассылку
        recruiter.notice();
    }
}