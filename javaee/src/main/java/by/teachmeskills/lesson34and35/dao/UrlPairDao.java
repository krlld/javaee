package by.teachmeskills.lesson34and35.dao;

import by.teachmeskills.lesson34and35.db.Connector;
import by.teachmeskills.lesson34and35.domain.UrlPair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Slf4j
@Repository
public class UrlPairDao {

    private final Connector connector;

    @Autowired
    public UrlPairDao(Connector connector) {
        this.connector = connector;
        try {
            createUrlTable();
            log.info("Url pair table existing");
        } catch (SQLException e) {
            log.error("Something wrong with creating of url pair table");
            throw new RuntimeException(e);
        }
    }

    public void createUrlTable() throws SQLException {
        Statement statement = connector.getConnection().createStatement();
        statement.execute("""
                CREATE TABLE IF NOT EXISTS url_pair (
                id INT AUTO_INCREMENT PRIMARY KEY,
                url TEXT NOT NULL,
                alias TEXT NOT NULL)""");
    }

    public void save(UrlPair urlPair) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement("INSERT INTO url_pair (url, alias) VALUES (?,?)");
            preparedStatement.setString(1, urlPair.url());
            preparedStatement.setString(2, urlPair.alias());
            preparedStatement.execute();
            log.info("Save url pair " + urlPair);
        } catch (SQLException e) {
            log.error("Something wrong with saving of url pair");
            throw new RuntimeException(e);
        }
    }

    public Optional<UrlPair> findByAlias(String alias) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement("SELECT * FROM url_pair WHERE alias = ?");
            preparedStatement.setString(1, alias);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return Optional.empty();
            }
            String url = resultSet.getString("url");
            return Optional.of(new UrlPair(url, alias));
        } catch (SQLException e) {
            log.error("Something wrong with searching of url pair by alias");
            throw new RuntimeException(e);
        }
    }
}
