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
            deleteAllFromTable(tableName);
            connection.setAutoCommit(false);
            for (int i = 1; i <= 100; i++) {
                insertIntoTable(tableName, i, ("Т_" + i), i);
            }
            connection.commit();
            connection.setAutoCommit(true);
            System.out.println("Для выхода введите /q)");
            while (true){
                String s = in.nextLine();
                String[] tokens = s.split(" ", 3);
                if (s.equalsIgnoreCase("/q")) break;
                if (s.startsWith("ц")){
                    returnCostByName(tableName, tokens[1]);
                }
                if (s.startsWith("с")){
                    updateCostByName(tableName, tokens[1], Integer.parseInt(tokens[2]));
                }
                if (s.startsWith("т")){
                    returnFromDiapasonByCost(tableName, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                }

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

    //TODO - Защита, если пользователь введен ни число а строку
    public static void updateCostByName(String tableName, String titleToUbdateCost, int newCost) throws SQLException {
        String sql = String.format("UPDATE %s SET cost = '%d' WHERE title = '%s';", tableName, newCost, titleToUbdateCost);
        System.out.println("Стоимость " + titleToUbdateCost + " изменена.");
        statement.execute(sql);
    }

    //TODO - Защита, если пользователь введен ни число а строку
    public static void returnFromDiapasonByCost(String tableName, int lowerBorder, int upperBorder) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE cost >= %d AND cost <= %d;", tableName, lowerBorder, upperBorder);
        ResultSet rs = statement.executeQuery(sql);
//        if (rs.next()) {
        System.out.println("id" + "\t" + "prodid" + "\t" + "title" + "\t" + "cost");
        while (rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
            }
//        }
    }







    //TODO - createDB() if not exist
}
