package lesson_6_Tests;

import lesson_6_Tests_jUnit_Logging_Log4о.WorkWithDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkWithDBInsertTest {

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

    @Test
    public void insertDataIntoDBTest (){
        try {
            String sendTo = "Фамилия15";
            String expected = "Фамилия15 55";
            workWithDB.insertIntoTable(statement, tableName, sendTo, 55);
            Assert.assertTrue(expected.equals(workWithDB.returnStringBySecondName(statement, tableName, sendTo)));
            workWithDB.deleteFromTable(statement, tableName, sendTo);
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
