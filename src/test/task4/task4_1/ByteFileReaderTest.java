package test.task4.task4_1;

import org.junit.Test;
import tasks.task4.task4_1.ByteFileReader;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Egor on 09.09.2016.
 */
public class ByteFileReaderTest {

    ByteFileReader byteFileReader = new ByteFileReader();
    HashSet<String> keyWordList = new HashSet<>();


    @Test
    public void getKeyWordSetTest() {
        keyWordList = byteFileReader.getKeyWordSet();
        assertEquals("Wrong number of keywords!", 17, keyWordList.size());
        printList(keyWordList);
    }

    @Test
    public void printKeyWordSetToFile() {
        assertTrue(byteFileReader.printKeyWordSetToFile());
    }

    public void printList(HashSet<String> list) {
        for (String string: list) {
            System.out.println(string);
        }
    }
}
