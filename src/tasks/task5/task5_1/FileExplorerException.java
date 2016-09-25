package tasks.task5.task5_1;

/**
 * Created by Egor on 25.09.2016.
 */
public class FileExplorerException extends Exception {
    public FileExplorerException() {
        super();
    }

    public FileExplorerException(String message) {
        super(message);
    }

    public FileExplorerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExplorerException(Throwable cause) {
        super(cause);
    }

    protected FileExplorerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
