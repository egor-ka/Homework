package test.task3.task3_1;

import org.junit.Before;
import org.junit.Test;
import tasks.task3.task3_1.CrazyLogger;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 07.09.2016.
 */
public class CrazyLoggerTest {

    CrazyLogger logger = new CrazyLogger();

    @Before
    public void setUp() {
        logger.addMessage("hello, crazy logger, this is first message");
        logger.addMessage("second message");
        logger.addMessage("second message second time");
        logger.addMessage("third message");
    }

    @Test
    public void findMessageByTextText() {
        ArrayList<String> found = logger.findMessageByText("logger");

        assertEquals("wrong number of messages including 'logger'!", 1, found.size());
        System.out.println("result of search 'logger':");
        printList(found);
        System.out.println();

        found = logger.findMessageByText("second message");
        assertEquals("wrong number of messages including 'second message'!", 2, found.size());
        System.out.println("result of search 'second message':");
        printList(found);
        System.out.println();

        found = logger.findMessageByText("message");
        assertEquals("wrong number of messages including 'second message'!", 4, found.size());
        System.out.println("result of search 'message':");
        printList(found);
        System.out.println();
    }

    public void printList(ArrayList<String> list) {
        if (list != null) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}
