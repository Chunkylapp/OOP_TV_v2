package pages;

import Input.ActionsInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;

import java.util.ArrayList;

public interface PageInterface {

    public String getName();

    public ObjectNode action(ActionsInput actions, DataBase dataBase) throws JsonProcessingException;
}
