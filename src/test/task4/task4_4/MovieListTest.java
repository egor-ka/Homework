package test.task4.task4_4;

import org.junit.Before;
import org.junit.Test;
import tasks.task4.task4_4.Actor;
import tasks.task4.task4_4.Movie;
import tasks.task4.task4_4.MovieList;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 10.09.2016.
 */
public class MovieListTest {

    MovieList movieList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        movieList = new MovieList();
        movieList.add(new Movie("Taxi", 1998, new Actor("Samy", "Naceri"), new Actor("Frederic", "Diefenthal")));
        movieList.add(new Movie("Wasabi", 2001, new Actor("Jean", "Reno")));
    }

    @Test
    public void saveAndRestoreTest() throws IOException, ClassNotFoundException {
        movieList.save();
        movieList.restore();

        assertEquals("Restore failed(1)", "Taxi", movieList.getMovies().get(0).getTitle());
        assertEquals("Restore failed(2)", "Wasabi", movieList.getMovies().get(1).getTitle());

        movieList.add(new Movie("Movie Name", 2016, new Actor("FirstName", "LastName")));
        movieList.remove(1);

        movieList.save();
        movieList.restore();

        assertEquals("Restore failed(1)", "Taxi", movieList.getMovies().get(0).getTitle());
        assertEquals("Restore failed(2)", "Movie Name", movieList.getMovies().get(1).getTitle());
    }
}
