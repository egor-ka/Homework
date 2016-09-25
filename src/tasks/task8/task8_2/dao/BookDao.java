package tasks.task8.task8_2.dao;

import tasks.task8.task8_2.model.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 20.09.2016.
 */
public interface BookDao {

    List<Book> getAll() throws SQLException;

    Book getById(int id) throws SQLException;

    boolean add(Book book) throws SQLException;

    boolean delete(Book book) throws SQLException;
}
