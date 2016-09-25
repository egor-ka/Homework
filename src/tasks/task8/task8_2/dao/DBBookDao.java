package tasks.task8.task8_2.dao;

import tasks.task8.task8_2.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 20.09.2016.
 */
public class DBBookDao implements BookDao {

    private static String BOOKS_TABLE_NAME = "library";

    private Connection connection;

    public DBBookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        String query = "SELECT * FROM " + BOOKS_TABLE_NAME + " WHERE id=?";
        List<Book> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book element = new Book(resultSet.getInt(0), resultSet.getString("author"), resultSet.getString("title"), resultSet.getInt("cost"));
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public Book getById(int id) throws SQLException {
        String query = "SELECT * FROM " + BOOKS_TABLE_NAME + " WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Book element = new Book(resultSet.getInt(1), resultSet.getString("author"), resultSet.getString("title"), resultSet.getInt("cost"));
                return element;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean add(Book book) throws SQLException {
        String query = "INSERT INTO " + BOOKS_TABLE_NAME + "(author, title, cost) VALUES(?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setInt(3, book.getCost());

            return statement.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        String query = "DELETE FROM " + BOOKS_TABLE_NAME + " WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, book.getId());

            return statement.executeUpdate() == 1;
        }
    }
}
