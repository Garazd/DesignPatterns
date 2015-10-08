package designPatterns.templateMethod.classic;

public class ConcreteClassB extends AbstractClass {

//    ��� ��� ���� ����� ���������� ��-��������� � ��������,
//    �� ����� � �� ���������� ���
//    @Override
//    protected Object algorithm1() {
//        return "algorithm1B";
//    }

    @Override
    protected void algorithm2(Object input) {
        System.out.println("algorithm2B prints " + input);
    }

    @Override
    protected void algorithm3() {
        System.out.println("algorithm3B prints smth");
    }

    @Override
    protected Object algorithm4(Object input) {
        return "algorithm4B " + input;
    }
}