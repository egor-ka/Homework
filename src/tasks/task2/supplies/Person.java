package tasks.task2.supplies;

import tasks.task2.supplies.model.Stationery;

import java.util.ArrayList;

import static tasks.task2.supplies.StandardStationerySet.getStandardStationerySet;
import static tasks.task2.supplies.model.Stationery.NAME_AND_PRICE_ORDER;
import static tasks.task2.supplies.model.Stationery.NAME_ORDER;
import static tasks.task2.supplies.model.Stationery.PRICE_ORDER;

/**
 * Created by Egor on 18.08.2016.
 */
public class Person {
    public ArrayList<Stationery> stationery = new ArrayList<>();

    public void addItem(Stationery item){
        stationery.add(item);
    }

    public void addStandartStationerySet(){
        stationery.addAll(getStandardStationerySet());
    }

    public int countItems(){
        return stationery.size();
    }

    public int countCost(){
        int totalCost = 0;
        for (Stationery item: stationery) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }


    public void sortByName(){
        stationery.sort(NAME_ORDER);
    }

    public void sortByPrice(){
        stationery.sort(PRICE_ORDER);
    }

    public void sortByNameAndPrice(){
        stationery.sort(NAME_AND_PRICE_ORDER);
    }
}
