package com.testingexcellence.tutorials;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Crunchify.com
 * Program: 4 Best ways to convert Java Map to JSONObject.
 * Version: 1.0.0
 *
 */

public class CrunchifyMapToJsonObject {
    public static void main(String a[]) {

        Map<String, String> crunchifyMap = new HashMap<String, String>();
        crunchifyMap.put("Google", "San Jose");
        crunchifyMap.put("Facebook", "Mountain View");
        crunchifyMap.put("Crunchify", "NYC");
        crunchifyMap.put("Twitter", "SFO");
        crunchifyMap.put("Microsoft", "Seattle");

        log("Raw Map ===> " + crunchifyMap);


        Map<String, String> crunchifyMap2 = new HashMap<String, String>();
        crunchifyMap2.put("Google", "San Jose2");
        crunchifyMap2.put("Facebook", "Mountain View2");
        crunchifyMap2.put("Crunchify", "NYC2");
        crunchifyMap2.put("Twitter", "SFO2");
        crunchifyMap2.put("Microsoft", "Seattle2");

        log("Raw Map ===> " + crunchifyMap2);


        Map<String, Map> crunchifyMap3 = new HashMap<String, Map>();

        crunchifyMap3.put("1",crunchifyMap);
        crunchifyMap3.put("2",crunchifyMap2);

        List<Map> myList = new ArrayList<>();
        myList.add(crunchifyMap);
        myList.add(crunchifyMap2);

        Gson prettyGson2 = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonLsit = prettyGson2.toJson(myList);

        log("\nPretty JSONObject -- LIST ==> " + prettyJsonLsit);



        // Use this builder to construct a Gson instance when you need to set configuration options other than the default.
        GsonBuilder gsonMapBuilder = new GsonBuilder();

        Gson gsonObject = gsonMapBuilder.create();

        String JSONObject = gsonObject.toJson(crunchifyMap3);
        log("\nMethod-1: Using Google GSON ==> " + JSONObject);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = prettyGson.toJson(crunchifyMap3);

        log("\nPretty JSONObject ==> " + prettyJson);

        // Construct a JSONObject from a Map.
        JSONObject crunchifyObject = new JSONObject(crunchifyMap3);
        log("\nMethod-2: Using new JSONObject() ==> " + crunchifyObject);

        try {
            // Default constructor, which will construct the default JsonFactory as necessary, use SerializerProvider as its
            // SerializerProvider, and BeanSerializerFactory as its SerializerFactory.
            String objectMapper = new ObjectMapper().writeValueAsString(crunchifyMap3);
            log("\nMethod-3: Using ObjectMapper().writeValueAsString() ==> " + objectMapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Convert an object to JSON text. If this object is a Map or a List, and it's also a JSONAware, JSONAware will be considered firstly.
        String jsonValue = JSONValue.toJSONString(crunchifyMap3);
        log("\nMethod-4: Using JSONValue.toJSONString() ==> " + jsonValue);

    }

    private static void log(Object print) {
        System.out.println(print);

    }
}