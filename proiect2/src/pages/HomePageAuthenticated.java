package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;

/**
 * Class HomePageAuthenticated implements the home page for an authenticated user
 * it implements the PageInterface
 * built using the Singleton design pattern
 */
public final class HomePageAuthenticated implements PageInterface {

    private static HomePageAuthenticated instance;
    private String name;

    /**
     * Constructor
     * @param name the page's name
     */
    private HomePageAuthenticated(final String name) {
        this.name = name;
    }

    /**
     * Getter for the instance
     * @return the instance
     */
    public static HomePageAuthenticated getInstance() {
        if (instance == null) {
            instance = new HomePageAuthenticated("Homepage autentificat");
        }
        return instance;
    }

    /**
     * Getter for the page's name
     * @return the page's name
     */
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
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }
}
