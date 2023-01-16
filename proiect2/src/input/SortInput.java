package input;

/**
 * Class SortInput implements a sort input
 * it holds the sort type and the sort criteria
 * it is used to sort the movies
 */
public class SortInput {
    private String rating;
    private String duration;

    /**
     * Constructor
     * @param rating the rating
     * @param duration the duration
     */
    public SortInput(final String rating, final String duration) {
        this.rating = rating;
        this.duration = duration;
    }

    /**
     * Default cnstructor
     */
    public SortInput() {
        this.rating = "";
        this.duration = "";
    }

    /**
     * Rating getter
     * @return rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Duration getter
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Rating setter
     * @param rating the rating
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * Duration setter
     * @param duration the duration
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
