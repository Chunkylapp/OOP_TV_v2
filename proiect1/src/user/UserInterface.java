package user;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import movie.Movie;

import java.util.ArrayList;

public interface UserInterface {
    public String getName();

    public String getPassword();
    public String getAccountType();

    public String getCountry();

    public int getBalance();

    public int getTokensCount();

    public int getNumFreePremiumMovies();

    public void setName(String name);

    public void setPassword(String password);

    public void setAccountType(String accountType);

    public void setCountry(String country);

    public void setBalance(int balance);

    public void setTokensCount(int tokensCount);

    public void setNumFreePremiumMovies(int numFreePremiumMovies);

    public boolean comparePassHash(String hashedPass);

    public ArrayList<Movie> getPurchasedMovies();

    public ArrayList<Movie> getWatchedMovies();

    public ArrayList<Movie> getLikedMovies();

    public ArrayList<Movie> getRatedMovies();

    public ArrayNode getPurchasedMoviesJson();

    public ArrayNode getWatchedMoviesJson();

    public ArrayNode getLikedMoviesJson();

    public ArrayNode getRatedMoviesJson();

    public ObjectNode getJson();

}
