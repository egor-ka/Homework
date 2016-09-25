package test.task5.task5_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tasks.task5.task5_2.PropertiesReader;
import tasks.task5.task5_2.exception.PropertiesReaderFileNotFoundException;
import tasks.task5.task5_2.exception.PropertiesReaderKeyNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReaderTest {

    public static final String NON_EXISTING_BUNDLE_PATH = "resources.task5.task5_2.non_existing_file";
    public static final String EXISTING_BUNDLE_PATH = "resources.task5.task5_2.existing_file";


    private PropertiesReader propertiesReader;

    @Test
    public void readBundleFailTest() {
        try {
            propertiesReader = new PropertiesReader(NON_EXISTING_BUNDLE_PATH);
            assertTrue("Reading bundle (non_existing_file) should fail", false);
        } catch (PropertiesReaderFileNotFoundException e) {
        }
    }

    @Test
    public void getValueFromBundleTest(){

        try {
            propertiesReader = new PropertiesReader(EXISTING_BUNDLE_PATH);

            propertiesReader.getValueFromBundle("existing_file.key1");
            System.out.println("First value: " + propertiesReader.getValueFromBundle("existing_file.key1").toString());

            propertiesReader.getValueFromBundle("existing_file.key2");
            System.out.println("Second value: " + propertiesReader.getValueFromBundle("existing_file.key2").toString());
        } catch (PropertiesReaderFileNotFoundException e) {
            assertTrue("Reading bundle (existing_file) should NOT fail", false);
        } catch (PropertiesReaderKeyNotFoundException e) {
            assertTrue("Getting value should NOT fail", false);
        }

        try {
            propertiesReader.getValueFromBundle("existing_file.key1000");
            assertTrue("Getting value (key1000) should fail", false);
        } catch (PropertiesReaderKeyNotFoundException e) {
        }
    }

}
