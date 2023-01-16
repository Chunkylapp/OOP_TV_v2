package input;

import java.util.ArrayList;

/**
 * Class MovieInput implements a movie input
 *  for better parsing of the input from a JSON file
 */
public class MovieInput {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    /**
     * Constructor
     * @param name movie name
     * @param year movie year
     * @param duration movie duration
     * @param genres movie genres
     * @param actors movie actors
     * @param countriesBanned movie countries banned
     */
    public MovieInput(final String name, final String year,
                      final int duration, final ArrayList<String> genres,
                      final ArrayList<String> actors, final ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
    }

    /**
     * Default constructor
     */
    public MovieInput() {
        this.name = "";
        this.year = "";
        this.duration = 0;
        this.genres = new ArrayList<String>();
        this.actors = new ArrayList<String>();
        this.countriesBanned = new ArrayList<String>();
    }

    /**
     * Name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Year getter
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Duration getter
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Genres getter
     * @return genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Actors getter
     * @return actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * Countries banned getter
     * @return countriesBanned
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * Name setter
     * @param name movie name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Year setter
     * @param year movie year
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * Duration setter
     * @param duration movie duration
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * Genres setter
     * @param genres movie genres
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * Actors setter
     * @param actors movie actors
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * Countries banned setter
     * @param countriesBanned movie countries banned
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     * Method that adds a genre to the movie
     * @param genre genre to be added
     */
    public void addGenre(final String genre) {
        this.genres.add(genre);
    }

    /**
     * Method that adds an actor to the movie
     * @param actor actor to be added
     */
    public void addActor(final String actor) {
        this.actors.add(actor);
    }

    /**
     * Method that adds a country banned to the movie
     * @param country country banned to be added
     */
    public void addCountryBanned(final String country) {
        this.countriesBanned.add(country);
    }

}
