package designPatterns.composite.classic.case1;

// этот интерфейс определяет полезную логику, которуой мы хотим
// снабдить каждый элемент
public interface Component {
    
    String operation1(String data);
    String operation2(String data);
}