package test.task8.task8_2;

import org.junit.Before;
import org.junit.Test;
import tasks.task8.task8_2.connection_pool.BookConnectionPool;
import tasks.task8.task8_2.dao.DBBookDao;
import tasks.task8.task8_2.model.Book;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Egor on 25.09.2016.
 */
public class BookTest {

    private static final Book THE_DARK_TOWER = new Book("Stephen King", "The Dark Tower", 40);

    private BookConnectionPool connectionPool;

    @Before
    public void before() throws Exception {
        connectionPool = BookConnectionPool.getInstance();
    }

    @Test
    public void testCreateFindAndRemoveAuthorAndBook() throws Exception {
        try (Connection connection = connectionPool.takeConnection()) {
            DBBookDao bookDao = new DBBookDao(connection);
            bookDao.add(THE_DARK_TOWER);
            Book bookFromDB = bookDao.getById(1);
            assertEquals(THE_DARK_TOWER.getAuthor(), bookFromDB.getAuthor());
            assertEquals(THE_DARK_TOWER.getTitle(), bookFromDB.getTitle());
            assertEquals(THE_DARK_TOWER.getCost(), bookFromDB.getCost());
            bookDao.delete(bookFromDB);
            assertNull(bookDao.getById(1));
        }
    }

}
