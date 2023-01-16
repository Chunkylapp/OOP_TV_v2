package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;
import user.UserFactory;
import user.UserInterface;

/**
 * Class Register implements the register page
 * it has a method that creates a new user
 * and adds it to the database
 * built using the Singleton design pattern
 */
public final class Register implements PageInterface {

    private static Register instance;
    private String name;

    /**
     * Constructor
     * @param name page name
     */
    private Register(final String name) {
        this.name = name;
    }

    /**
     * Singleton instance getter
     * @return instance
     */
    public static PageInterface getInstance() {
        if (instance == null) {
            instance = new Register("register");
        }
        return instance;
    }

    /**
     * Getter for page name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that creates a new user
     * and adds it to the database
     * @param actions here we get the user's input
     * @param dataBase here we add the new user
     * @return a json with the result of the operation
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode out = mapper.createObjectNode();

        if (dataBase.getUser(actions.getCredentials().getName()) != null) {
            dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
            out.put("error", "Error");
            out.put("currentMoviesList", mapper.createArrayNode());
            out.put("currentUser", (String) null);
            return out;
        }

        UserInterface user = UserFactory.getUser(actions.getCredentials().getName(),
                actions.getCredentials().getPassword(), actions.getCredentials().getAccountType(),
                actions.getCredentials().getCountry(), actions.getCredentials().getBalance());

        dataBase.getUsers().add(user);
        dataBase.setCurrentPage(HomePageAuthenticated.getInstance());
        dataBase.setCurrentUser(user);

        out.put("error", (String) null);
        out.put("currentMoviesList", mapper.createArrayNode());
        out.put("currentUser", user.getJson());
        return out;
    }
}
