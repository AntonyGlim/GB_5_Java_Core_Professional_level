/**
 * 3. Создать небольшую базу данных. Таблица «Студенты» с полями id, фамилия, балл).
 * Написать тесты для проверки корректности добавления, обновления и чтения записей. Следует учесть,
 * что в базе есть заранее добавленные записи, и после проведения тестов эти они не должны быть удалены,
 * изменены или добавлены вновь.
 */
package lesson_6_Tests_jUnit_Logging_Log4о;

import java.sql.*;

public class WorkWithDB {

    /**
     * Метод добавляет запись в таблицу
     * @param statement - объект для подключения к БД
     * @param table_name - имя таблицы
     * @param second_name - фамилия студента
     * @param score - оценка студента
     * @throws SQLException
     */
    public void insertIntoTable(Statement statement, String table_name, String second_name, int score) throws SQLException {
        String sql = String.format("INSERT INTO %s (second_name, score) " +
                "VALUES ('%s', %d);", table_name, second_name, score);
        statement.execute(sql);
    }

    public void deleteFromTable (Statement statement, String table_name, String second_name) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE second_name = '%s';", table_name, second_name);
        statement.execute(sql);
    }

    /**
     * Метод обновит значение фамилии студента
     * На место старой фамилии поставит новую
     * @param statement
     * @param tableName - имя таблицы
     * @param oldSecond_name
     * @param newSecond_name
     * @return
     * @throws SQLException
     */
    public int updateStudBySecondName(Statement statement, String tableName, String oldSecond_name, String newSecond_name) throws SQLException {
        String sql = String.format("UPDATE %s SET second_name = '%s' WHERE second_name = '%s';", tableName, newSecond_name, oldSecond_name);
        int count = statement.executeUpdate(sql);
        return count;
    }

    /**
     * Метод вернет строку из БД по фамилии студента (Не включая id).
     * @param tableName - имя таблицы
     * @throws SQLException
     */
    public String returnStringBySecondName(Statement statement, String tableName, String second_name) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE second_name = '%s';", tableName, second_name);
        ResultSet rs = statement.executeQuery(sql);
        Object[] arr = new Object[3];
        while (rs.next()){
            arr[1] = rs.getString(2);
            arr[2] = rs.getInt(3);
        }
        String studInformation = arr[1] + " " + arr[2].toString();
        return studInformation;
    }


//    private static Connection connection;
//    private static Statement statement;
//    private static String tableName = "stud";
//    private static WorkWithDB workWithDB;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Object[] arr = new Object[3];
//        arr[0] = "1";
//        arr[1] = "Иванов";
//        arr[2] = "4";
//        String studInformation = arr[0].toString() + " " + arr[1].toString() + " " + arr[2].toString();
//        System.out.println(studInformation);

//        Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_6_Tests_jUnit_Logging_Log4о/lesson_6_students.db");
//        statement = connection.createStatement();
//
//        System.out.println(returnStringBySecondName(statement, tableName, "Пуговкин"));
    }

}
