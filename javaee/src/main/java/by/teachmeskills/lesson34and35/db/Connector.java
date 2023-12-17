package by.teachmeskills.lesson34and35.db;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Connector {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "12345678");
            log.info("Success of getting connection");
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Something wrong with getting connection");
            throw new RuntimeException(e);
        }
    }

    private static final Connection CONNECTION;

    public static Connection getConnection() {
        return CONNECTION;
    }
}
