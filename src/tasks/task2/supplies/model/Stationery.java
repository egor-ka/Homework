package tasks.task2.supplies.model;

import java.util.Comparator;

/**
 * Created by Egor on 17.08.2016.
 */
public class Stationery{
    protected String name;
    protected String producer;
    protected int price;

    public static final Comparator<Stationery> NAME_ORDER =
            new Comparator<Stationery>() {
                public int compare(Stationery set1, Stationery set2) {
                    return set1.name.compareTo(set2.name);
                }
            };

    public static final Comparator<Stationery> PRICE_ORDER =
            new Comparator<Stationery>() {
                public int compare(Stationery set1, Stationery set2) {
                    return set1.price - set2.price;
                }
            };

    public static final Comparator<Stationery> NAME_AND_PRICE_ORDER =
            new Comparator<Stationery>() {
                public int compare(Stationery set1, Stationery set2) {
                    if (set1.name.compareTo(set2.name) != 0){
                        return set1.name.compareTo(set2.name);
                    }
                    if (set1.name.compareTo(set2.name) == 0 && set1.price - set2.price != 0){
                        return set1.price - set2.price;
                    }
                    return 0;
                }
            };


    public Stationery(String producer, int price){
        this.producer = producer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
