package pages;

import input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;

/**
 * Class Upgrades implements the upgrades page
 * it implements the PageInterface
 * built with the Singleton design pattern
 */
public final class Upgrades implements PageInterface {

    private static Upgrades instance;
    private String name;

    /**
     * Constructor
     *
     * @param name page name
     */
    private Upgrades(final String name) {
        this.name = name;
    }

    /**
     * Singleton instance getter
     *
     * @return instance
     */
    public static Upgrades getInstance() {
        if (instance == null) {
            instance = new Upgrades("upgrades");
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
     * Method implements the page's functionality (upgrades)
     *
     * @param actions  input actions
     * @param dataBase database
     * @return the next page
     */
    public ObjectNode action(final ActionsInput actions, final DataBase dataBase) {
        ObjectMapper mapper = new ObjectMapper();

        if (actions.getFeature().equals("buy tokens")) {
            if (dataBase.getCurrentUser().getBalance() >= Integer.parseInt(actions.getCount())) {
                dataBase.getCurrentUser().
                        setTokensCount(dataBase.getCurrentUser().getTokensCount()
                                + Integer.parseInt(actions.getCount()));
                dataBase.getCurrentUser().
                        setBalance(dataBase.getCurrentUser().getBalance()
                                - Integer.parseInt(actions.getCount()));
            }
            return mapper.createObjectNode();
        }
        if (actions.getFeature().equals("buy premium account")) {
            if (dataBase.getCurrentUser().getBalance() >= 10
                    && dataBase.getCurrentUser().getAccountType().equals("standard")) {
                dataBase.getCurrentUser().setAccountType("premium");
                dataBase.getCurrentUser().
                        setTokensCount(dataBase.getCurrentUser().getTokensCount() - 10);
            }
        }

        return mapper.createObjectNode();
    }
}
