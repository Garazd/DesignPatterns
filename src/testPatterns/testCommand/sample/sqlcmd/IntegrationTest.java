package testPatterns.testCommand.sample.sqlcmd;

import designPatterns.command.sample.sqlcmd.Main;
import org.junit.Test;
import testPatterns.testCommand.ConsoleMock;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testHelp() {
        // given
        console.addIn("help");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "help\r\n" +
                "Существующие команды:\r\n" +
                "\tconnect|databaseName|userName|password\r\n" +
                "\t\tПодключение к базе данных, с которой будем работать\r\n" +
                "\thelp\r\n" +
                "\t\tВывод списка команд\r\n" +
                "\texit\r\n" +
                "\t\tВыход из программы\r\n" +
                "\ttables\r\n" +
                "\t\tВывод всех таблиц базы\r\n" +
                "\tclear|tableName\r\n" +
                "\t\tОчищение всей таблицы\r\n" +
                "\tremove|tableName|column|value\r\n" +
                "\t\tУдаление записей из таблицы по запросу\r\n" +
                "\tcreate|tableName|column1|value1|column2|value2|...|columnN|valueN\r\n" +
                "\t\tСозание записи в таблице\r\n" +
                "\tfind|tableName\r\n" +
                "\t\tПолучение содержимого таблицы\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testExit() {
        // given
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testListWithoutConnect() {
        // given
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "Ты не можешь пользоваться командой 'tables' пока не подключишься с помощью комманды connect|databaseName|userName|password\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testFindWithoutConnect() {
        // given
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "find|user\r\n" +
                "Ты не можешь пользоваться командой 'find|user' пока не подключишься с помощью комманды connect|databaseName|userName|password\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testUnsupported() {
        // given
        console.addIn("unsupported");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "unsupported\r\n" +
                "Ты не можешь пользоваться командой 'unsupported' пока не подключишься с помощью комманды connect|databaseName|userName|password\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testUnsupportedAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("unsupported");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "unsupported\r\n" +
                "Несуществующая команда: unsupported\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testTablesAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "[]\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testTablesWithData_caseEmptyTable() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("find|user");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "find|user\r\n" +
                "--------------------\r\n" +
                "|\r\n" +
                "--------------------\r\n" +
                "--------------------\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "[user]\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testTablesWithData_caseNoEmptyData() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("create|user|id|13|name|Stiven|password|pass");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "create|user|id|13|name|Stiven|password|pass\r\n" +
                "Запись {names:[id, name, password], values:[13, Stiven, pass]} была успешно создана в таблице 'user'.\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "[user]\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testFindAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|user");
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "clear|user\r\n" +
                "Таблица user была успешно очищена.\r\n" +
                "-->\r\n" +
                "find|user\r\n" +
                "--------------------\r\n" +
                "|\r\n" +
                "--------------------\r\n" +
                "--------------------\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testConnectAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("tables");
        console.addIn("connect|test|postgres|postgres");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "[]\r\n" +
                "-->\r\n" +
                "connect|test|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "tables\r\n" +
                "[]\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testConnectWithError() {
        // given
        console.addIn("connect|sqlcmd");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd\r\n" +
                "Неудача! по причине: Формат команды 'connect|databaseName|userName|password', а ты ввел 'connect|sqlcmd'\r\n" +
                "Повтори попытку.\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testFindAfterConnect_withData() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|user");
        console.addIn("create|user|id|13|name|Stiven|password|*****");
        console.addIn("create|user|id|14|name|Eva|password|+++++");
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "clear|user\r\n" +
                "Таблица user была успешно очищена.\r\n" +
                "-->\r\n" +
                "create|user|id|13|name|Stiven|password|*****\r\n" +
                "Запись {names:[id, name, password], values:[13, Stiven, *****]} была успешно создана в таблице 'user'.\r\n" +
                "-->\r\n" +
                "create|user|id|14|name|Eva|password|+++++\r\n" +
                "Запись {names:[id, name, password], values:[14, Eva, +++++]} была успешно создана в таблице 'user'.\r\n" +
                "-->\r\n" +
                "find|user\r\n" +
                "--------------------\r\n" +
                "|id|name|password|\r\n" +
                "--------------------\r\n" +
                "|13|Stiven|*****|\r\n" +
                "|14|Eva|+++++|\r\n" +
                "--------------------\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testClearWithError() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|sadfasd|fsf|fdsf");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "clear|sadfasd|fsf|fdsf\r\n" +
                "Неудача! по причине: Формат команды 'clear|tableName', а ты ввел: 'clear|sadfasd|fsf|fdsf'\r\n" +
                "Повтори попытку.\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }

    @Test
    public void testCreateWithErrors() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("create|user|error");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\r\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\r\n" +
                "-->\r\n" +
                "connect|sqlcmd|postgres|postgres\r\n" +
                "Успех!\r\n" +
                "-->\r\n" +
                "create|user|error\r\n" +
                "Неудача! по причине: Должно быть четное количество параметров в формате 'create|tableName|column1|value1|column2|value2|...|columnN|valueN', а ты ввел: 'create|user|error'\r\n" +
                "Повтори попытку.\r\n" +
                "-->\r\n" +
                "exit\r\n" +
                "До скорой встречи!\r\n", console.getOut());
    }
}