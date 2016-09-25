package tasks.task5.task5_2;

import tasks.task5.task5_2.exception.PropertiesReaderFileNotFoundException;
import tasks.task5.task5_2.exception.PropertiesReaderKeyNotFoundException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReader {

    private ResourceBundle resourceBundle;

    public PropertiesReader(String propertiesFilePath) throws PropertiesReaderFileNotFoundException {
        resourceBundle = readBundle(propertiesFilePath);
    }

    public ResourceBundle readBundle(String propertiesFilePath) throws PropertiesReaderFileNotFoundException {
        try {
            resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
        } catch (NullPointerException e) {
            throw new PropertiesReaderFileNotFoundException("File name is null");
        } catch (MissingResourceException e) {
            throw new PropertiesReaderFileNotFoundException("No file found by this path: " + propertiesFilePath);
        }
        return resourceBundle;
    }

    public Object getValueFromBundle(String key) throws PropertiesReaderKeyNotFoundException {
        if (resourceBundle != null) {
            try {
                if (resourceBundle.containsKey(key)) {
                    return resourceBundle.getObject(key);
                } else {
                    throw new PropertiesReaderKeyNotFoundException("No value found by key: " + key);
                }
            } catch (NullPointerException e) {
                throw new PropertiesReaderKeyNotFoundException("Key is null");
            }
        }
        return null;
    }

}
