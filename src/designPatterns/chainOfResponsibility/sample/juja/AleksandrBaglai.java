package designPatterns.chainOfResponsibility.sample.juja;

// это я :)
public class AleksandrBaglai extends TeamMember {

    @Override
    protected boolean canHandle(Request request) {
        // отвечаю в основном за обучение
        return request.getType() == Request.Type.TRAINEE ||
                // а еще мне нравятся идеи
                request.getType() == Request.Type.NEW_IDEA;
    }

    @Override
    protected boolean handle(Request request){
        if (request.getType() == Request.Type.TRAINEE) {
            System.out.println("C: Давай учиться!");
        } else {
            System.out.println("C: Давай пробовать!");
        }
        return true;
    }
}