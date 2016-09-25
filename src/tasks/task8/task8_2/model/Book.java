package tasks.task8.task8_2.model;

/**
 * Created by Egor on 19.09.2016.
 */
public class Book {

    private int id;
    private String author;
    private String title;
    private int cost;

    public Book(int id, String author, String title, int cost) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.cost = cost;
    }

    public Book(String author, String title, int cost) {
        this(0, author, title, cost);
    }

    public void print() {
        System.out.println(id + ": " + title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(final Object obj) {
        boolean isEqual = false;
        if (this == obj) {
            isEqual = true;
        } else if (obj != null && getClass() == obj.getClass()) {
            final Book book = (Book) obj;
            if (getId() == book.getId()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return "Book[id=" + getId() +  ", author" + getAuthor() + ", title=" + getTitle() + ", cost=" + getCost();
    }
}
