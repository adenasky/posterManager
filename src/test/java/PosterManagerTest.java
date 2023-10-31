import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PosterManagerTest {
    @Test
    public void displayAllMovies() {
        PosterManager manager = new PosterManager();
        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneMovie() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie One");

        String[] actual = manager.findAll();
        String[] expected = {"Movie One"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSeveralMovies() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");

        String[] actual = manager.findAll();
        String[] expected = {"Movie One", "Movie Two", "Movie Three"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesIfLessThanDefaultLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");

        String[] actual = manager.findLast();
        String[] expected = {"Movie Three", "Movie Two", "Movie One"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastFiveMoviesEqualsDefaultLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");
        manager.addMovie("Movie Four");
        manager.addMovie("Movie Five");

        String[] actual = manager.findLast();
        String[] expected = {"Movie Five", "Movie Four","Movie Three", "Movie Two", "Movie One"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastFiveMoviesIfMoreThanDefaultLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");
        manager.addMovie("Movie Four");
        manager.addMovie("Movie Five");
        manager.addMovie("Movie Six");
        manager.addMovie("Movie Seven");

        String[] actual = manager.findLast();
        String[] expected = {"Movie Seven", "Movie Six","Movie Five", "Movie Four", "Movie Three"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesCustomLimit() {
        PosterManager manager = new PosterManager(7);

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");
        manager.addMovie("Movie Four");
        manager.addMovie("Movie Five");
        manager.addMovie("Movie Six");
        manager.addMovie("Movie Seven");

        String[] actual = manager.findLast();
        String[] expected = {"Movie Seven", "Movie Six", "Movie Five", "Movie Four", "Movie Three", "Movie Two", "Movie One"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesIfMoreThanCustomLimit() {
        PosterManager manager = new PosterManager(7);

        manager.addMovie("Movie One");
        manager.addMovie("Movie Two");
        manager.addMovie("Movie Three");
        manager.addMovie("Movie Four");
        manager.addMovie("Movie Five");
        manager.addMovie("Movie Six");
        manager.addMovie("Movie Seven");
        manager.addMovie("Movie Eight");

        String[] actual = manager.findLast();
        String[] expected = {"Movie Eight", "Movie Seven", "Movie Six", "Movie Five", "Movie Four", "Movie Three", "Movie Two"};
        Assertions.assertArrayEquals(expected, actual);
    }
}