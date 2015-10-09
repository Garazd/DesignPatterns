package testPatterns.testTemplateMethod.classic;

import designPatterns.templateMethod.classic.AbstractClass;
import designPatterns.templateMethod.classic.ConcreteClassA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// �� ����� �������������� � ���������� ����������
// ��� ����� ��� �������������� ����
public class ConcreteClassATest {

    // ��� ��� ������ �� ���� :)

    @Test
    public void test() {
        // given

        // ��� ����������� ������������� ��� ��������
        AbstractClass object = new ConcreteClassA();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("algorithm1A plus algorithm4A some_data", result);
    }
}