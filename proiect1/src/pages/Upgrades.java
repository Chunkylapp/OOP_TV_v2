package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Upgrades implements PageInterface {

    private static Upgrades instance;
    private String name;

    private Upgrades(String name) {
        this.name = name;
    }

    public static Upgrades getInstance() {
        if (instance == null) {
            instance = new Upgrades("Upgrades");
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
