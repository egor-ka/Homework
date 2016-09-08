package test.task2.supplies;

import org.junit.Before;
import org.junit.Test;
import tasks.task2.supplies.*;
import tasks.task2.supplies.model.ReadingStationery;
import tasks.task2.supplies.model.Stationery;
import tasks.task2.supplies.realization.Book;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 18.08.2016.
 */
public class PersonTest {
    Person person = new Person();
    Stationery last;

    @Before
    public void prepare(){
        person.addStandartStationerySet();
    }

    @Test
    public void countTest1() {
        assertEquals("Total cost of all items is not right!", 860, person.countCost());
        assertEquals("Total number of items is not right!", 6, person.countItems());
    }

    @Test
    public void checkUnsortiness() {
        last = person.stationery.get(0);
        boolean isSorted = true;

        for (Stationery item: person.stationery) {
            if (last.getName().compareTo(item.getName()) > 0){
                isSorted = false;
            };
            last = item;
        }
        assertEquals("LIST IS SORTED BY NAME BUT IT SHOULD NOT BE", false, isSorted);
    }

    @Test
    public void sortByNameTest() {
        person.sortByName();
        last = person.stationery.get(0);
        for (Stationery item : person.stationery) {
            assertEquals("LIST IS NOT SORTED BY NAME", true, last.getName().compareTo(item.getName()) <= 0);
            last = item;
        }
    }

    @Test
    public void countTest2() {
        person.addItem(new Book("Egor", "Hell's climate", ReadingStationery.PageSize.A1, 60000, "Print for poor", 1000000));

        assertEquals("Total cost of all items is not right!", 1000860, person.countCost());
        assertEquals("Total number of items is not right!", 7, person.countItems());
    }

    @Test
    public void sortByPriceTest() {
        person.sortByPrice();
        last = person.stationery.get(0);
        for (Stationery item : person.stationery) {
            assertEquals("LIST IS NOT SORTED BY PRICE", true, last.getPrice() <= item.getPrice());
            last = item;
        }
    }

    @Test
    public void sortByNameAndPriceTest() {
        person.addStandartStationerySet();

        person.sortByNameAndPrice();
        last = person.stationery.get(0);
        for (Stationery item: person.stationery) {
            if (last.getName().compareTo(item.getName()) != 0){
                assertEquals("LIST IS NOT SORTED BY NAME", true, last.getName().compareTo(item.getName()) < 0);
            }
            if (last.getName().compareTo(item.getName()) == 0){
                assertEquals("LIST IS NOT SORTED BY PRICE", true, last.getPrice() <= item.getPrice());
            }
            last = item;
        }

    }
}
