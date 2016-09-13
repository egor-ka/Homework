package tasks.task3.task3_1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 02.09.2016.
 */
public class CrazyLogger {

    private StringBuilder stringBuilder = new StringBuilder();

    public void addMessage(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm - ");
        stringBuilder.append(dateFormat.format(new Date())).append(message).append(";");
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
