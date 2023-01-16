package input;

import java.util.ArrayList;

/**
 * Class InputParser implements a parser for the input
 * of users and movies, used to initialize the database
 */
public class InputParser {

    private ArrayList<UserInput> users;
    private ArrayList<MovieInput> movies;

    private ArrayList<ActionsInput> actions;

    /**
     * Implicit constructor
     */
    public InputParser() {
        users = new ArrayList<UserInput>();
        movies = new ArrayList<MovieInput>();
    }

    /**
     * User ArrayList getter
     *
     * @return users
     */
    public ArrayList<UserInput> getUsers() {
        return users;
    }

    /**
     * movies ArrayList getter
     *
     * @return movies
     */
    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    /**
     * users ArrayList setter
     *
     * @param users
     */
    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    /**
     * movies ArrayList setter
     *
     * @param movies
     */
    public void setMovies(final ArrayList<MovieInput> movies) {
        this.movies = movies;
    }

    /**
     * actions ArrayList getter
     *
     * @return actions
     */
    public ArrayList<ActionsInput> getActions() {
        return actions;
    }

    /**
     * Method to add movie to movies ArrayList
     *
     * @param movie movie to be added
     */
    public void addMovie(final MovieInput movie) {
        movies.add(movie);
    }

    /**
     * Method to add user to users ArrayList
     *
     * @param user user to be added
     */
    public void addUser(final UserInput user) {
        users.add(user);
    }

    /**
     * Method to add action to actions ArrayList
     *
     * @param action action to be added
     */
    public void addAction(final ActionsInput action) {
        actions.add(action);
    }

    /**
     * Method to add a list of users to users ArrayList
     *
     * @param users users to be added
     */
    public void addUsers(final ArrayList<UserInput> users) {
        this.users.addAll(users);
    }

    /**
     * Setter for actions ArrayList
     *
     * @param actions actions to be added
     */
    public void setActions(final ArrayList<ActionsInput> actions) {
        this.actions = actions;
    }
}
