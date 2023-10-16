package org.example.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

    public static void generateTxt(Location location) {
        try {
            FileWriter fileWriter = new FileWriter(location.getName()+".json");
            fileWriter.write(location.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
