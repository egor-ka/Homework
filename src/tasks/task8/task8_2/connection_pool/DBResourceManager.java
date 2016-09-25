package tasks.task8.task8_2.connection_pool;

import java.util.ResourceBundle;

/**
 * Created by Egor on 25.09.2016.
 */
public class DBResourceManager {
    public static final String DEFAULT_BUNDLE_NAME = "resources.task8.task8_2.connectionPool";

    private static DBResourceManager instance;
    private static ResourceBundle bundle;

    public static DBResourceManager getInstance() {
        if (instance == null) {
            instance = new DBResourceManager();
        }
        return instance;
    }

    public String getValue(String key) {
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(DEFAULT_BUNDLE_NAME);
        }
        return bundle.getString(key);
    }

    private DBResourceManager() {
    }
}
