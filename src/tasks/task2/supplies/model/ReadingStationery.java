package tasks.task2.supplies.model;

/**
 * Created by Egor on 17.08.2016.
 */
public class ReadingStationery extends Stationery {

    public enum PageSize{
        A1,
        A2,
        A3,
        A4,
        A5
    }

    PageSize pageSize;
    int pageNumber;

    public ReadingStationery(PageSize pageSize, int pageNumber, String producer, int price) {
        super(producer, price);
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
