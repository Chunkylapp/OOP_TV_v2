package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;

/**
 * Class Logout implements the logout page
 * implements the PageInterface
 * built using the Singleton design pattern
 */
public final class Logout implements PageInterface {

    private static Logout instance;
    private String name;

    /**
     * Constructor
     *
     * @param name the page's name
     */
    private Logout(final String name) {
        this.name = name;
    }

    /**
     * Getter for the instance
     *
     * @return the instance
     */
    public static Logout getInstance() {
        if (instance == null) {
            instance = new Logout("logout");
        }
        return instance;
    }

    /**
     * Getter for the page's name
     *
     * @return the page's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method implements the page's functionality
     *
     * @param actions  the input actions
     * @param dataBase the database
     * @return a JSON object
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode out = mapper.createObjectNode();

        if (dataBase.getCurrentUser() == null) {
            out.put("error", "Error");
            out.put("currentMoviesList", mapper.createArrayNode());
            out.put("currentUser", (String) null);
            return out;
        }

        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
        dataBase.setCurrentUser(null);
        dataBase.clearStack();
        return out;
    }
}
