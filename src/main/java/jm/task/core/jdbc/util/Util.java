package jm.task.core.jdbc.util;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    public static Connection getConnection() {
        String connectionUrl = "jdbc:mysql://localhost:3306/roma?serverTimezone=UTC";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl, "ricardo", "Zhopa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}