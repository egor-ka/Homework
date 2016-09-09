package test.task4.task4_2;

import org.junit.Test;
import tasks.task4.task4_2.TextFileReader;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Egor on 09.09.2016.
 */
public class TextFileReaderTest {
    TextFileReader textFileReader = new TextFileReader();
    HashSet<String> keyWordList = new HashSet<>();

    @Test
    public void getKeyWordSetTest() {
        keyWordList = textFileReader.getKeyWordSet();
        assertEquals("Wrong number of keywords!", 16, keyWordList.size());
        printList(keyWordList);
    }

    @Test
    public void printKeyWordSetToFile() {
        assertTrue(textFileReader.printKeyWordSetToFile());
    }

    public void printList(HashSet<String> list) {
        for (String string: list) {
            System.out.println(string);
        }
    }
}
