package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lama
 */
public class SQLiteUtil {

    private Connection connection;

    public SQLiteUtil() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    public void createTable(String tableName, String[] fields) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE " + tableName
                    + "ID INT PRIMARY KEY NOT NULL"
                    + "";
            statement.executeUpdate(sql);
            statement.close();
//            connection.close();
        } catch (Exception e) {
        }
        System.out.println("Table created successfully");
    }

    public void createFields(String tableName, String[] fields) {
        Statement s;
        try {
            s = connection.createStatement();
//            String sql =
        } catch (Exception e) {
        }
    }

}
