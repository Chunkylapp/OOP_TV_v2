package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

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

    public Movie(String name, String year, int duration, ArrayList<String> genres, ArrayList<String> actors, ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
        this.numLikes = 0;
        this.numRatings = 0;
        this.rating = 0;
    }

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
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addGenre(String genre) {
        this.genres.add(genre);
    }

    public void addActor(String actor) {
        this.actors.add(actor);
    }

    public void addCountryBanned(String country) {
        this.countriesBanned.add(country);
    }

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
        movie.put("rating", rating);

        return movie;
    }
}
