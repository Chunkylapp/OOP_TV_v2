package input;

import java.util.ArrayList;

/**
 * Class FiltersInput implements a class that holds the filters
 * for the movies
 */
public class FiltersInput {

    /**
     * Internal class for filters with multiple values
     */
    public class Contains {
        private ArrayList<String> genre;
        private ArrayList<String> actors;


        /**
         * Default constructor
         */
        public Contains() {
            this.genre = new ArrayList<>();
            this.actors = new ArrayList<>();
        }

        /**
         * Constructor with parameters
         *
         * @param genre  genre
         * @param actors actors
         */
        public Contains(final ArrayList<String> genre, final ArrayList<String> actors) {
            this.genre = genre;
            this.actors = actors;
        }

        /**
         * Genre getter
         *
         * @return genre
         */
        public ArrayList<String> getGenre() {
            return genre;
        }

        /**
         * Genre setter
         *
         * @return genre
         */
        public void setGenre(final ArrayList<String> genre) {
            this.genre = genre;
        }

        /**
         * Actors getter
         *
         * @return actors
         */
        public ArrayList<String> getActors() {
            return actors;
        }

        /**
         * Actors setter
         *
         * @return actors
         */
        public void setActors(final ArrayList<String> actors) {
            this.actors = actors;
        }
    }

    private SortInput sort;
    private Contains contains;

    /**
     * Default constructor
     */
    public FiltersInput() {
        this.sort = new SortInput();
        this.contains = new Contains();
    }

    /**
     * Constructor with parameters
     *
     * @param sort     sort
     * @param contains contains
     */
    public FiltersInput(final SortInput sort, final Contains contains) {
        this.sort = sort;
        this.contains = contains;
    }

    /**
     * Sort getter
     *
     * @return sort
     */
    public SortInput getSort() {
        return sort;
    }

    /**
     * Sort setter
     *
     * @return sort
     */
    public void setSort(final SortInput sort) {
        this.sort = sort;
    }

    /**
     * Contains getter
     *
     * @return
     */
    public Contains getContains() {
        return contains;
    }

    /**
     * Contains setter
     *
     * @return
     */
    public void setContains(final Contains contains) {
        this.contains = contains;
    }
}
