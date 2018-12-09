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

@RunWith(Parameterized.class)
public class WorkWithDBSelectionTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1 Иванов 4", "Иванов"},
                {"2 Петров 3", "Петров"},
                {"3 Зюганов 5", "Зюганов"},
                {"4 Петренко 4", "Петренко"},
                {"5 Ильявичус 4", "Ильявичус"},
                {"6 Ильин 4", "Ильин"},
                {"7 Пуговкин 5", "Пуговкин"},
                {"8 Коннозаводов 5", "Коннозаводов"},
                {"9 Якименко 4", "Якименко"},
                {"10 Кац 5", "Кац"},
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

    @Before
    /**
     * Устанавливаем соединение с БД
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_6_Tests_jUnit_Logging_Log4о/lesson_6_students.db");
        statement = connection.createStatement();
        workWithDB = new WorkWithDB();
    }

    @Test
    public void returnStringBySecondNameTest1(){
        String str = "1 Иванов 4";
        try {
            Assert.assertTrue(expected.equals(workWithDB.returnStringBySecondName(statement, tableName, sendTo)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    /**
     * Закрываем соединение с БД
     */
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
