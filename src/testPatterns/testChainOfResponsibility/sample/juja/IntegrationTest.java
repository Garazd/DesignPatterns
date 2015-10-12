package testPatterns.testChainOfResponsibility.sample.juja;

import designPatterns.chainOfResponsibility.sample.juja.JuJaTeam;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

// порой на весь пакет лучше написать пачку интеграционных тестов
// так мы не завязываемся на реализацию пакета что дает более свободный рефакторинг внутри
// юнит тесты очень связывают код, а интегрейшен тесты достаточно хрупкие
// выбирать тебе :)
// а мне просто лень потому итут будет один только тест
public class IntegrationTest {

    // так как весь вывод в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    // но мокать нам еще надо и System.in с которого читаем
    // а для этого нам потребуется этот поболее
    private StringsInputStream in = new StringsInputStream();

    private static class StringsInputStream extends InputStream {

        private LinkedList<String> lines = new LinkedList<String>();
        private ByteArrayInputStream in = null;
        private boolean endOfLine = false;

        public StringsInputStream(String... lines) {
            this.lines.addAll(Arrays.asList(lines));
        }

        public void add(String... lines) {
            this.lines.addAll(Arrays.asList(lines));
        }

        // тут... короче долго объяснять :)
        @Override
        public int read() throws IOException {
            if (in == null) {
                loadLine();
            }
            if (in.available() == 0) {
                if (endOfLine) {
                    endOfLine = false;
                    return -1;
                }
                if (!loadLine()) {
                    return -1;
                }
            }
            int read = in.read();
            if (read == 10 || read == 13) {
                endOfLine = true;
            }
            return read;
        }

        private boolean loadLine() {
            if (lines.isEmpty()) {
                return false;
            }

            String next = lines.remove() + "\r\n";
            System.out.print(next);
            in = new ByteArrayInputStream(next.getBytes(Charset.forName("utf8")));
            return true;
        }
    }

    // наш подопытный
    private JuJaTeam juja;

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));
        // полностью
        System.setIn(in);

        juja = new JuJaTeam();
    }

    @Test
    public void whenNoName_thenGoodBuy() {
        given("").when("А что это за фигня у вас?").then(
                "Q: А что это за фигня у вас?\n" +
                "A: Как вас зовут?\n" +
                "\n" +
                "A: Давай досвидания...\n" +
                "\t+---------------------------------------\n" +
                "\t| anonym: А что это за фигня у вас?\n" +
                "\t| Type: SPAM\n" +
                "\t+---------------------------------------\n");
    }

    // все так же как в Atm
    // только формат
    // given(часть1).when(часть2).then(часть3)
    // где часть1 - то что будет вводить пользователь на вопросы Алены
    // часть2 - то что пользователь задал изначально
    // часть3 - вывод на консоль
    private Given given(String... inputs) {
        return new Given(inputs);
    }

    private class Given {
        public Given(String... inputs) {
            // given
            // настраиваем ввод
            in.add(inputs);
        }

        public When when(String request) {
            // then
            // делаем вызов
            juja.process(request);
            return new When();
        }
    }

    private class When {
        public void then(String output) {
            // then

            // ассертим
            assertEquals(output.replaceAll("\n", "\r\n"), out.toString());

            // на всякий чистим
            out.reset();
        }
    }

    @Test
    public void whenName_thenWeWillTry() {
        given("Stiven").when("А что это за фигня у вас?").then(
                "Q: А что это за фигня у вас?\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Мы попробуем что-то сделать...\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: А что это за фигня у вас?\n" +
                "\t| Type: UNKNOWN\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenCanIBuy_thenGoToPayment() {
        given("Stiven").when("А можно купить шаблоны?").then(
                "Q: А можно купить шаблоны?\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Да, вот линк на платежку http://juja.com.ua/...\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: А можно купить шаблоны?\n" +
                "\t| Type: LEAD\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenHaveAnIdea_thenWeWillCheck() {
        given("Stiven").when("У меня есть идея, по новому продукту - вот смотрите: ...").then(
                "Q: У меня есть идея, по новому продукту - вот смотрите: ...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Мы попробуем что-то сделать...\n" +
                "V: Классная идея! Ребята попробуем?..\n" +
                "D: Дайте мне пару дней...\n" +
                "C: Давай пробовать!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: У меня есть идея, по новому продукту - вот смотрите: ...\n" +
                "\t| Type: NEW_IDEA\n" +
                "\t+---------------------------------------\n");
    }


    @Test
    public void whenErrorWithLms_thenFixIt() {
        given("Stiven").when("Там у вас ошибка с lms - вот смотрите: ...").then(
                "Q: Там у вас ошибка с lms - вот смотрите: ...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Мы попробуем что-то сделать...\n" +
                "D: Минутку...\n" +
                "D: LMS исправил!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Там у вас ошибка с lms - вот смотрите: ...\n" +
                "\t| Type: BUG_REPORT\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenErrorWithSite_thenFixIt() {
        given("Stiven").when("Там у вас сайт упал, ошибка какая-то...").then(
                "Q: Там у вас сайт упал, ошибка какая-то...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Мы попробуем что-то сделать...\n" +
                "D: Минутку...\n" +
                "D: Сайт поднял!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Там у вас сайт упал, ошибка какая-то...\n" +
                "\t| Type: BUG_REPORT\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenError_thenFixIt() {
        given("Stiven").when("Там ошибка. У вас глючит что-то, вот смотрите: ...").then(
                "Q: Там ошибка. У вас глючит что-то, вот смотрите: ...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Мы попробуем что-то сделать...\n" +
                "D: Минутку...\n" +
                "D: Все пофикшено!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Там ошибка. У вас глючит что-то, вот смотрите: ...\n" +
                "\t| Type: BUG_REPORT\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantJujaAndPayAll_thenGoToTraining() {
        given("Stiven").when("Вот вам 150$ хочу juja core...").then(
                "Q: Вот вам 150$ хочу juja core...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: На вас счет зачислено: 150$\n" +
                "V: Вы приняты на курс juja core!\n" +
                "C: Давай учиться!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Вот вам 150$ хочу juja core...\n" +
                "\t| Type: TRAINEE\n" +
                "\t| Amount: 150\n" +
                "\t| Debt: 0\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantJujaAndPayNothing_thenGoodBuy() {
        given("Stiven", "0$").when("Хочу juja core, вот вам 1$").then(
                "Q: Хочу juja core, вот вам 1$\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$\n" +
                "0$\n" +
                "A: Давай досвидания...\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Хочу juja core, вот вам 1$\n" +
                "\t| Type: SPAM\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantJujaAndPayPart_thenGoToTrainingWithDebt() {
        given("Stiven", "$50").when("Хочу juja core, вот вам 10$").then(
                "Q: Хочу juja core, вот вам 10$\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$\n" +
                "$50\n" +
                "A: На вас счет зачислено: 50$\n" +
                "V: Вы приняты на курс juja core!\n" +
                "V: Сумма долга составляет: 100$\n" +
                "C: Давай учиться!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Хочу juja core, вот вам 10$\n" +
                "\t| Type: TRAINEE\n" +
                "\t| Amount: 50\n" +
                "\t| Debt: 100\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantJujaAndPayAll_thenGoToTrainingWithoutDebt() {
        given("Stiven", "150$").when("Хочу juja core, вот вам 10$").then(
                "Q: Хочу juja core, вот вам 10$\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$\n" +
                "150$\n" +
                "A: На вас счет зачислено: 150$\n" +
                "V: Вы приняты на курс juja core!\n" +
                "C: Давай учиться!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Хочу juja core, вот вам 10$\n" +
                "\t| Type: TRAINEE\n" +
                "\t| Amount: 150\n" +
                "\t| Debt: 0\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantJujaAndPayPartAtStart_thenGoToTrainingWithDebt() {
        given("Stiven").when("Вот вам 50$ хочу juja core...").then(
                "Q: Вот вам 50$ хочу juja core...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: На вас счет зачислено: 50$\n" +
                "V: Вы приняты на курс juja core!\n" +
                "V: Сумма долга составляет: 100$\n" +
                "C: Давай учиться!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Вот вам 50$ хочу juja core...\n" +
                "\t| Type: TRAINEE\n" +
                "\t| Amount: 50\n" +
                "\t| Debt: 100\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantPatternAndPayAll_thenGoToTrainingWithoutDebt() {
        given("Stiven").when("Вот вам 50$ хочу design patterns...").then(
                "Q: Вот вам 50$ хочу design patterns...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: На вас счет зачислено: 50$\n" +
                "V: Вы приняты на курс design patterns!\n" +
                "C: Давай учиться!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Вот вам 50$ хочу design patterns...\n" +
                "\t| Type: TRAINEE\n" +
                "\t| Amount: 50\n" +
                "\t| Debt: 0\n" +
                "\t+---------------------------------------\n");
    }

    @Test
    public void whenWantOtherProductAndPayMoney_thenWeWillTry() {
        given("Stiven").when("Вот вам 200$ хочу индивидуальную консультацию...").then(
                "Q: Вот вам 200$ хочу индивидуальную консультацию...\n" +
                "A: Как вас зовут?\n" +
                "Stiven\n" +
                "A: На вас счет зачислено: 200$\n" +
                "V: Ребята, тут интересное предложение!\n" +
                "D: Дайте мне пару дней...\n" +
                "C: Давай пробовать!\n" +
                "\t+---------------------------------------\n" +
                "\t| Stiven: Вот вам 200$ хочу индивидуальную консультацию...\n" +
                "\t| Type: NEW_IDEA\n" +
                "\t| Amount: 200\n" +
                "\t| Debt: 0\n" +
                "\t+---------------------------------------\n");
    }
}