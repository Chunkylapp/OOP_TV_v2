package user;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import movie.Movie;

import java.util.ArrayList;

/**
 * Interface for user classes
 */
public interface UserInterface {

    /**
     * Getter for the name of the user
     *
     * @return the name of the user
     */
    String getName();

    /**
     * Getter for the password of the user
     *
     * @return the password of the user
     */
    String getPassword();

    /**
     * Getter for the account type of the user
     *
     * @return the account type of the user
     */
    String getAccountType();

    /**
     * Getter for the country of the user
     *
     * @return the country of the user
     */
    String getCountry();

    /**
     * Getter for the balance of the user
     *
     * @return the balance of the user
     */
    int getBalance();

    /**
     * Getter for the tokens of the user
     *
     * @return the tokens of the user
     */
    int getTokensCount();

    /**
     * Getter for the ammount of free premium movies
     *
     * @return the ammount of free premium movies
     */
    int getNumFreePremiumMovies();

    /**
     * Setter for the name of the user
     *
     * @param name the name of the user
     */
    void setName(String name);

    /**
     * Setter for the password of the user
     *
     * @param password the password of the user
     */
    void setPassword(String password);

    /**
     * Setter for the account type of the user
     *
     * @param accountType the account type of the user
     */
    void setAccountType(String accountType);

    /**
     * Setter for the country of the user
     *
     * @param country the country of the user
     */
    void setCountry(String country);

    /**
     * Setter for the balance of the user
     *
     * @param balance the balance of the user
     */
    void setBalance(int balance);

    /**
     * Setter for the tokens of the user
     *
     * @param tokensCount the tokens of the user
     */
    void setTokensCount(int tokensCount);

    /**
     * Setter for the ammount of free premium movies
     *
     * @param numFreePremiumMovies the ammount of free premium movies
     */
    void setNumFreePremiumMovies(int numFreePremiumMovies);

    /**
     * Method used for comparing hashed passwords
     *
     * @param hashedPass the hashed password
     * @return true if the passwords match, false otherwise
     */
    boolean comparePassHash(String hashedPass);

    /**
     * Getter for the purchased movies of the user
     *
     * @return the purchased movies of the user
     */
    ArrayList<Movie> getPurchasedMovies();

    /**
     * Getter for the favorite movies of the user
     *
     * @return the favorite movies of the user
     */
    ArrayList<Movie> getWatchedMovies();

    /**
     * Getter for the liked movies of the user
     *
     * @return the liked movies of the user
     */
    ArrayList<Movie> getLikedMovies();

    /**
     * Getter for the rated movies of the user
     *
     * @return the rated movies of the user
     */
    ArrayList<Movie> getRatedMovies();

    /**
     * Method converts the purchased movies to a JSON array
     *
     * @return the purchased movies as a JSON array
     */
    ArrayNode getPurchasedMoviesJson();

    /**
     * Method converts the watched movies to JSON array
     *
     * @return the watched movies as a JSON array
     */
    ArrayNode getWatchedMoviesJson();

    /**
     * Method converts the liked movies to JSON array
     *
     * @return the liked movies as a JSON array
     */
    ArrayNode getLikedMoviesJson();

    /**
     * Method converts the rated movies to JSON array
     *
     * @return the rated movies as a JSON array
     */
    ArrayNode getRatedMoviesJson();

    /**
     * Method converts the user to a JSON object
     *
     * @return the user as a JSON object
     */
    ObjectNode getJson();

}
