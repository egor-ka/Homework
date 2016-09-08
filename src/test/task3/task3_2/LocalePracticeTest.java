package test.task3.task3_2;

import org.junit.Test;
import tasks.task3.task3_2.LocalePractice;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 08.09.2016.
 */
public class LocalePracticeTest {

    LocalePractice localePractice = new LocalePractice();

    @Test
    public void averageLocaleEnTest() throws UnsupportedEncodingException {
        localePractice.setCurrentLocaleEn();
        localePractice.showQuestions();

        assertEquals("Wrong answer(1 en)", "Elephant", localePractice.getAnswer(1));
        assertEquals("Wrong answer(2 en)", "Whale", localePractice.getAnswer(2));

        assertEquals("We do not have this question(3 ru)", null, localePractice.getAnswer(3));
    }

    @Test
    public void averageLocaleRuTest() throws UnsupportedEncodingException {
        localePractice.setCurrentLocaleRu();
        localePractice.showQuestions();

        assertEquals("Wrong answer(1 ru)", "Слон", localePractice.getAnswer(1));
        assertEquals("Wrong answer(2 ru)", "Кит", localePractice.getAnswer(2));

        assertEquals("We do not have this question(3 ru)", null, localePractice.getAnswer(3));
    }


}
