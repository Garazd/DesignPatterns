package designPatterns.templateMethod.classic;

// ����� ������ ���� ������� ��� ����������
public abstract class AbstractClass {

    // ��� ��������� �����, � ��� ������������ ����� ���� �������������� ����������
    // ���� �� �� �����, ����� ��������� ������������� ��� - ������ final
    public final Object templateMethod(Object input) {
        Object data1 = algorithm1();
        algorithm2(input);
        algorithm3();
        Object data2 = algorithm4(input);

        return data1.toString() + " plus " + data2.toString();
    }

    // ���������� ��������� 1 ��-���������
    // ���������� ��������� �� ������, ���� �������
    public Object algorithm1() {
        return "default_algorithm1";
    }

    // ��� ����������� ������-��������� ������ ���� ����������� ������������
    public abstract void algorithm2(Object input);

    public abstract void algorithm3();

    public abstract Object algorithm4(Object input);
}