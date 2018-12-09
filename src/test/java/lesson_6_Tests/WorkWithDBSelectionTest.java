package lesson_6_Tests;

import lesson_6_Tests_jUnit_Logging_Log4о.WorkWithDB;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

/**
 * В классе проверяем, корректно - ли работают запросы в БД
 */
@RunWith(Parameterized.class)                                                   //Используем параметризацию
public class WorkWithDBSelectionTest {

    @Parameterized.Parameters                                                   //Используем параметризацию
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Иванов 4", "Иванов"},
                {"Петров 3", "Петров"},
                {"Зюганов 5", "Зюганов"},
                {"Петренко 4", "Петренко"},
                {"Ильявичус 4", "Ильявичус"},
                {"Ильин 4", "Ильин"},
                {"Пуговкин 5", "Пуговкин"},
                {"Коннозаводов 5", "Коннозаводов"},
                {"Якименко 4", "Якименко"},
                {"Кац 5", "Кац"},
        });
    }

    public WorkWithDBSelectionTest(String expected, String sendTo) {
        this.expected = expected;
        this.sendTo = sendTo;
    }

    private String expected;
    private String sendTo;
    private Connection connection;
    private Statement statement;
    private String tableName = "stud";
    private WorkWithDB workWithDB;


    /**
     * Устанавливаем соединение с БД
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Before
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_6_Tests_jUnit_Logging_Log4о/lesson_6_students.db");
        statement = connection.createStatement();
        workWithDB = new WorkWithDB();
    }

    /**
     * Проверяем, как работает получение данных из БД
     * Полученная из БД строка запроса, должна соответствовать заранее известному результату
     */
    @Test
    public void returnStringBySecondNameTest1(){
        try {
            Assert.assertTrue(expected.equals(workWithDB.returnStringBySecondName(statement, tableName, sendTo)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Закрываем соединение с БД
     */
    @After
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
