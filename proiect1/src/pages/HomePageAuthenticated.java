package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public class HomePageAuthenticated implements PageInterface {

    private static HomePageAuthenticated instance;
    private String name;

    private HomePageAuthenticated(String name) {
        this.name = name;
    }

    public static HomePageAuthenticated getInstance() {
        if (instance == null) {
            instance = new HomePageAuthenticated("Homepage autentificat");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    @Override
    public ObjectNode action(ActionsInput actions, DataBase dataBase) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }
}
