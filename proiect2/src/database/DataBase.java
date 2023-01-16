package database;

import movie.Movie;
import pages.PageInterface;
import user.UserInterface;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Class DataBase implements a database for the website
 * it holds all registered users, all movies, and it also holds
 * data important for the current logged-in user like the current page
 * the current user and the current movie
 */
public class DataBase {

    private ArrayList<UserInterface> users;
    private ArrayList<Movie> movies;
    private ArrayList<Movie> currentMovies;
    private PageInterface currentPage;

    private Stack<PageInterface> history = new Stack<>();
    private UserInterface currentUser;
    private String currentMovie;


    /**
     * Implicit constructor
     */
    public DataBase() {
        users = new ArrayList<UserInterface>();
        movies = new ArrayList<Movie>();
        currentMovies = null;
        currentPage = null;
        currentUser = null;
        currentMovie = null;

    }

    /**
     * User ArrayList getter
     * @return users
     */
    public ArrayList<UserInterface> getUsers() {
        if (this.users == null) {
            users = new ArrayList<UserInterface>();
        }
        return users;
    }

    /**
     * movies ArrayList getter
     * @return movies
     */
    public ArrayList<Movie> getMovies() {
        if (movies == null) {
            movies = new ArrayList<Movie>();
        }
        return movies;
    }

    /**
     * Finds and returns a user by username
     * @param user's username
     * @return the user or null
     */
    public UserInterface getUser(final String name) {
        for (UserInterface user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Setter for the movies array used to update it
     * @param movies and ArrayList<Movie> object
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Setter for the users array used to update it
     * @param users and ArrayList<UserInterface> object
     */
    public void setUsers(final ArrayList<UserInterface> users) {
        this.users = users;
    }

    /**
     * Setter for the current movie
     * @param currentMovie name of the movie
     */
    public void setCurrentMovie(final String currentMovie) {
        this.currentMovie = currentMovie;
    }

    /**
     * Getter for the current movie
     * @return returns the movie's name
     */
    public String getCurrentMovie() {
        return currentMovie;
    }

    /**
     * Setter for the current user
     * @param user a UserInterface object
     */
    public void setCurrentUser(final UserInterface user) {
        currentUser = user;
    }

    /**
     * Getter for the current user
     * @return the current user
     */
    public UserInterface getCurrentUser() {
        return currentUser;
    }

    /**
     * Setter for the current page
     * @param page the current page
     */
    public void setCurrentPage(final PageInterface page) {
        if (currentPage != null) {
            history.push(currentPage);
        }
        currentPage = page;
    }

    /**
     * Getter for the current page
     * @return the current page
     */
    public PageInterface getCurrentPage() {
        return currentPage;
    }

    /**
     * Getter for the history stack
     * @return the history stack
     */
    public PageInterface getPreviousPage() {
        if (history.size() > 0) {
            return history.pop();
        }
        return null;
    }

    /**
     * Checker for the stack
     * @return weather or not the stack is null
     */
    public boolean stackNull() {
        if (history == null || history.size() < 1) {
            return true;
        }
        return false;
    }

    /**
     * Clears the stack
     */
    public void clearStack() {
        history = null;
    }

    /**
     * Setter for the current movies array
     * @param movies an ArrayList<Movie> object
     */
    public void setCurrentMovies(final ArrayList<Movie> movies) {
        currentMovies = movies;
    }

    /**
     * Getter for the current movies array
     * @return current movies array
     */
    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    /**
     * Method to add a movie to the database
     * @return the history stack
     */
    public void addMovie(final Movie movie) {
        movies.add(movie);
        // implement the notification system
    }

}
