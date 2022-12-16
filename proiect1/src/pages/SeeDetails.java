package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public class SeeDetails implements PageInterface {

    private static SeeDetails instance;
    private String name;

    private SeeDetails(String name) {
        this.name = name;
    }

    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails("See Details");
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public ObjectNode action(ActionsInput actions, DataBase dataBase) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }
}
