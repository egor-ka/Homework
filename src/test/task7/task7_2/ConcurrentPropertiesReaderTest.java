package test.task7.task7_2;

import org.junit.Before;
import org.junit.Test;
import tasks.task7.task7_2.ConcurrentPropertiesReader;

import java.util.Enumeration;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Egor on 17.09.2016.
 */
public class ConcurrentPropertiesReaderTest {

    public static final String EXISTING_BUNDLE_PATH = "resources.task7.task7_2.existing_file";

    private ConcurrentPropertiesReader propertiesReader;

    @Before
    public void setUp() {
        propertiesReader = new ConcurrentPropertiesReader();
    }

    @Test
    public void getValueFromBundleTest() {

        Thread t1 = readingThread();
        Thread t2 = readingThread();
        Thread t3 = readingThread();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Thread readingThread() {
        Thread thread = new Thread(new Runnable() {
            Enumeration<String> keys;
            String key;

            @Override
            public void run() {
                propertiesReader.readBundle(EXISTING_BUNDLE_PATH);

                keys = propertiesReader.getResourceBundle().getKeys();
                while(keys.hasMoreElements()) {
                    key = keys.nextElement();
                    System.out.println(Thread.currentThread().getName() + ": " + key + ": " + propertiesReader.getValueFromBundle(key).toString());
                }
            }
        });
        return thread;
    }

}
