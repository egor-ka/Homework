package test.task5.task5_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tasks.task5.task5_2.PropertiesReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReaderTest {

    public static final String NON_EXISTING_BUNDLE_PATH = "resources.task5.task5_2.non_existing_file";
    public static final String EXISTING_BUNDLE_PATH = "resources.task5.task5_2.existing_file";


    PropertiesReader propertiesReader;

    @Before
    public void setUp() {
        propertiesReader = new PropertiesReader();
    }

    @Test
    public void readBundleFailTest() {
        assertEquals("Reading bundle (non_existing_file) should fail", null, propertiesReader.readBundle(NON_EXISTING_BUNDLE_PATH));
    }

    @Test
    public void getValueFromBundleTest() {
        assertNotEquals("Reading bundle (existing_file) should NOT fail", null, propertiesReader.readBundle(EXISTING_BUNDLE_PATH));

        assertNotEquals("Getting value (key1) should NOT fail", null, propertiesReader.getValueFromBundle("existing_file.key1"));
        System.out.println("First value: " + propertiesReader.getValueFromBundle("existing_file.key1").toString());
        assertNotEquals("Getting value (key2) should NOT fail", null, propertiesReader.getValueFromBundle("existing_file.key2"));
        System.out.println("Second value: " + propertiesReader.getValueFromBundle("existing_file.key2").toString());

        assertEquals("Getting value (key1000) should fail", null, propertiesReader.getValueFromBundle("existing_file.key1000"));
    }

}
