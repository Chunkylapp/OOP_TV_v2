package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import movie.Movie;
import notification.Notification;

import java.util.ArrayList;

/**
 * Class that represents a standard user.
 */
public class StandardUser implements UserInterface {

    private String name;
    private String password;
    private String accountType;
    private String country;
    private int balance;
    private int tokensCount;
    private int numFreePremiumMovies;
    // new array list of strings for premium movies
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<Notification> notifications;
    private ArrayList<String> subscribedGenres;

    /**
     * Constructor for StandardUser
     * @param name name of the user
     * @param password password of the user
     * @param accountType account type of the user
     * @param country country of the user
     * @param balance balance of the user
     */
    public StandardUser(final String name, final String password,
                        final String accountType, final String country,
                        final int balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
        purchasedMovies = new ArrayList<Movie>();
        watchedMovies = new ArrayList<Movie>();
        likedMovies = new ArrayList<Movie>();
        ratedMovies = new ArrayList<Movie>();
        notifications = new ArrayList<Notification>();
        subscribedGenres = new ArrayList<String>();
    }

    /**
     * Default constructor
     */
    public StandardUser() {
        this.name = "";
        this.password = "";
        this.accountType = "false";
        this.country = "";
        this.balance = 0;
        this.tokensCount = 0;
        this.numFreePremiumMovies = 0;
        purchasedMovies = new ArrayList<Movie>();
        watchedMovies = new ArrayList<Movie>();
        likedMovies = new ArrayList<Movie>();
        ratedMovies = new ArrayList<Movie>();
        notifications = new ArrayList<Notification>();
        subscribedGenres = new ArrayList<String>();
    }


    /**
     * Getter for the name of the user.
     * @return the name of the user
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for the password of the user.
     * @return the password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the account type of the user.
     * @return the account type of the user
     */
    @Override
    public String getAccountType() {
        return accountType;
    }

    /**
     * Getter for the country of the user.
     * @return the country of the user
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Getter for the balance of the user.
     * @return the balance of the user
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * Getter for the tokens count of the user.
     * @return the tokens count of the user
     */
    @Override
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * Getter for the number of free premium movies of the user.
     * @return the number of free premium movies of the user
     */
    @Override
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * Getter for the purchased movies of the user.
     * @return the purchased movies of the user
     */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Setter for the password of the user.
     * @param password the password of the user
     */
    @Override
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Setter for the account type of the user.
     * @param accountType the account type of the user
     */
    @Override
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * Setter for the country of the user.
     * @param country the country of the user
     */
    @Override
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * Setter for the balance of the user.
     * @param balance the balance of the user
     */
    @Override
    public void setBalance(final int balance) {
        this.balance = balance;
    }

    /**
     * Setter for the tokens count of the user.
     * @param tokensCount the tokens count of the user
     */
    @Override
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * Setter for the number of free premium movies of the user.
     * @param numFreePremiumMovies the number of free premium movies of the user
     */
    @Override
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * Comparator for hashed passwords.
     * @param hashedPass the hashed password
     */
    @Override
    public boolean comparePassHash(final String hashedPass) {
        return hashedPass.equals(password);
    }

    /**
     * Method that adds a movie to the purchased movies of the user.
     * @param movieName the movie to be added
     */
    public void addPurchasedMovie(final Movie movieName) {
        purchasedMovies.add(movieName);
    }

    /**
     * Method that adds a movie to the watched movies of the user.
     * @param movieName the movie to be added
     */
    public void addWatchedMovie(final Movie movieName) {
        watchedMovies.add(movieName);
    }

    /**
     * Method that adds a movie to the liked movies of the user.
     * @param movieName the movie to be added
     */
    public void addLikedMovie(final Movie movieName) {
        likedMovies.add(movieName);
    }

    /**
     * Method that adds a movie to the rated movies of the user.
     * @param movieName the movie to be added
     */
    public void addRatedMovie(final Movie movieName) {
        ratedMovies.add(movieName);
    }

    /**
     * Method that adds a notification to the notifications of the user.
     * @param notification
     */
    public void addNotification(final Notification notification) {
        notifications.add(notification);
    }

    /**
     * Method that adds a genre to the subscribed genres of the user.
     * @param genre the genre to be added
     */
    public void addSubscribedGenre(final String genre) {
        subscribedGenres.add(genre);
    }

    /**
     * Method that returns the purchased movies of the user.
     * @return the purchased movies
     */
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * Method that returns the watched movies of the user.
     * @return the watched movies
     */
    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * Method that returns the liked movies of the user.
     * @return the liked movies
     */
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    /**
     * Method that returns the rated movies of the user.
     * @return the rated movies
     */
    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * Method that returns the notifications of the user.
     * @return the notifications
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Method that returns the subscribed genres of the user.
     * @return the subscribed genres
     */
    public ArrayList<String> getSubscribedGenres() {
        return subscribedGenres;
    }


    /**
     * Method that returns the purchased movies of the user as a JSON array.
     * @return the purchased movies as a JSON array
     */
    public ArrayNode getPurchasedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : purchasedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    /**
     * Method that returns the watched movies of the user as a JSON array.
     * @return the watched movies as a JSON array
     */
    public ArrayNode getWatchedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : watchedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    /**
     * Method that returns the liked movies of the user as a JSON array.
     * @return the liked movies as a JSON array
     */
    public ArrayNode getLikedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : likedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    /**
     * Method that returns the rated movies of the user as a JSON array.
     * @return the rated movies as a JSON array
     */
    public ArrayNode getRatedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : ratedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    /**
     * Converts the notification array to a json object
     * @return the json object
     */
    public ArrayNode getNotificationsJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Notification notification : notifications) {
            arrayNode.add(notification.getJson());
        }
        return arrayNode;
    }

    /**
     * Method that returns the user as a JSON object.
     * @return the user as a JSON object
     */
    public ObjectNode getJson() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();

        ObjectNode credentials = mapper.createObjectNode();
        credentials.put("name", this.getName());
        credentials.put("password", this.getPassword());
        credentials.put("accountType", this.getAccountType());
        credentials.put("country", this.getCountry());
        credentials.put("balance", String.valueOf(this.getBalance()));
        output.put("credentials", credentials);
        output.put("tokensCount", this.getTokensCount());
        output.put("numFreePremiumMovies", this.getNumFreePremiumMovies());
        output.put("purchasedMovies", this.getPurchasedMoviesJson());
        output.put("watchedMovies", this.getWatchedMoviesJson());
        output.put("likedMovies", this.getLikedMoviesJson());
        output.put("ratedMovies", this.getRatedMoviesJson());
        output.put("notifications", this.getNotificationsJson());


        return output;
    }

    /**
     * Method that returns the user as a string.
     * @return the user as a string
     */
    @Override
    public String toString() {
        return "Name: " + name
                + " accountType: " + accountType
                + " Country: " + country
                + " Balance: " + balance
                + " Tokens: " + tokensCount
                + " accountType Movies: " + numFreePremiumMovies;
    }
}
