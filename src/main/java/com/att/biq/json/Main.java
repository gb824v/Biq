/*
package com.att.biq.json;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import pukteam.poc.gson.model.Data;
import pukteam.poc.gson.model.Gender;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(4, 2.1, "test", Stream.of("a","b","c").collect(Collectors.toList()), Gender.MALE);

        Gson gson = new Gson();
        String jsonString = gson.toJson(data);
        System.out.println("Object -> String: " + jsonString);

        Data fromJson = gson.fromJson(jsonString, Data.class);

        System.out.println("String -> Object: " + fromJson.toString());
        System.out.println("Original object to string: " + data.toString());
        Type t = new TypeToken<List<Integer>>(){}.getLastName();
        JsonElement jsonElement = gson.toJsonTree(data);
        System.out.println(jsonElement.toString());
    }

}
*/
