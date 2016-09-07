package tasks.task3.task3_1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 02.09.2016.
 */
public class CrazyLogger {

    private StringBuilder stringBuilder = new StringBuilder();

    public void addMessage(String message) {
        String logString;
        Calendar dateTime = Calendar.getInstance();
        logString = dateTime.get(Calendar.DAY_OF_MONTH) + "-" +
                dateTime.get(Calendar.MONTH) + "-" +
                dateTime.get(Calendar.YEAR) + " : " +
                dateTime.get(Calendar.HOUR) + "-" +
                dateTime.get(Calendar.MINUTE) + " - " +
                message + ";";
        stringBuilder.append(logString);
    }

    public ArrayList<String> findMessageByText(String message) {
        Pattern patternMessage = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}\\s:\\s\\d{1,2}-\\d{1,2}\\s-\\s[^;]*" + message + "[^;]*;");
        Matcher matcherTextString = patternMessage.matcher(stringBuilder);

        ArrayList<String> messageList = new ArrayList<>();
        int index = 0;
        while (matcherTextString.find(index)) {
            messageList.add(matcherTextString.group());
            index = matcherTextString.end();
        }
        return messageList;
    }

    public ArrayList<String> findMessageByDate(int day, int month, int year) {
        Pattern patternMessage = Pattern.compile(day + "-" + month + "-" + year + "\\s:\\s\\d{1,2}-\\d{1,2}\\s-\\s[^;]*;");
        Matcher matcherTextString = patternMessage.matcher(stringBuilder);

        ArrayList<String> messageList = new ArrayList<>();
        int index = 0;
        while (matcherTextString.find(index)) {
            messageList.add(matcherTextString.group());
            index = matcherTextString.end();
        }
        return messageList;
    }
}
