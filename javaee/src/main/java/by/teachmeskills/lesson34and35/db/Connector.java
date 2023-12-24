package by.teachmeskills.lesson34and35.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class Connector {

    private final Connection connection;

    public Connector(@Value("${database.url}") String url,
                     @Value("${database.user}") String user,
                     @Value("${database.password}") String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            log.info("Success of getting connection");
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Something wrong with getting connection");
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
