package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public class Movies implements PageInterface {

    private static Movies instance;
    private String name;

    private Movies(String name) {
        this.name = name;
    }

    public static Movies getInstance() {
        if (instance == null) {
            instance = new Movies("movies");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public ObjectNode action(ActionsInput actions, DataBase dataBase) {
        switch (actions.getFeature()) {
            case "search":
                return dataBase.getCurrentUser().getJson();
            case "filter":
                return dataBase.getCurrentUser().getJson();
        }
        return null;
    }
}
