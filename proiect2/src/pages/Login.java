package pages;

import input.ActionsInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;
import user.UserInterface;

/**
 * Class Login implements the login page
 * it implements the PageInterface
 * built with the Singleton design pattern
 */
public final class Login implements PageInterface {

    private static Login instance;
    private String name;

    /**
     * Constructor
     *
     * @param name page name
     */
    private Login(final String name) {
        this.name = name;
    }

    /**
     * Singleton instance getter
     *
     * @return instance
     */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login("login");
        }
        return instance;
    }

    /**
     * Page name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method implements the page's functionality (login)
     *
     * @param actions  input actions
     * @param dataBase database
     * @return the next page
     * @throws JsonProcessingException
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase)
            throws JsonProcessingException {
        UserInterface user = dataBase.getUser(actions.getCredentials().getName());

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode out = mapper.createObjectNode();

        if (user == null) {
            dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
            out.put("error", "Error");
            out.put("currentMoviesList", mapper.createArrayNode());
            out.put("currentUser", (String) null);
            return out;
        }

        if (!(user.getPassword().equals(actions.getCredentials().getPassword()))) {
            dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
            out.put("error", "Error");
            out.put("currentMoviesList", mapper.createArrayNode());
            out.put("currentUser", (String) null);
            return out;
        }

        dataBase.setCurrentPage(HomePageAuthenticated.getInstance());
        dataBase.setCurrentUser(dataBase.getUser(actions.getCredentials().getName()));

        out.put("error", (String) null);
        out.put("currentMoviesList", mapper.createArrayNode());
        out.put("currentUser", dataBase.getCurrentUser().getJson());
        return out;
    }
}
