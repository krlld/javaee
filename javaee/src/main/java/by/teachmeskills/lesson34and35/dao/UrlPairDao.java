package by.teachmeskills.lesson34and35.dao;

import by.teachmeskills.lesson34and35.db.Connector;
import by.teachmeskills.lesson34and35.domain.UrlPair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UrlPairDao {

    private final Connection connection = Connector.getConnection();

    public UrlPairDao() {
        try {
            createUrlTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUrlTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("""
                CREATE TABLE IF NOT EXISTS url_pair (
                id INT AUTO_INCREMENT PRIMARY KEY,
                url TEXT NOT NULL,
                alias TEXT NOT NULL)""");
    }

    public void save(UrlPair urlPair) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO url_pair (url, alias) VALUES (?,?)");
            preparedStatement.setString(1, urlPair.url());
            preparedStatement.setString(2, urlPair.alias());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<UrlPair> findByAlias(String alias) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM url_pair WHERE alias = ?");
            preparedStatement.setString(1, alias);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return Optional.empty();
            }
            String url = resultSet.getString("url");
            return Optional.of(new UrlPair(url, alias));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
