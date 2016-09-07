package test.task3.task3_3;

import org.junit.Before;
import org.junit.Test;
import tasks.task3.task3_3.regexpPractice;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static tasks.task3.task3_3.regexpPractice.*;


/**
 * Created by Egor on 07.09.2016.
 */
public class regexpPracticeTest {
    String text;

    @Before
    public void setUp() {
        text = getFile();
    }

    @Test
    public void getLinesAboutImagesFromFileText() {
        ArrayList<String> lines = getLinesAboutImagesFromFile(text);

        assertEquals("Count of lines is not correct!", 145, lines.size());
    }

    @Test
    public void getImageNumbersTest() {
        ArrayList<Integer> numbers = getImageNumbers(text);

        assertEquals("Count of numbers is not correct!", 194, numbers.size());
        System.out.println(isNumbersConsistent(numbers)? "REFERENCES ARE INCREMENTAL": "REFERENCES ARE NOT INCREMENTAL");
    }
}
