package tasks.task5.task5_2.exception;

/**
 * Created by Egor on 25.09.2016.
 */
public class PropertiesReaderKeyNotFoundException extends Exception {
    public PropertiesReaderKeyNotFoundException() {
        super();
    }

    public PropertiesReaderKeyNotFoundException(String message) {
        super(message);
    }

    public PropertiesReaderKeyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesReaderKeyNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PropertiesReaderKeyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
