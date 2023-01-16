package pages;

import input.ActionsInput;
import input.SortInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;
import movie.Movie;

import java.util.ArrayList;
import java.util.Comparator;

public final class Movies implements PageInterface {

    private static Movies instance;
    private String name;

    /**
     * Constructor for the movies class.
     *
     * @param name The name of the page.
     */
    private Movies(final String name) {
        this.name = name;
    }

    /**
     * Method that returns the instance of the movies class.
     *
     * @return The instance of the movies class.
     */
    public static Movies getInstance() {
        if (instance == null) {
            instance = new Movies("movies");
        }
        return instance;
    }

    /**
     * Method that returns the name of the page.
     *
     * @return The name of the page.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that implements functions caracteristic to the movies page.
     *
     * @param actions  The action to be performed alongside other parameters.
     * @param dataBase The database.
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode out = mapper.createObjectNode();
        ArrayList<Movie> movies = new ArrayList<>();

        switch (actions.getFeature()) {
            case "search" -> {
                if (actions.getStartsWith() != null) {
                    for (Movie movie : dataBase.getCurrentMovies()) {
                        if (movie.getName().startsWith(actions.getStartsWith())) {
                            movies.add(movie);
                            break;
                        }
                    }
                }
                for (Movie movie : movies) {
                    if (movie.getName().contains(actions.getStartsWith())) {
                        if ((movie.getCountriesBanned().contains(dataBase.
                                getCurrentUser().getCountry()))) {
                            movies.remove(movie);
                        }
                    }
                }
                ArrayNode arrayNode = mapper.createArrayNode();
                for (Movie movie : movies) {
                    arrayNode.add(movie.getJson());
                }
                out.set("currentMoviesList", arrayNode);
                return out;
            }
            case "filter" -> {
                SortInput sort = actions.getFilters().getSort();
                ArrayList<Movie> moviesList = dataBase.getMovies();
                if (actions.getFilters().getContains() != null) {
                    if (actions.getFilters().getContains().getActors().size() > 0) {
                        ArrayList<Movie> newMoviesList = new ArrayList<>();
                        for (Movie movie : moviesList) {
                            boolean shouldKeepMovie = true;
                            for (String actor : actions.getFilters().getContains().getActors()) {
                                if (!movie.getActors().contains(actor)) {
                                    if (!(movie.getCountriesBanned().contains(dataBase.
                                            getCurrentUser().getCountry()))) {
                                        shouldKeepMovie = false;
                                        break;
                                    }
                                }
                            }
                            if (shouldKeepMovie) {
                                newMoviesList.add(movie);
                            }
                        }
                        moviesList = newMoviesList;
                    }
                    if (actions.getFilters().getContains().getGenre().size() > 0) {
                        ArrayList<Movie> newMoviesList = new ArrayList<>();
                        for (Movie movie : moviesList) {
                            boolean shouldKeepMovie = true;
                            for (String genre : actions.getFilters().getContains().getGenre()) {
                                if (!movie.getGenres().contains(genre)) {
                                    if (!(movie.getCountriesBanned().contains(dataBase.
                                            getCurrentUser().getCountry()))) {
                                        shouldKeepMovie = false;
                                        break;
                                    }
                                }
                            }
                            if (shouldKeepMovie) {
                                newMoviesList.add(movie);
                            }
                        }
                        moviesList = newMoviesList;
                    }
                }
                if (sort != null) {
                    if (sort.getRating() != "") {
                        // sort by rating
                        if (sort.getRating().equals("decreasing")) {
                            moviesList.sort((o1, o2) -> Double.
                                    compare(o2.getRating(), o1.getRating()));
                        } else {
                            moviesList.sort(Comparator.comparingDouble(Movie::getRating));
                        }
                    }
                    if (sort.getDuration() != "") {
                        // sort by duration
                        if (sort.getDuration().equals("decreasing")) {
                            moviesList.sort((o1, o2) -> (o2.getDuration() - o1.getDuration()));
                        } else {
                            moviesList.sort(Comparator.comparingInt(Movie::getDuration));
                        }
                    }
                    for (Movie movie : moviesList) {
                        if (!(movie.getCountriesBanned().contains(dataBase.
                                getCurrentUser().getCountry()))) {
                            movies.add(movie);
                        }
                    }
                    ArrayNode arrayNode2 = mapper.createArrayNode();
                    for (Movie movie : movies) {
                        arrayNode2.add(movie.getJson());
                    }
                    out.put("currentMoviesList", arrayNode2);
                }
                dataBase.setCurrentMovies(movies);
                return out;
            }
            default -> {
                return null;
            }
        }
    }
}
