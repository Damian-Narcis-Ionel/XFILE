package com.company.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonReader {

    public static List<MyInterface> readJson(String file) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

        System.out.println("1. File's content: ");
        jsonArray.forEach(System.out::println);

        Iterator i = jsonArray.iterator();
        List<MyInterface> rules = new ArrayList<>();

        while(i.hasNext()){

            JSONObject object = (JSONObject) i.next();
            Long id = (Long) object.get("id");
            JSONObject interfaceObject = (JSONObject) object.get("interface");
            Long priority = (Long) object.get("priority");
            Boolean active = (Boolean) object.get("active");
            String from = (String) object.get("from");
            String to = (String) object.get("to");
            Long expected = (Long) object.get("expected");
            String relation = (String) object.get("relation");

            InterfaceDetails myInterface = new InterfaceDetails((String)interfaceObject.get("interfaceName"),(String) interfaceObject.get("interfaceDescription"));

            MyInterface rule = new MyInterface(id,myInterface,priority,active,from,to,expected,relation);

            rules.add(rule);
        }
        return rules;
    }

}
