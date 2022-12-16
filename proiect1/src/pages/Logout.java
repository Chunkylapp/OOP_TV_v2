package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public class Logout implements PageInterface {

    private static Logout instance;
    private String name;

    private Logout(String name) {
        this.name = name;
    }

    public static Logout getInstance() {
        if (instance == null) {
            instance = new Logout("logout");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public ObjectNode action(ActionsInput actions, DataBase dataBase) {

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
        return out;
    }
}
