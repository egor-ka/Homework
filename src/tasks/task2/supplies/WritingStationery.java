package tasks.task2.supplies;

/**
 * Created by Egor on 17.08.2016.
 */
public class WritingStationery extends Stationery{
    protected int lineWidth;

    public WritingStationery(int lineWidth, String producer, int price){
        super(producer, price);
        this.lineWidth = lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }
}
