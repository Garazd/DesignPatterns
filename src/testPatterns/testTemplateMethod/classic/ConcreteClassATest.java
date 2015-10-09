package testPatterns.testTemplateMethod.classic;

import designPatterns.templateMethod.classic.AbstractClass;
import designPatterns.templateMethod.classic.ConcreteClassA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// мы можем протестировать и конкретную реализацию
// это будет уже интеграционный тест
public class ConcreteClassATest {

    // тут нам мокито не надо :)

    @Test
    public void test() {
        // given

        // нам потребуется дореализовать его анонимно
        AbstractClass object = new ConcreteClassA();

        // when
        // вызываем наш шаблонный метод и передаем тестовые данные
        Object result = object.templateMethod("some_data");

        // then
        // проверяем, что он вернул нам
        assertEquals("algorithm1A plus algorithm4A some_data", result);
    }
}