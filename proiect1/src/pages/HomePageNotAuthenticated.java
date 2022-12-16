package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public class HomePageNotAuthenticated implements PageInterface {

    private String name;
    private static HomePageNotAuthenticated instance;

    private HomePageNotAuthenticated(String name) {
        this.name = name;
    }

    public static HomePageNotAuthenticated getInstance() {
        if (instance == null) {
            instance = new HomePageNotAuthenticated("Homepage neautentificat");
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ObjectNode action(ActionsInput actions, DataBase dataBase) {
        // home page not authenticated does not have any features
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }
}
