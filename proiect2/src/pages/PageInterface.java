package pages;

import input.ActionsInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;

/**
 * Interface for all pages
 */
public interface PageInterface {

    /**
     * Method for getting page name
     * @return page name
     */
    String getName();

    /**
     * Method for the page's action
     * @param actions input actions
     * @param dataBase database
     * @return a json object with the output
     * @throws JsonProcessingException
     */
    ObjectNode action(ActionsInput actions,
                             DataBase dataBase) throws JsonProcessingException;

}
