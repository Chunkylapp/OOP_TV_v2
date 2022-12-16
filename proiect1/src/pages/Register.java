package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;
import user.StandardUser;
import user.UserFactory;
import user.UserInterface;

import java.util.ArrayList;

public class Register implements PageInterface {

    private static Register instance;
    private String name;

    private Register(String name) {
        this.name = name;
    }

    public static PageInterface getInstance() {
        if (instance == null) {
            instance = new Register("register");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public ObjectNode action(ActionsInput actions, DataBase dataBase) {

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
