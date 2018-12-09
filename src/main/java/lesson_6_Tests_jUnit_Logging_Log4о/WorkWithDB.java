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

    /**
     * Метод удалит запись из таблицы по фамилии студента
     * @param statement - объект для подключения к БД
     * @param table_name - имя таблицы
     * @param second_name - фамилия студента
     * @throws SQLException
     */
    public void deleteFromTable (Statement statement, String table_name, String second_name) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE second_name = '%s';", table_name, second_name);
        statement.execute(sql);
    }

    /**
     * Метод обновит значение фамилии студента
     * На место старой фамилии поставит новую
     * @param statement - объект для подключения к БД
     * @param tableName - имя таблицы
     * @param oldSecond_name - фамилия, которую нужно заменить
     * @param newSecond_name - новая фамилия
     * @return - количество измененных строк
     * @throws SQLException
     */
    public int updateStudBySecondName(Statement statement, String tableName, String oldSecond_name, String newSecond_name) throws SQLException {
        String sql = String.format("UPDATE %s SET second_name = '%s' WHERE second_name = '%s';", tableName, newSecond_name, oldSecond_name);
        int count = statement.executeUpdate(sql);
        return count;
    }

    /**
     * Метод вернет строку из БД по фамилии студента (Не включая id).
     * @param statement - объект для подключения к БД
     * @param tableName - имя таблицы
     * @param second_name - запрашиваемая фамилия
     * @return - вернет строку сформированную из запроса к БД
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

}
