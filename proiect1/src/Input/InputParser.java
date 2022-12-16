package Input;

import java.util.ArrayList;

public class InputParser {

    private ArrayList<UserInput> users;
    private ArrayList<MovieInput> movies;

    private ArrayList<ActionsInput> actions;
    public InputParser() {
        users = new ArrayList<UserInput>();
        movies = new ArrayList<MovieInput>();
    }

    public ArrayList<UserInput> getUsers() {
        return users;
    }

    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    public void setUsers(ArrayList<UserInput> users) {
        this.users = users;
    }

    public void setMovies(ArrayList<MovieInput> movies) {
        this.movies = movies;
    }

    public ArrayList<ActionsInput> getActions() {
        return actions;
    }
    public void addMovie(MovieInput movie) {
        movies.add(movie);
    }

    public void addUser(UserInput user) {
        users.add(user);
    }

    public void addAction(ActionsInput action) {
        actions.add(action);
    }

    public void addUsers(ArrayList<UserInput> users) {
        this.users.addAll(users);
    }

    public void setActions(ArrayList<ActionsInput> actions) {
        this.actions = actions;
    }
}
