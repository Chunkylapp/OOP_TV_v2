package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

/**
 * Class that represents a movie.
 */
public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numLikes;

    private int numRatings;

    private double rating;

    private double totalRating;

    /**
     * Constructor for the movie class.
     * @param name The name of the movie.
     * @param year The year the movie was released.
     * @param duration The duration of the movie.
     * @param genres The genres of the movie.
     * @param actors The actors in the movie.
     * @param countriesBanned The countries that banned the movie.
     */
    public Movie(final String name, final String year,
                 final int duration, final ArrayList<String> genres,
                 final ArrayList<String> actors, final ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
        this.numLikes = 0;
        this.numRatings = 0;
        this.rating = 0;
        this.totalRating = 0;
    }

    /**
     * Default constructor for the movie class.
     */
    public Movie() {
        this.name = "";
        this.year = "";
        this.duration = 0;
        this.genres = new ArrayList<String>();
        this.actors = new ArrayList<String>();
        this.countriesBanned = new ArrayList<String>();
        this.numLikes = 0;
        this.numRatings = 0;
        this.rating = 0;
        this.totalRating = 0;
    }

    /**
     * Getter for the name of the movie.
     * @return The name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the year the movie was released.
     * @return The year the movie was released.
     */
    public String getYear() {
        return year;
    }

    /**
     * Getter for the duration of the movie.
     * @return The duration of the movie.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Getter for the genres of the movie.
     * @return The genres of the movie.
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Getter for the actors in the movie.
     * @return The actors in the movie.
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * Getter for the countries that banned the movie.
     * @return The countries that banned the movie.
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * Getter for the number of likes the movie has.
     * @return The number of likes the movie has.
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * Getter for the number of ratings the movie has.
     * @return The number of ratings the movie has.
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * Getter for the rating of the movie.
     * @return The rating of the movie.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Getter for the total rating of the movie.
     * @return  totalRating The total rating of the movie.
     */
    public double getTotalRating() {
        return totalRating;
    }

    /**
     * Setter for the name of the movie.
     * @param name The name of the movie.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Setter for the year the movie was released.
     * @param year The year the movie was released.
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * Setter for the duration of the movie.
     * @param duration The duration of the movie.
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * Setter for the genres of the movie.
     * @param genres The genres of the movie.
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * Setter for the actors in the movie.
     * @param actors The actors in the movie.
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * Setter for the countries that banned the movie.
     * @param countriesBanned The countries that banned the movie.
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     * Setter for the number of likes the movie has.
     * @param numLikes The number of likes the movie has.
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * Setter for the number of ratings the movie has.
     * @param numRatings The number of ratings the movie has.
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /**
     * Setter for the rating of the movie.
     * @param rating The rating of the movie.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Setter for the total rating of the movie.
     * @param totalRating The total rating of the movie.
     */
    public void setTotalRating(final double totalRating) {
        this.totalRating = totalRating;
    }

    /**
     * Adds a like to the movie.
     */
    public void addGenre(final String genre) {
        this.genres.add(genre);
    }

    /**
     * Adds an actor to the movie.
     */
    public void addActor(final String actor) {
        this.actors.add(actor);
    }

    /**
     * Adds a country that banned the movie.
     */
    public void addCountryBanned(final String country) {
        this.countriesBanned.add(country);
    }

    /**
     * Returns a JSON representation of the movie.
     * @return The JSON representation of the movie.
     */
    public ObjectNode getJson() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode movie = mapper.createObjectNode();

        movie.put("name", name);
        movie.put("year", Integer.valueOf(year));
        movie.put("duration", duration);
        ArrayNode genresArray = mapper.createArrayNode();
        for (String genre : genres) {
            genresArray.add(genre);
        }
        movie.set("genres", genresArray);
        ArrayNode actorsArray = mapper.createArrayNode();
        for (String actor : actors) {
            actorsArray.add(actor);
        }
        movie.set("actors", actorsArray);
        ArrayNode countriesBannedArray = mapper.createArrayNode();
        for (String country : countriesBanned) {
            countriesBannedArray.add(country);
        }
        movie.set("countriesBanned", countriesBannedArray);

        movie.put("numLikes", numLikes);
        movie.put("numRatings", numRatings);
        movie.put("rating", (float) rating);

        return movie;
    }
}
