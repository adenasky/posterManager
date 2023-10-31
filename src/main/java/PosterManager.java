public class PosterManager {
    private String[] repo = new String[0];
    private int movieLimit;

    public PosterManager() {
        this.movieLimit = 5;
    }

    public PosterManager(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public void addMovie(String movie) {
        String[] tmp = new String[repo.length + 1];

        for (int i = 0; i < repo.length; i++) {
            tmp[i] = repo[i];
        }
        tmp[tmp.length - 1] = movie;
        repo = tmp;
    }

    public String[] findAll() {
        return repo;
    }


    public String[] findLast() {
        int resultLength;
        if (repo.length < movieLimit) {
            resultLength = repo.length;
        } else {
            resultLength = movieLimit;
        }
        String[] result = new String[resultLength];
        int copyToIndex = 0;

        for (int i = (repo.length - 1); i >= 0 && copyToIndex < movieLimit; i--) {
            result[copyToIndex] = repo[i];
            copyToIndex++;
        }
        return result;
    }
}