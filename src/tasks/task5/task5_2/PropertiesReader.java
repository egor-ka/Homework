package tasks.task5.task5_2;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReader {

    private ResourceBundle resourceBundle;

    public PropertiesReader() {
    }

    public PropertiesReader(String propertiesFilePath) {
        resourceBundle = readBundle(propertiesFilePath);
    }

    public ResourceBundle readBundle(String propertiesFilePath) {
        try {
            resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
        } catch (NullPointerException e) {
            System.out.println("File name is null");
            return null;
        } catch (MissingResourceException e) {
            System.out.println("No file found by this path: " + propertiesFilePath);
            return null;
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

}
