package tasks.task2.supplies.realization;

import tasks.task2.supplies.model.ReadingStationery;

/**
 * Created by Egor on 18.08.2016.
 */
public class Notepad extends ReadingStationery {
    private boolean hasSpring;

    public Notepad(boolean hasSpring, PageSize pageSize, int pageNumber, String producer, int price) {
        super(pageSize, pageNumber, producer, price);
        this.hasSpring = hasSpring;
        this.name = "Notepad";
    }
}
