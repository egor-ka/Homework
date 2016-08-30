package tasks.task2.supplies;

import tasks.task2.supplies.model.ReadingStationery;
import tasks.task2.supplies.model.Stationery;
import tasks.task2.supplies.realization.Book;
import tasks.task2.supplies.realization.Notepad;
import tasks.task2.supplies.realization.Pen;
import tasks.task2.supplies.realization.Pensil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Egor on 18.08.2016.
 */
public class StandardStationerySet{

    static ArrayList<Stationery> stationery =
            new ArrayList<Stationery>(Arrays.asList(
                    new Pensil(false, 1, "WunderWaffel", 30),
                    new Pen("Red", 2, "InkSpots", 90),
                    new Pen("Green", 1, "InkSpots", 70),
                    new Pen("Black", 1, "InkSpots", 70),
                    new Book("Egor", "How to sleep", ReadingStationery.PageSize.A5, 150, "Print for poor", 100),
                    new Notepad(true, ReadingStationery.PageSize.A4, 50, "Paper King", 500)));

    public static ArrayList<Stationery> getStandardStationerySet() {
        return stationery;
    }
}
