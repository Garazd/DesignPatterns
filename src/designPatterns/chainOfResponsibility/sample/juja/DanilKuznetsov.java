package designPatterns.chainOfResponsibility.sample.juja;

// Данил у нас админ и все фиксит
public class DanilKuznetsov extends TeamMember {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == Request.Type.BUG_REPORT ||
                // он тоже любит новые идеи
                // правда с точки зрения технической реализации
                request.getType() == Request.Type.NEW_IDEA;
    }

    @Override
    protected boolean handle(Request request){
        String message = request.getMessage();

        if (request.getType() == Request.Type.BUG_REPORT) {
            if (message.contains("lms")) {
                System.out.println("D: Минутку...");
                System.out.println("D: LMS исправил!");
            } else if (message.contains("сайт упал")) {
                System.out.println("D: Минутку...");
                System.out.println("D: Сайт поднял!");
            } else if (message.contains("глючит")) {
                System.out.println("D: Минутку...");
                System.out.println("D: Все пофикшено!");
            } else {
                System.out.println("D: То бага системы, надо рисерчить...");
            }
            return true;
        } else {
            System.out.println("D: Дайте мне пару дней...");
            return false;
        }
    }
}