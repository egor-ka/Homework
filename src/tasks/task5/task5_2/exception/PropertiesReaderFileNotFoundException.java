package tasks.task5.task5_2.exception;

/**
 * Created by Egor on 25.09.2016.
 */
public class PropertiesReaderFileNotFoundException extends Exception {

    public PropertiesReaderFileNotFoundException() {
        super();
    }

    public PropertiesReaderFileNotFoundException(String message) {
        super(message);
    }

    public PropertiesReaderFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesReaderFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PropertiesReaderFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
