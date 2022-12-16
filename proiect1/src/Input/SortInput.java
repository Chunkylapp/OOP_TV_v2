package Input;

public class SortInput {
    private String rating;
    private String duration;

    public SortInput(String rating, String duration) {
        this.rating = rating;
        this.duration = duration;
    }

    public SortInput() {
        this.rating = "";
        this.duration = "";
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
