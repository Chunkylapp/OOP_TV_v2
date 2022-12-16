package dataBase;

import movie.Movie;
import pages.PageInterface;
import user.UserInterface;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DataBase {

    private ArrayList<UserInterface> users = null;
    private ArrayList<Movie> movies = null;
    private PageInterface currentPage = null;
    private UserInterface currentUser = null;

    // to implement for movies

    public DataBase() {
        users = new ArrayList<UserInterface>();
        // add all pages to pages array list
        movies = new ArrayList<Movie>();
    }

    public ArrayList<UserInterface> getUsers() {
        if (this.users == null) {
            users = new ArrayList<UserInterface>();
        }
        return users;
    }

    public ArrayList<Movie> getMovies() {
        if (movies == null) {
            movies = new ArrayList<Movie>();
        }
        return movies;
    }

    public UserInterface getUser(String name) {
        for (UserInterface user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void setCurrentUser(UserInterface user) {
        currentUser = user;
    }

    public UserInterface getCurrentUser() {
        return currentUser;
    }

    public void setCurrentPage(PageInterface page) {
        currentPage = page;
    }

    public PageInterface getCurrentPage() {
        return currentPage;
    }

}
