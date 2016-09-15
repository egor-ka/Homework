package test.task6.task6_2;

import org.junit.Before;
import org.junit.Test;
import tasks.task6.task6_2.PropertiesReaderMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Egor on 15.09.2016.
 */
public class PropertiesReaderMapTest {

    public static final String EXISTING_BUNDLE_PATH = "resources.task6.task6_2.existing_file";

    PropertiesReaderMap propertiesReaderMap;

    @Before
    public void setUp() {
        propertiesReaderMap = new PropertiesReaderMap();
    }

    @Test
    public void getValueFromMapTest() {
        assertNotEquals("Reading bundle (existing_file) should NOT fail", null, propertiesReaderMap.createResourceMap(EXISTING_BUNDLE_PATH));

        assertNotEquals("Getting value (key1) should NOT fail", null, propertiesReaderMap.getValueFromMap("existing_file.key1"));
        System.out.println("First value: " + propertiesReaderMap.getValueFromMap("existing_file.key1").toString());
        assertNotEquals("Getting value (key2) should NOT fail", null, propertiesReaderMap.getValueFromMap("existing_file.key2"));
        System.out.println("Second value: " + propertiesReaderMap.getValueFromMap("existing_file.key2").toString());

        assertEquals("Getting value (key1000) should fail", null, propertiesReaderMap.getValueFromMap("existing_file.key1000"));
    }

}
