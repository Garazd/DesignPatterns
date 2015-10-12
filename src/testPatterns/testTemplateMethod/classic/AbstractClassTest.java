package testPatterns.testTemplateMethod.classic;

import designPatterns.templateMethod.classic.AbstractClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

// мы можем протестировать и абстрактный класс без единого наследника
public class AbstractClassTest {

    // делаем это без мокито
    // нам понадобятся эти флаги, чтобы проверить что происходило
    // в определенных методах шаблонного метода
    Object algorithm2Input = null;
    boolean callAlgorithm3 = false;
    Object algorithm4Input = null;

    @Test
    public void test() {
        // given
        // нам потребуется дореализовать его анонимно
        AbstractClass object = new AbstractClass() {
            @Override
            public void algorithm2(Object input) {
                algorithm2Input = input;
            }

            @Override
            public void algorithm3() {
                callAlgorithm3 = true;
            }

            @Override
            public Object algorithm4(Object input) {
                algorithm4Input = input;
                return "stub4";
            }
        };

        // when
        // вызываем наш шаблонный метод и передаем тестовые данные
        Object result = object.templateMethod("some_data");

        // then
        // проверяем, что он вернул нам
        assertEquals("default_algorithm1 plus stub4", result);

        // проверяем, что пришло в метод algorithm2
        assertEquals("some_data", algorithm2Input);
        assertEquals("some_data", algorithm4Input);

        // проверяем, что был вызов алгоритма algorithm3
        assertTrue(callAlgorithm3);
    }

    // теперь то же но с мокито
    @Test
    public void testWithMockito() {
        // given
        // мы создаем мок на основе нашего абстрактного класса
        AbstractClass object = mock(AbstractClass.class);

        // мы программируем его поведение
        // для algorithm4
        when(object.algorithm4(anyObject())).thenReturn("mocked4");
        // а для algorithm1 вызываем реализацию по-умолчанию
        when(object.algorithm1()).thenCallRealMethod();

        // when
        // вызываем наш шаблонный метод и передаем тестовые данные
        Object result = object.templateMethod("some_data");

        // then
        // проверяем, что он вернул нам
        assertEquals("default_algorithm1 plus mocked4", result);
        // проверяем, что пришло в метод algorithm2 и 4
        verify(object).algorithm2("some_data");
        verify(object).algorithm4("some_data");
        // проверяем, что был вызов алгоритма algorithm3
        verify(object).algorithm3();
    }
}