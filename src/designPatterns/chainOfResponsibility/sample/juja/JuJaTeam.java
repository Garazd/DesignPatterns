package designPatterns.chainOfResponsibility.sample.juja;

public class JuJaTeam {

    // наша команда
    private TeamMember alex = new AleksandrBaglai();
    private TeamMember viktor = new ViktorKuchin();
    private TeamMember alena = new AlenaKuznetsova();
    private TeamMember danil = new DanilKuznetsov();

    public JuJaTeam() {
        // очередь сообщений
        alena.next(viktor).next(danil).next(alex);
    }

    public void process(String request) {
        // все удары принимает Алена
        alena.handleRequest(new Request(request));
    }
}