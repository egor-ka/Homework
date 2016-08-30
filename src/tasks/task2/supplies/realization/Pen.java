package tasks.task2.supplies.realization;

import tasks.task2.supplies.model.WritingStationery;

/**
 * Created by Egor on 17.08.2016.
 */
public class Pen extends WritingStationery {
    private String color;

    public Pen(String color, int lineWidth, String producer, int price){
        super(lineWidth, producer, price);
        this.color = color;
        this.name = "Pen";
    }

    @Override
    public boolean equals(Object obj) {
        return color.equals(((Pen)obj).color) &&
                lineWidth == ((Pen)obj).lineWidth &&
                producer.equals(((Pen)obj).producer) &&
                price == ((Pen)obj).price;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = result * 31 + name.hashCode();
        result = result * 31 + color.hashCode();
        result = result * 31 + lineWidth;
        result = result * 31 + producer.hashCode();
        result = result * 31 + price;

        return result;
    }

    @Override
    public String toString() {
        String penStats;

        penStats = "Color = " + color + " lineWidth = " + lineWidth + " producer: \"" + producer + "\", price = " + price;
        return penStats;
    }
}
