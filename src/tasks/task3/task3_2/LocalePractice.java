package tasks.task3.task3_2;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Egor on 08.09.2016.
 */
public class LocalePractice {

    private Locale currentLocale;
    private ResourceBundle questionsBundle;
    private ResourceBundle answersBundle;

    Locale localeRu = new Locale("ru");
    Locale localeEn = new Locale("en");

    public LocalePractice() {
        currentLocale = localeRu;
        questionsBundle = ResourceBundle.getBundle("resourses.question", currentLocale);
    }

    public void showQuestions() {
        String question;
        Enumeration<String> keys = questionsBundle.getKeys();

        for (int questionNumber = 1; keys.hasMoreElements(); questionNumber++) {
            String value = questionsBundle.getString(keys.nextElement());
            System.out.println(questionNumber + ") " + value);
        }
    }

    public void getAnswer(int questionNumber) {
        if (answersBundle.containsKey("answers.key" + questionNumber)) {
            System.out.println("Answer for question number " + questionNumber + " is: '" + answersBundle.getString("answers.key" + questionNumber));
        }
    }

    public void reload(Locale locale) {
        this.currentLocale = locale;
        questionsBundle = ResourceBundle.getBundle("resourses.question", currentLocale);
        answersBundle = ResourceBundle.getBundle("resourses.answer", currentLocale);
    }

    public void setCurrentLocaleEn() {
        reload(localeEn);
    }

    public void setCurrentLocaleRu() {
        reload(localeRu);
    }
}
