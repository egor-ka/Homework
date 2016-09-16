package tasks.task7.task7_2;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Egor on 17.09.2016.
 */
public class ConcurrentPropertiesReader {

    private volatile ResourceBundle resourceBundle;

    public ConcurrentPropertiesReader() {
    }

    public ConcurrentPropertiesReader(String propertiesFilePath) {
        resourceBundle = readBundle(propertiesFilePath);
    }

    public ResourceBundle readBundle(String propertiesFilePath) {
        if (resourceBundle == null) {
            synchronized (ConcurrentPropertiesReader.class) {
                if (resourceBundle == null) {
                    try {
                        System.out.println("Reading success by thread: " + Thread.currentThread().getName());
                        resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
                    } catch (NullPointerException e) {
                        System.out.println("File name is null");
                        return null;
                    } catch (MissingResourceException e) {
                        System.out.println("No file found by this path: " + propertiesFilePath);
                        return null;
                    }
                }
            }
        }
        return resourceBundle;
    }

    public Object getValueFromBundle(String key) {
        if (resourceBundle != null) {
            try {
                if (resourceBundle.containsKey(key)) {
                    return resourceBundle.getObject(key);
                } else {
                    System.out.println("No value found by key: " + key);
                }
            } catch (NullPointerException e) {
                System.out.println("Key is null");
                return null;
            }
        }
        return null;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

}
