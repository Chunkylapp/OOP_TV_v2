package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;
import movie.Movie;

/**
 * Class SeeDetails implements the SeeDetails page
 * it implements the PageInterface, and it's built
 * using the Singleton design pattern
 */
public final class SeeDetails implements PageInterface {

    private static SeeDetails instance;
    private String name;

    /**
     * Constructor
     *
     * @param name the page's name
     */
    private SeeDetails(final String name) {
        this.name = name;
    }

    /**
     * Singleton get instance
     *
     * @return instance
     */
    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails("see details");
        }
        return instance;
    }

    /**
     * Page's name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Page's action
     *
     * @param actions  the action to be performed
     * @param dataBase the database
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        String movieName = actions.getMovie();
        if (movieName.equals("")) {
            movieName = dataBase.getCurrentMovie();
        }

        if (actions.getFeature().equals("purchase")) {
            for (Movie movie : dataBase.getMovies()) {
                if (movie.getName().equals(movieName)) {
                    if (!(movie.getCountriesBanned().contains(dataBase.
                            getCurrentUser().getCountry()))) {
                        if (dataBase.getCurrentUser().getAccountType().equals("premium")) {
                            if (dataBase.getCurrentUser().getNumFreePremiumMovies() > 0) {
                                dataBase.getCurrentUser().
                                        setNumFreePremiumMovies(dataBase.getCurrentUser().
                                                getNumFreePremiumMovies() - 1);
                                dataBase.getCurrentUser().getPurchasedMovies().add(movie);
                            } else {
                                if (dataBase.getCurrentUser().getTokensCount() >= 2) {
                                    dataBase.getCurrentUser().
                                            setTokensCount(dataBase.getCurrentUser().
                                                    getTokensCount() - 2);
                                    dataBase.getCurrentUser().getPurchasedMovies().add(movie);
                                }
                            }
                        } else {
                            if (dataBase.getCurrentUser().getTokensCount() >= 2) {
                                dataBase.getCurrentUser().
                                        setTokensCount(dataBase.getCurrentUser().
                                                getTokensCount() - 2);
                                dataBase.getCurrentUser().getPurchasedMovies().add(movie);
                            }
                        }
                    }
                }
            }
            ArrayNode arrayNode = mapper.createArrayNode();
            for (Movie movie : dataBase.getCurrentUser().getPurchasedMovies()) {
                if (movie.getName().equals(movieName)) {
                    arrayNode.add(movie.getJson());
                }
            }
            objectNode.putArray("currentMoviesList").addAll(arrayNode);
            return objectNode;

        }
        if (actions.getFeature().equals("watch")) {
            for (Movie movie : dataBase.getCurrentUser().getPurchasedMovies()) {
                if (movie.getName().equals(movieName)) {
                    dataBase.getCurrentUser().getWatchedMovies().add(movie);
                    break;
                }
            }
            ArrayNode arrayNode = mapper.createArrayNode();
            for (Movie movie : dataBase.getCurrentUser().getWatchedMovies()) {
                if (movie.getName().equals(movieName)) {
                    arrayNode.add(movie.getJson());
                }
            }
            objectNode.putArray("currentMoviesList").addAll(arrayNode);
            return objectNode;
        }

        if (actions.getFeature().equals("like")) {
            for (Movie movie : dataBase.getCurrentUser().getWatchedMovies()) {
                if (movie.getName().equals(movieName)) {
                    movie.setNumLikes(movie.getNumLikes() + 1);
                    dataBase.getCurrentUser().getLikedMovies().add(movie);
                    break;
                }
            }
            ArrayNode arrayNode = mapper.createArrayNode();
            for (Movie movie : dataBase.getCurrentUser().getLikedMovies()) {
                if (movie.getName().equals(movieName)) {
                    arrayNode.add(movie.getJson());
                }
            }
            objectNode.putArray("currentMoviesList").addAll(arrayNode);
            return objectNode;
        }
        if (actions.getFeature().equals("rate")) {
            for (Movie movie : dataBase.getCurrentUser().getWatchedMovies()) {
                if (movie.getName().equals(movieName)
                        && actions.getRate() >= 0 && actions.getRate() <= 5) {
                    movie.setTotalRating(movie.getTotalRating() + actions.getRate());
                    movie.setNumRatings(movie.getNumRatings() + 1);
                    movie.setRating(movie.getTotalRating() / movie.getNumRatings());
                    dataBase.getCurrentUser().getRatedMovies().add(movie);
                    break;
                }
            }
            ArrayNode arrayNode = mapper.createArrayNode();
            for (Movie movie : dataBase.getCurrentUser().getRatedMovies()) {
                if (movie.getName().equals(movieName)) {
                    arrayNode.add(movie.getJson());
                }
            }
            objectNode.putArray("currentMoviesList").addAll(arrayNode);
            return objectNode;
        }

        return null;
    }
}
