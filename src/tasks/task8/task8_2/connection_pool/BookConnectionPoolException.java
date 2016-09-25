package tasks.task8.task8_2.connection_pool;

/**
 * Created by Egor on 25.09.2016.
 */
public class BookConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;

    public BookConnectionPoolException() {
    }

    public BookConnectionPoolException(String message) {
        super(message);
    }

    public BookConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookConnectionPoolException(Throwable cause) {
        super(cause);
    }

    public BookConnectionPoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
