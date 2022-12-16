package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import movie.Movie;

import java.util.ArrayList;

public class PremiumUser implements UserInterface {
    private String name;
    private String password; //xxhash mfs
    private String accountType;
    private String country;
    private int balance;
    private int tokensCount;
    private int numFreePremiumMovies;
    // new array list of strings for accountType movies
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;

    public PremiumUser(String name, String password, String accountType, String country, int balance) {
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
    }

    public PremiumUser() {
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
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getTokensCount() {
        return tokensCount;
    }

    @Override
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void setTokensCount(int tokensCount) {
        this.tokensCount = tokensCount;
    }

    @Override
    public void setNumFreePremiumMovies(int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    @Override
    public boolean comparePassHash(String hashedPass) {
        return hashedPass.equals(password);
    }

    public void addPurchasedMovie(Movie movieName) {
        purchasedMovies.add(movieName);
    }

    public void addWatchedMovie(Movie movieName) {
        watchedMovies.add(movieName);
    }

    public void addLikedMovie(Movie movieName) {
        likedMovies.add(movieName);
    }

    public void addRatedMovie(Movie movieName) {
        ratedMovies.add(movieName);
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public ArrayNode getPurchasedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : purchasedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    public ArrayNode getWatchedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : watchedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    public ArrayNode getLikedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : likedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

    public ArrayNode getRatedMoviesJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Movie movie : ratedMovies) {
            arrayNode.add(movie.getJson());
        }
        return arrayNode;
    }

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


        return output;
    }

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
