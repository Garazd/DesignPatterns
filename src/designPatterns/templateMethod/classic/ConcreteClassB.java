package designPatterns.templateMethod.classic;

public class ConcreteClassB extends AbstractClass {

//    ��� ��� ���� ����� ���������� ��-��������� � ��������,
//    �� ����� � �� ���������� ���
//    @Override
//    protected Object algorithm1() {
//        return "algorithm1B";
//    }

    @Override
    public void algorithm2(Object input) {
        System.out.println("algorithm2B prints " + input);
    }

    @Override
    public void algorithm3() {
        System.out.println("algorithm3B prints smth");
    }

    @Override
    public Object algorithm4(Object input) {
        return "algorithm4B " + input;
    }
}