package tasks.task1.task1_6;

import java.util.Calendar;

/**
 * Created by Egor on 17.08.2016.
 */
public class Note {

    private String text;
    private String userName;
    private Calendar date;
    private boolean isDeleted;

    public Note(String text, String userName){
        this.text = text;
        this.userName = userName;
        this.date = Calendar.getInstance();
        this.isDeleted = false;
    }

    public Note(String text){
        this(text, "Unknown writer");
    }

    public Note(){
        this("", "");
    }

    public void printNote(){
        System.out.println(date.get(Calendar.DAY_OF_MONTH) + ":" + date.get(Calendar.MONTH) + ":" + date.get(Calendar.YEAR) + ", " + userName + ":\"" + text + "\"");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Calendar getDate() {
        return date;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
