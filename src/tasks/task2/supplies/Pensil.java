package tasks.task2.supplies;

/**
 * Created by Egor on 18.08.2016.
 */
public class Pensil extends WritingStationery{
    boolean hardness;

    public Pensil(boolean hardness, int lineWidth, String producer, int price) {
        super(lineWidth, producer, price);
        this.hardness = hardness;
        this.name = "Pensil";
    }
}
