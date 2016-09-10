package tasks.task4.task4_4;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Egor on 10.09.2016.
 */
public class MovieList {

    private static final String FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/tasks/task4/task4_4/movie_list.txt";

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieList() throws IOException, ClassNotFoundException {
     //   restore();
    }

    public void save() throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Movie movie: movies) {
                objectOutputStream.writeObject(movie);
            }
        }
    }

    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (objectInputStream.available() > 0) {
                movies.add((Movie) objectInputStream.readObject());
                System.out.println(movies.size());
            }
        }
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public void remove(Movie movie) {
        movies.remove(movie);
    }

    public void remove(int index) {
        movies.remove(index);
    }
}
