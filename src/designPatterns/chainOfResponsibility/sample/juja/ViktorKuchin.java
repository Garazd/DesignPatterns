package designPatterns.chainOfResponsibility.sample.juja;

public class ViktorKuchin extends TeamMember {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == Request.Type.PAYMENT ||
                request.getType() == Request.Type.NEW_IDEA;
    }

    @Override
    protected boolean handle(Request request){
        String message = request.getMessage();

        if (request.getType() == Request.Type.PAYMENT) {
            int amount = request.getAmount();

            if (message.contains("juja core")) {
                request.setDebt(150 - amount);
                System.out.println("V: Вы приняты на курс juja core!");
                request.setType(Request.Type.TRAINEE);
            } else if (message.contains("design patterns")) {
                request.setDebt(50 - amount);
                System.out.println("V: Вы приняты на курс design patterns!");
                request.setType(Request.Type.TRAINEE);
            } else {
                System.out.println("V: Ребята, тут интересное предложение!");
                request.setType(Request.Type.NEW_IDEA);
            }
            if (request.getDebt() != 0) {
                System.out.println("V: Сумма долга составляет: " + request.getDebt() + "$");
            }
        } else {
            System.out.println("V: Классная идея! Ребята попробуем?..");
        }
        return false;
    }
}