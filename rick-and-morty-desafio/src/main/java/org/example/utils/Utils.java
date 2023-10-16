package org.example.utils;

import org.example.model.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

    public static void generateTxt(Location location) {
        try {
            FileWriter fileWriter = new FileWriter(location.getName()+".txt");
            fileWriter.write(location.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void generateTxt(PilhaObj<Location> pilhaObj) {
        try {
            FileWriter fileWriter = new FileWriter("locations.txt");

            List<Location> locationList = pilhaObj.displays();

            for (int i = 0; i < locationList.size(); i++) {
                fileWriter.write(locationList.get(i).toString()+"\n");
            }

            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
