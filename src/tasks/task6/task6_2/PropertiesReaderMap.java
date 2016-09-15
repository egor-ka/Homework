package tasks.task6.task6_2;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReaderMap {

    private HashMap<String, Object> resourceMap;

    public PropertiesReaderMap() {
        resourceMap = new HashMap<>();
    }

    public PropertiesReaderMap(String propertiesFilePath) {
        this();
        resourceMap = createResourceMap(propertiesFilePath);
    }

    public HashMap<String, Object> createResourceMap(String propertiesFilePath) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesFilePath);
        Enumeration<String> keys = resourceBundle.getKeys();
        String key;

        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            resourceMap.put(key, resourceBundle.getObject(key));
        }

        return resourceMap;
    }

    public Object getValueFromMap(String key) {
        if (resourceMap != null) {
            if (resourceMap.containsKey(key)) {
                return resourceMap.get(key);
            } else {
                System.out.println("No value found by key: " + key);
            }
        }
        return null;
    }

}
