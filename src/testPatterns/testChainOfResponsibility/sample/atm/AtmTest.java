package testPatterns.testChainOfResponsibility.sample.atm;

import designPatterns.chainOfResponsibility.sample.atm.Atm;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

// интеграционный тест на основе Main
public class AtmTest {

    // так как весь вывод в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));
    }

    // наш подопытный
    private Atm atm;

    // обрати внимание на DSL теста
    // тест как документация - вот к чему надо стремиться
    @Test
    public void testDefaultConstructor_case1() {
        given.defaultAtm();

        when(186).then(
                "186 =",
                "1 x $100",
                "1 x $50",
                "1 x $20",
                "1 x $10",
                "1 x $5",
                "1 x $1",
                "--------");
    }

    @Test
    public void testDefaultConstructor_case1_OLD() {
        // given
        atm = new Atm();

        // when
        // делаем тестовый вызов
        atm.withdraw(186);

        // then
        // собираем строчку из параметров
        String expected = "186 =\r\n" +
                        "1 x $100\r\n" +
                        "1 x $50\r\n" +
                        "1 x $20\r\n" +
                        "1 x $10\r\n" +
                        "1 x $5\r\n" +
                        "1 x $1\r\n" +
                        "--------\r\n";

        // ассертим
        assertEquals(expected, out.toString());

        // и на всякий чистим буффер
        out.reset();
    }

    // теперь как это устроено

    // у нас есть поле given класса Given
    private Given given = new Given();

    // этот класс не статический, а потому будет частью экземпляра теста
    public class Given {
        // у него есть ряд методов для инициализации поля atm теста

        // дифолтовой реализацией
        public void defaultAtm() {
            // видишь - поле напрямую можем брать
            // а все потому, что класс не статический (public class Given)
            atm = new Atm();
        }

        // и навороченно
        public void primeAtm() {
            atm = new Atm(1, 2, 3, 5, 7, 11, 13, 17, 19, 23,
                    29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                    73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                    127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                    179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                    233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                    283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
                    353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                    419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
                    467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
                    547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
                    607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
                    661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
                    739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
                    811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
                    877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                    947, 953, 967, 971, 977, 983, 991, 997);
        }
    }

    // дальше у нас простой фектори метод
    // ой, мы его потом разберем
    // пока запомни, что это метод который конструирует объект
    // и сразу его возвращает. Такой себе заменитель конструктора
    // тут его надо чтобы по коду не писать
    // new When(123).then("")
    // а просто
    // when(123).then("")
    public When when(int amount) {
        return new When(amount);
    }

    // дальше идет еще один нестатический класс When
    public class When {
        // он хранит в себе amount что мы передаем в тесте как часть1
        // when(часть1).then(часть2)
        private int amount;

        // а это конструктор, который мы чуть выше за'фектор'метод'или :)
        private When(int amount) {
            this.amount = amount;
        }

        // а это часть2 вызова
        // when(часть1).then(часть2)
        // тут делается самое важное
        public void then(String... lines) {
            // when
            // делаем тестовый вызов
                // помнишь, что так как класс не статический (public class When),
                // то мы можем поля теста дергать напрямую
                // так, будь-то бы мы находимся в тесте
            atm.withdraw(amount);

            // then
            // собираем строчку из параметров
            String expected = getString(lines);

            // ассертим
            assertEquals(expected, out.toString());

            // и на всякий чистим буффер
            out.reset();
        }

        // это чудо, чтобы в тесте не писать везде \r\n - достало!
        private String getString(String[] lines) {
            String result = "";
            for (String line : lines) {
                result += line + "\r\n";
            }
            return result;
        }
    }
    // кстати, немного заходя наперед - это был заточенный под тесты шаблон билдер
    // мы его еще рассмотрим

    // ну и дальше по аналогии с Main
    
    @Test
    public void testDefaultConstructor_case2() {
        // given
        given.defaultAtm();

        // when then
        when(72).then(
                "72 =",
                "1 x $50",
                "1 x $20",
                "2 x $1",
                "--------");
    }

    @Test
    public void testDefaultConstructor_case3() {
        // given
        given.defaultAtm();

        // when then
        when(1564).then(
                "1564 =",
                "15 x $100",
                "1 x $50",
                "1 x $10",
                "4 x $1",
                "--------");
    }

    @Test
    public void testConstructorWithParameters_case1() {
        // given
        given.primeAtm();

        // when then
        when(2342332).then(
                "2342332 =",
                "2349 x $997",
                "1 x $379",
                "--------");
    }

    @Test
    public void testConstructorWithParameters_case2() {
        // given
        given.primeAtm();

        // when then
        when(3453245).then(
                "3453245 =",
                "3463 x $997",
                "1 x $631",
                "1 x $3",
                "--------");
    }

    @Test
    public void testConstructorWithParameters_case3() {
        // given
        given.primeAtm();

        // when then
        when(123245).then(
                "123245 =",
                "123 x $997",
                "1 x $613",
                "1 x $1",
                "--------");
    }

    @Test
    public void testConstructorWithParameters_case4() {
        // given
        given.primeAtm();

        // when then
        when(23423).then(
                "23423 =",
                "23 x $997",
                "1 x $491",
                "1 x $1",
                "--------");
    }

    @Test
    public void testConstructorWithParameters_case5() {
        // given
        given.primeAtm();

        // when then
        when(34621437).then(
                "34621437 =",
                "34725 x $997",
                "1 x $607",
                "1 x $5",
                "--------");
    }
}