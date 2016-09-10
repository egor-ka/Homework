package tasks.task4.task4_4;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Egor on 10.09.2016.
 */
public class MovieList {

    private static final String FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_4/movie_list.ser";
    private ArrayList<Movie> movies;

    public MovieList() throws IOException, ClassNotFoundException {
        movies = new ArrayList<>();
    }

    public void save() throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(movies);
            objectOutputStream.flush();
        }
    }

    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            movies = ((ArrayList<Movie>) objectInputStream.readObject());
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

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
