package designPatterns.chainOfResponsibility.classic.case4;

// мы выделили абстракцию
// помнишь те самые два абстрактных метода в прошлом Handler? они теперь тут
public interface Handler {

    // а клиенты пусть реализуют обработчик
    void handle(Request request);

    // и сами решают, можгут ли они обработать этот запрос
    boolean canHandle(Request request);
}