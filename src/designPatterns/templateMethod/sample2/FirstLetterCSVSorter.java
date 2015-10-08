package designPatterns.templateMethod.sample2;

// ��� ���� ��������� ����������, ��� ��������� ����������
// �� ���������� ������������� ��-���������
public class FirstLetterCSVSorter extends CSVSorter {

    @Override
    protected boolean compare(Object o1, Object o2) {
        return o1.toString().charAt(0) > o2.toString().charAt(0);
    }
}