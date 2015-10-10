package designPatterns.chainOfResponsibility.sample.juja;

import java.util.Scanner;

// Алена у нас сейчас как человек-оркестр
public class AlenaKuznetsova extends TeamMember {

    private Scanner client;

    // она может общаться с клиентами, уточнять у них детали
    public AlenaKuznetsova() {
        client =  new Scanner(System.in);
    }

    @Override
    protected boolean canHandle(Request request) {
        // Алёна на передовой и всем говорит ДА!
        return true;
    }

    // а вот, на секундочку, как ей не просто
    @Override
    protected boolean handle(Request request){
        String message = request.getMessage();

        System.out.println("A: Как вас зовут?");
        String name = client.nextLine();
        if (name.length() == 0) {
            request.setType(Request.Type.SPAM);
            System.out.println("A: Давай досвидания...");
            return true;
        } else {
            request.setType(Request.Type.UNKNOWN);
            request.setName(name);
        }

        if (message.contains("можно купить") || message.contains("сколько стоит")) {
            request.setType(Request.Type.LEAD);
            System.out.println("A: Да, вот линк на платежку http://juja.com.ua/...");
            return true;
        }

        if (message.contains("есть идея")) {
            request.setType(Request.Type.NEW_IDEA);
        }

        if (message.contains("ошибка")) {
            request.setType(Request.Type.BUG_REPORT);
        }

        if (message.contains("$")) {
            int amount = getAmount(message);
            while (amount < 50) {
                System.out.println("A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$");
                amount = getAmount(client.nextLine());
                if (amount <= 0) {
                    request.setType(Request.Type.SPAM);
                    System.out.println("A: Давай досвидания...");
                    return true;
                }
            }
            System.out.println("A: На вас счет зачислено: " + amount + "$");
            request.setAmount(amount);
            request.setType(Request.Type.PAYMENT);
            return false;
        }

        System.out.println("A: Мы попробуем что-то сделать...");

        return false;
    }

    // олата - штука сложная, то банк не то вернет, то карточку зажует
    private int getAmount(String message) {
        String[] parts = message.split("( )+");
        if (parts.length == 1) {
            try {
                if (parts[0].contains("$")) {
                    parts = parts[0].split("[//$]");
                    if (parts[0].length() == 0) {
                        parts[0] = parts[1];
                    }
                }
                return Integer.valueOf(parts[0]);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        for (String part : parts) {
            if (part.contains("$")) {
                return Integer.valueOf(part.split("[//$]")[0]);
            }
        }
        return 0;
    }
}