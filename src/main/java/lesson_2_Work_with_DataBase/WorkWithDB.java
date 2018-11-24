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

    //TODO - disconnect();
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO - createTable() if not exist

    public void createTable() throws SQLException {
        statement.execute("CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (\n"+
                " column_1 data_type PRIMARY KEY,\n"+
                "   column_2 data_type NOT NULL,\n"+
                " column_3 data_type DEFAULT 0,\n"+
                " table_constraint\n"+
                ") [WITHOUT ROWID];");
    }


    //TODO - createDB() if not exist

    //TODO - cleanTable()
    //TODO - insertIntoTable() data
    //TODO - int returnCostByName(String productName) from database
    //TODO - int updateCostByName(String productName) from database
    //TODO - returnFromDiapason(String columnName, int lowerBorder, int upperBorder) from database


}
