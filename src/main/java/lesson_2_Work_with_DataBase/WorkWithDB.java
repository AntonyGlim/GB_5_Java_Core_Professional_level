package lesson_2_Work_with_DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkWithDB {
    private static Connection connection;
    private static Statement statement;

    //TODO - connect();
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson_2_Work_with_DataBase/lesson_2_products.db");
        statement = connection.createStatement();
    }


    //TODO - createDB() if not exist
    //TODO - createTable() if not exist
    //TODO - cleanTable()
    //TODO - insertIntoTable() data
    //TODO - int returnCostByName(String productName) from database
    //TODO - int updateCostByName(String productName) from database
    //TODO - returnFromDiapason(String columnName, int lowerBorder, int upperBorder) from database

    //TODO - disconnect();
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
