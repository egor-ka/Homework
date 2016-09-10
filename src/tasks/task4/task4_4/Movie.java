package tasks.task4.task4_4;

import java.io.Serializable;

/**
 * Created by Egor on 10.09.2016.
 */
public class Movie implements Serializable{

    private String title;
    private int year;
    private Actor[] mainActors;

    public Movie(String title, int year, Actor... mainActors) {
        this.title = title;
        this.year = year;
        this.mainActors = mainActors;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = result * 31 + title.hashCode();
        result = result * 31 + year;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return title.equals(((Movie)obj).getTitle()) &&
                year == ((Movie)obj).getYear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
}
