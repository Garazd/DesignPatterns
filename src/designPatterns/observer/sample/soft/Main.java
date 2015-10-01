package designPatterns.observer.sample.soft;

public class Main {

    public static void main(String[] args) {
        // наш рекрутинг
        Recruiter recruiter = new RecruitingDepartment();

        System.out.println("------- Day1 -------");

        // двое кандидатов каждый со своим опытом
        Candidate candidate1 = new CandidateImpl("Eva Pupkina", "J2EE");
        Candidate candidate2 = new CandidateImpl("Stiven Pupkin", "J2SE", "Android");

        // подготовили и отправили резюме рекрутеру
        recruiter.register(candidate1);
        recruiter.register(candidate2);

        // рекрутер за день собрал три компании
        recruiter.addNew(new Project("NifNif", "J2SE", "Android"));
        recruiter.addNew(new Project("NufNuf", "J2EE"));

        // и вечером отправил рассылку
        recruiter.notice();

        System.out.println("------- Day2 -------");

        Candidate candidate3 = new CandidateImpl("Mister Angular", "JavaScript", "AngularJS");
        Candidate candidate4 = new CandidateImpl("Bob Marley", "JavaScript", "J2SE");

        recruiter.register(candidate3);
        recruiter.register(candidate4);

        recruiter.remove(candidate1);

        recruiter.addNew(new Project("NafNaf", "JavaScript", "J2SE"));
        recruiter.addNew(new Project("NifNif", "J2SE", "Android"));
        recruiter.addNew(new Project("NufNuf", "J2EE"));

        recruiter.notice();
    }
}