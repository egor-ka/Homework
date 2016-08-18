package tasks.task2.supplies;

/**
 * Created by Egor on 17.08.2016.
 */
public class Book extends ReadingStationery {
    String author;
    String title;

    public Book(String author, String title, PageSize pageSize, int pageNumber, String producer, int price){
        super(pageSize, pageNumber, producer, price);
        this.author = author;
        this.title = title;
        this.name = "Book";
    }

}
