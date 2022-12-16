package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;
import user.UserFactory;
import user.UserInterface;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Login implements PageInterface {

    private static Login instance;
    private String name;

    private Login(String name) {
        this.name = name;
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login("login");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public ObjectNode action(ActionsInput actions, DataBase dataBase) throws JsonProcessingException {
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

        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
        dataBase.setCurrentUser(dataBase.getUser(actions.getCredentials().getName()));

        out.put("error", (String) null);
        out.put("currentMoviesList", mapper.createArrayNode());
        out.put("currentUser", dataBase.getCurrentUser().getJson());
        return out;
    }
}
