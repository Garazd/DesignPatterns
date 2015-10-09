package testPatterns.testTemplateMethod.classic;

import designPatterns.templateMethod.classic.AbstractClass;
import designPatterns.templateMethod.classic.ConcreteClassB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// ��� �� � �� ������ �������
public class ConcreteClassBTest {

    // ��� ��� ������ �� ���� :)
    @Test
    public void test() {
        // given

        // ��� ����������� ������������� ��� ��������
        AbstractClass object = new ConcreteClassB();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus algorithm4B some_data", result);
    }
}