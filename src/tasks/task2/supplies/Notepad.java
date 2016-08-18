package tasks.task2.supplies;

/**
 * Created by Egor on 18.08.2016.
 */
public class Notepad extends ReadingStationery{
    boolean hasSpring;

    public Notepad(boolean hasSpring, PageSize pageSize, int pageNumber, String producer, int price) {
        super(pageSize, pageNumber, producer, price);
        this.hasSpring = hasSpring;
        this.name = "Notepad";
    }
}
