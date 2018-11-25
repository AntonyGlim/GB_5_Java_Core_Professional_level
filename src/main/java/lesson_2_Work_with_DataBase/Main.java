/**
 * Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
 * id – порядковый номер записи, первичный ключ;
 * prodid – уникальный номер товара;
 * title – название товара;
 * cost – стоимость.
 *
 * При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
 * id_товара 1 товар1 10
 * id_товара 2 товар2 20
 * id_товара 3 товар3 30
 * id_товара 10000 товар10000 100000
 *
 * Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо
 * вывести сообщение «Такого товара нет», если товар не обнаружен в базе. Консольная
 * команда: «цена товар545».
 *
 * Добавить возможность изменения цены товара. Указываем имя товара и новую цену.
 * Консольная команда: «сменитьцену товар10 10000».
 *
 * Вывести товары в заданном ценовом диапазоне. Консольная команда: «товарыпоцене 100
 * 600»
 */
package lesson_2_Work_with_DataBase;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static String tableName = "products_table";                                                 //Имя таблицы вынесенео, для удобства
    private static String[] tokens = {"б", "б", "б", "б"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            
        //Подготовка БД
            connect();                                                                                  //Подключаемся к БД
            dropTable(tableName);                                                                       //Удаляем таблицу из БД (если существует)
            createTable(tableName);                                                                     //Создаем таблицу (если не существует)
            deleteAllFromTable(tableName);                                                              //Удаляем содержимое таблицы (если таблица имела данные)

        //Заполнение БД элементами
            connection.setAutoCommit(false);                                                            //Отключаем автокомиты в БД, чтобы сократить время работы с ней
            for (int i = 1; i <= 100; i++){ insertIntoTable(tableName, i, ("Товар_" + i), i);}          //Записываем в таблицу значения
            connection.commit();                                                                        //Принудительно вручную делаем коммит для уверенности
            connection.setAutoCommit(true);                                                             //Включаем обратно автокомит

        //Блок основной работы
            System.out.println("Для получения информации введите \"/i\"");
            while (true){
                String s = in.nextLine();                                                               //Читаем данные из консоли
                tokens = s.split(" ", 4);                                                      //Устанавливаем лимит 4 для удобства работы с командами, остальное отбросим (защита от инъекций)
                if (s.equalsIgnoreCase("/q")){                                                          //Ветка для выхода из программы
                    break;
                }
                if (s.equalsIgnoreCase("/i")){
                    programInformation();                                                               //Метод выведет в консоль описание основных команд программы
                }
                if (s.startsWith("цена")){
                    if(isValidNumber(tokens[1])){
                        returnCostByName(tableName, tokens[1]);                                             //Метод выведет в консоль стоимость товара по введенному имени
                    } else {
                        System.out.println("Запрос выполнен не корректно");
                    }
                }
                if (s.startsWith("сменитьцену")){
                    if(isValidNumber(tokens[2])){                                                       //Пользователь вводит число?
                        updateCostByName(tableName, tokens[1], Integer.parseInt(tokens[2]));            //Метод заменит цену товара в БД
                    } else {                                                                            //Если пытаются ввести не число
                        System.out.println("Вы пытаетесь ввести строку там, где должно быть число.");
                    }
                }
                if (s.startsWith("товарыпоцене")){
                    if(isValidNumber(tokens[1]) && isValidNumber(tokens[2])){
                        returnFromDiapasonByCost(tableName, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));      //Метод выведет в консоль список товаров в отыформатированном виде
                    } else {
                        System.out.println("Вы пытаетесь ввести строку там, где должно быть число.");   //Если пытаются ввести не число
                    }
                }
            }

        //Высвобождение ресурсов
            disconnect();                                                                               //Закрываем соединение с БД

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Устанавливаем соединение с БД
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_2_Work_with_DataBase/lesson_2_products.db");
        statement = connection.createStatement();
    }

    /**
     * Закрываем соединение с БД
     */
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создает новую таблицу в БД (если она еще не существует)
     * @param tableName
     * @throws SQLException
     */
    public static void createTable(String tableName) throws SQLException {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s (\n"+
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"+
                " prodid INTEGER NOT NULL,\n"+
                " title TEXT NOT NULL,\n"+
                " cost INTEGER NOT NULL);", tableName);
        statement.execute(sql);
    }

    /**
     * Метод удаляет таблицу из БД (если она существует) - метод для отладки
     * @param tableName
     * @throws SQLException
     */
    public static void dropTable(String tableName) throws SQLException {
        String sql = String.format("DROP TABLE IF EXISTS %s;", tableName);
        statement.execute(sql);
    }

    /**
     * Метод добавляет запись в таблицу
     * @param tableName
     * @param prodid - столбец 2
     * @param title - столбец 3
     * @param cost - столбец 4
     * @throws SQLException
     */
    public static void insertIntoTable(String tableName, int prodid, String title, int cost) throws SQLException {
        String sql = String.format("INSERT INTO %s (prodid, title, cost) " +
                "VALUES (%d, '%s', %d);", tableName, prodid, title, cost);
        statement.execute(sql);
    }

    /**
     * Метод удаляет все данные из таблицы - метод для отладки
     * @param tableName
     * @throws SQLException
     */
    public static void deleteAllFromTable(String tableName) throws SQLException {
        String sql = String.format("DELETE FROM %s ", tableName);
        statement.execute(sql);
    }

    /**
     * Метод возвращает стоимость товара по его имени.
     * Если ResultSet не будет иметь хотябы одного элемента
     * Пользователь увидит сообщение, что товара с таким именем нет
     * @param tableName
     * @param titleToFined
     * @throws SQLException
     */
    public static void returnCostByName(String tableName, String titleToFined) throws SQLException {
        String sql = String.format("SELECT cost " +
                "FROM %s WHERE title = '%s';", tableName, titleToFined);
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            int cost = rs.getInt("cost");
            System.out.println("Стоимость товара: " + cost + "р.");
        } else {
            System.out.println("Такого товара нет.");
        }
    }

    /**
     * Метод обновит значение цены по имени.
     * Если пользователь введет не существующее имя - вернется предупреждение
     * @param tableName
     * @param titleToUbdateCost
     * @param newCost
     * @throws SQLException
     */
    public static void updateCostByName(String tableName, String titleToUbdateCost, int newCost) throws SQLException {
        String sql = String.format("UPDATE %s SET cost = '%d' WHERE title = '%s';", tableName, newCost, titleToUbdateCost);
        int count = statement.executeUpdate(sql);
        if (count > 0){
            System.out.println("Стоимость " + titleToUbdateCost + " изменена.");
        } else {
            System.out.println("К сожалению, обновления не произошло! Проверьте имя товара.");
        }
    }

    /**
     * Метод вернет строки из БД цена которых будет соответствовать ценовому диапазону.
     * @param tableName
     * @param lowerBorder - минимальная цена
     * @param upperBorder - максимальная цена
     * @throws SQLException
     */
    public static void returnFromDiapasonByCost(String tableName, int lowerBorder, int upperBorder) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE cost >= %d AND cost <= %d;", tableName, lowerBorder, upperBorder);
        ResultSet rs = statement.executeQuery(sql);
        System.out.printf("%6s", "id");                             //printf - для удобства восприятия информации
        System.out.printf("%8s", "prodid");
        System.out.printf("%12s", "title");
        System.out.printf("%10s", "cost" + "\n");
        while (rs.next()){
            System.out.printf("%6d", rs.getInt(1));
            System.out.printf("%8d", rs.getInt(2));
            System.out.printf("%12s", rs.getString(3));
            System.out.printf("%10s", (rs.getInt(4) + "\n"));
        }
    }

    /**
     * Метод проверит, является-ли строка введенная пользователем положительным числом
     * @param str
     * @return
     */
    private static boolean isValidNumber(String str){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * Метод выведет на экран информацию о командах в приложении
     */
    private static void programInformation(){
        System.out.println("Ознакомтесь с информацией для работы: ");
        System.out.println("1.Чтобы узнать цену товара, введите ключевое слово \"цена\" и имя товара через пробел," +
                "\nзатем нажмите Enter. Пример: \"цена Товар_456\";");
        System.out.println("2.Чтобы изменить цену товара, введите ключевое слово \"сменитьцену\", имя товара через пробел " +
                "\nи новую цену товара, затем нажмите Enter. Пример: \"сменитьцену Товар_456 55\"");
        System.out.println("3.Чтобы получить список товаров из определенного ценового диапазона, " +
                "\nвведите ключевое слово \"товарыпоцене\", минимальную и максимальную цену товара, " +
                "\nзатем нажмите Enter. Пример: \"товарыпоцене 100 200\"");
        System.out.println("4. Для выхода введите \"/q\")");
    }
}
