package tasks.task3.task3_2;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Egor on 08.09.2016.
 */
public class LocalePractice {

    private Locale currentLocale;
    private ResourceBundle questionsAndAnswersBundle;

    public static final String DEFAULT_BUNDLE_PATH = "resources.task3.task3_2.questions_and_answers";
    public static final Locale LOCALE_RU = new Locale("ru");
    public static final Locale LOCALE_EN = new Locale("en");

    public LocalePractice() {
        currentLocale = LOCALE_RU;
        questionsAndAnswersBundle = ResourceBundle.getBundle(DEFAULT_BUNDLE_PATH, currentLocale);
    }

    public void showQuestions() throws UnsupportedEncodingException {
        String questionName;
        int questionNumber = 1;

        while (questionsAndAnswersBundle.containsKey(questionName = "question.key" + questionNumber)) {
            String value = questionsAndAnswersBundle.getString(questionName);
            String valueUTF8 = new String(value.getBytes("ISO-8859-1"),  "windows-1251");
            System.out.println(questionNumber + ") " + valueUTF8);
            questionNumber++;
        }
    }

    public String getAnswer(int questionNumber) throws UnsupportedEncodingException {
        String answerName = "answer.key" + questionNumber;

        if (questionsAndAnswersBundle.containsKey(answerName)) {
            String value = questionsAndAnswersBundle.getString(answerName);
            String valueWin1251 = new String(value.getBytes("ISO-8859-1"),  "windows-1251");
            System.out.println("Answer for question number " + questionNumber + " is: " + valueWin1251);
            return valueWin1251;
        }
        System.out.println("There is no question with such number! (" + questionNumber + ")");
        return null;
    }

    public void reload(Locale locale) {
        this.currentLocale = locale;
        questionsAndAnswersBundle = ResourceBundle.getBundle(DEFAULT_BUNDLE_PATH, currentLocale);
    }

    public void setCurrentLocaleEn() {
        reload(LOCALE_EN);
    }

    public void setCurrentLocaleRu() {
        reload(LOCALE_RU);
    }
}
