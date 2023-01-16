package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;

/**
 * Class HomePageNotAuthenticated implements the home page for an authenticated user
 * it implements the PageInterface
 * built using the Singleton design pattern
 */
public final class HomePageNotAuthenticated implements PageInterface {

    private String name;
    private static HomePageNotAuthenticated instance;

    /**
     * Constructor
     * @param name the page's name
     */
    private HomePageNotAuthenticated(final String name) {
        this.name = name;
    }

    /**
     * Getter for the instance
     * @return the instance
     */
    public static HomePageNotAuthenticated getInstance() {
        if (instance == null) {
            instance = new HomePageNotAuthenticated("Homepage neautentificat");
        }
        return instance;
    }

    /**
     * Getter for the page's name
     * @return the page's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method that implements the page's functionality
     * @param actions the actions input
     * @param dataBase the database
     * @return a JSON object
     */
    @Override
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {
        // home page not authenticated does not have any features
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }
}
