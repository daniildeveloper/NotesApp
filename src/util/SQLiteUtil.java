package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lama
 */
public class SQLiteUtil {

    private Connection connection;

    public SQLiteUtil(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    public void createTable(String tableName, String fieldsSql) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE " + tableName
                    + fieldsSql;
            statement.executeUpdate(sql);
            statement.close();
//            connection.close();
        } catch (Exception e) {
        }
        System.out.println("Table created successfully");
    }

    public void insert(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet select(String query) {
        ResultSet resultSet = null;
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            resultSet = rs;

        } catch (SQLException ex) {
            Logger.getLogger(SQLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }

    public boolean workspaceInDB() {
        String workspace = null;
        ResultSet resultSet = select("select * from configuration");
        try {
            workspace = resultSet.getString("workspace");
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (workspace.isEmpty() || workspace == null) {
            return false;
        } else {
            return true;
        }

    }

}
