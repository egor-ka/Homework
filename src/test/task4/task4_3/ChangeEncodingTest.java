package test.task4.task4_3;

import org.junit.Test;
import tasks.task4.task4_3.ChangeEncoding;

import static org.junit.Assert.assertTrue;

/**
 * Created by Egor on 10.09.2016.
 */
public class ChangeEncodingTest {

    @Test
    public void rewriteFileTest() {
        assertTrue(ChangeEncoding.rewriteFileUTF8ToUTF16());
    }

}


