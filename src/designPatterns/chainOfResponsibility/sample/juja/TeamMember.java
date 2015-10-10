package designPatterns.chainOfResponsibility.sample.juja;

// это самое главное место цепочка ответственности (тот, что Handler)
// с шаблонным методом инкапсулируюбщим ее логику тут,
// в этом абстрактном классе
public abstract class TeamMember {

    // цепочка начинается тут
    private TeamMember successor;

    // все так же сетаем его из клиента
    public TeamMember next(TeamMember successor) {
        this.successor = successor;

        // а это сделано для красоты
        // посмотри в Main как они выстраиваются в цепочку
        // alena.next(viktor).next(danil).next(alex);
        return successor;
    }

    // все тот же template method (public final, помнишь?)
    public final void handleRequest(Request request) {
        // если текущий может обработать пусть сделает это!
        if (canHandle(request)) {
            // если он обработал и сказал, что он сделал все возможное
            if (handle(request)) {
                // то логгируем
                log(request);

                // и прерываем цепочку
                return;
            }
        }

        // если же не можем обработать или после нас требуется обработка другими участниками
        // то передаем запрос дальше
        // если есть, конечно, кому передавать
        if (successor != null) {
            successor.handleRequest(request);
        } else {
            // тоже крайний случай - логгируем и выходим
            log(request);
        }
    }

    // все участники обрабатывают запросы
    // заметь, тут я вернул boolean поскольку решил
    // что текущий учатник может остановить обработку запроса на себе
    // для этого ему надо вернуть true
    protected abstract boolean handle(Request request);

    // и сами решают, могут ли они обработать этот запрос
    protected abstract boolean canHandle(Request request);

    private void log(Request request) {
        System.out.println("\t+---------------------------------------");
        String[] lines = request.toString().split("\n");
        for (String line : lines) {
            System.out.println("\t| " + line);
        }
        System.out.println("\t+---------------------------------------");
    }
}