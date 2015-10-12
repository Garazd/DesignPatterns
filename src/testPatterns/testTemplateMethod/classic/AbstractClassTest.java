package testPatterns.testTemplateMethod.classic;

import designPatterns.templateMethod.classic.AbstractClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

// �� ����� �������������� � ����������� ����� ��� ������� ����������
public class AbstractClassTest {

    // ������ ��� ��� ������
    // ��� ����������� ��� �����, ����� ��������� ��� �����������
    // � ������������ ������� ���������� ������
    Object algorithm2Input = null;
    boolean callAlgorithm3 = false;
    Object algorithm4Input = null;

    @Test
    public void test() {
        // given
        // ��� ����������� ������������� ��� ��������
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
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus stub4", result);

        // ���������, ��� ������ � ����� algorithm2
        assertEquals("some_data", algorithm2Input);
        assertEquals("some_data", algorithm4Input);

        // ���������, ��� ��� ����� ��������� algorithm3
        assertTrue(callAlgorithm3);
    }

    // ������ �� �� �� � ������
    @Test
    public void testWithMockito() {
        // given
        // �� ������� ��� �� ������ ������ ������������ ������
        AbstractClass object = mock(AbstractClass.class);

        // �� ������������� ��� ���������
        // ��� algorithm4
        when(object.algorithm4(anyObject())).thenReturn("mocked4");
        // � ��� algorithm1 �������� ���������� ��-���������
        when(object.algorithm1()).thenCallRealMethod();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus mocked4", result);
        // ���������, ��� ������ � ����� algorithm2 � 4
        verify(object).algorithm2("some_data");
        verify(object).algorithm4("some_data");
        // ���������, ��� ��� ����� ��������� algorithm3
        verify(object).algorithm3();
    }
}