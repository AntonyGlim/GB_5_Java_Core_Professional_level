/**
 * 3. Создать небольшую базу данных. Таблица «Студенты» с полями id, фамилия, балл).
 * Написать тесты для проверки корректности добавления, обновления и чтения записей. Следует учесть,
 * что в базе есть заранее добавленные записи, и после проведения тестов эти они не должны быть удалены,
 * изменены или добавлены вновь.
 */
package lesson_6_Tests_jUnit_Logging_Log4о;

import java.sql.SQLException;
import java.sql.Statement;

public class workWithDB {

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

    /**
     * Метод обновит значение фамилии студента
     * На место старой фамилии поставит новую
     * @param statement
     * @param tableName
     * @param oldSecond_name
     * @param newSecond_name
     * @return
     * @throws SQLException
     */
    public int updateStudBySecondName(Statement statement, String tableName, String oldSecond_name, int newSecond_name) throws SQLException {
        String sql = String.format("UPDATE %s SET second_name = '%s' WHERE second_name = '%s';", tableName, newSecond_name, oldSecond_name);
        int count = statement.executeUpdate(sql);
        return count;
    }

}
