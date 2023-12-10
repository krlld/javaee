package by.teachmeskills.lesson34and35.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "12345678");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Connection CONNECTION;

    public static Connection getConnection() {
        return CONNECTION;
    }
}
