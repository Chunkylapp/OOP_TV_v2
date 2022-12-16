package Input;

import java.util.ArrayList;

public class MovieInput {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    public MovieInput(String name, String year, int duration, ArrayList<String> genres, ArrayList<String> actors, ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
    }

    public MovieInput() {
        this.name = "";
        this.year = "";
        this.duration = 0;
        this.genres = new ArrayList<String>();
        this.actors = new ArrayList<String>();
        this.countriesBanned = new ArrayList<String>();
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

    public void addGenre(String genre) {
        this.genres.add(genre);
    }

    public void addActor(String actor) {
        this.actors.add(actor);
    }

    public void addCountryBanned(String country) {
        this.countriesBanned.add(country);
    }

    public void movieToJSON() {
        // TODO
    }

}
