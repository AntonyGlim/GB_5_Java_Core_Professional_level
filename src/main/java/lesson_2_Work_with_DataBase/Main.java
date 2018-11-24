package lesson_2_Work_with_DataBase;

import com.sun.javafx.binding.StringFormatter;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static String tableName = "products_table";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {

            connect();
//            createTable(tableName);
//            dropTable(tableName);
//            deleteAllFromTable(tableName);
//            connection.setAutoCommit(false);
//            for (int i = 1; i <= 1000; i++) {
//                insertIntoTable(tableName, i, ("Товар_" + i), i);
//            }
//            connection.commit();
//            connection.setAutoCommit(true);
            System.out.println("Введите название товара. (для выхода введите /q)");
            while (true){
                String s = in.nextLine();
                if (s.equalsIgnoreCase("/q")) break;
                returnCostByName(tableName, s);
            }

            disconnect();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO - connect();
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_2_Work_with_DataBase/lesson_2_products.db");
        statement = connection.createStatement();
    }

    //TODO - disconnect();
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO - createTable() if not exist
    public static void createTable(String tableName) throws SQLException {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s (\n"+
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"+
                " prodid INTEGER NOT NULL,\n"+
                " title TEXT NOT NULL,\n"+
                " cost INTEGER NOT NULL);", tableName);
        statement.execute(sql);
    }

    public static void dropTable(String tableName) throws SQLException {
        String sql = String.format("DROP TABLE %s;", tableName);
        statement.execute(sql);
    }

    //TODO - insertIntoTable() data
    public static void insertIntoTable(String tableName, int prodid, String title, int cost) throws SQLException {
        String sql = String.format("INSERT INTO %s (prodid, title, cost) " +
                "VALUES (%d, '%s', %d);", tableName, prodid, title, cost);
        statement.execute(sql);
    }

    //TODO - cleanTable()
    public static void deleteAllFromTable(String tableName) throws SQLException {
        String sql = String.format("DELETE FROM %s ", tableName);
        statement.execute(sql);
    }

    //TODO - int returnCostByName(String productName) from database
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

    //TODO - int updateCostByName(String productName) from database
//    public static void deleteAllFromTable(String tableName) throws SQLException {
//        String sql = String.format("DELETE FROM %s ", tableName);
//        statement.execute(sql);
//    }



    //TODO - createDB() if not exist



    //TODO - int updateCostByName(String productName) from database
    //TODO - returnFromDiapason(String columnName, int lowerBorder, int upperBorder) from database

}
