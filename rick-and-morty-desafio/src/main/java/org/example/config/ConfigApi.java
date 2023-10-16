package org.example.config;

import com.google.gson.*;

import org.example.model.Location;
import org.example.model.LocationRecord;
import org.example.utils.PilhaObj;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConfigApi {

    public LocationRecord searchName(String name) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/location/?name=" + name.replace(" ", "+"))).build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JsonObject location = treatmentJson(response);

            return new Gson().fromJson(location, LocationRecord.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public PilhaObj<Location> getAll() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/location")).build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return treatmentAllJson(response);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject treatmentJson(HttpResponse<String> response) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");
        JsonObject locationJson = null;
        for (int i = 0; i < jsonArray.size(); i++) {
            locationJson = jsonArray.get(i).getAsJsonObject();
        }

        return locationJson;
    }

    public PilhaObj<Location> treatmentAllJson(HttpResponse<String> response) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");
        JsonObject locationJson = null;
        PilhaObj<Location> pilhaObj = new PilhaObj<>(20);

        for (int i = 0; i < jsonArray.size(); i++) {
            locationJson = jsonArray.get(i).getAsJsonObject();
            LocationRecord locationRecord = gson.fromJson(locationJson, LocationRecord.class);
            Location location = new Location(locationRecord);
            pilhaObj.push(location);
        }

        return pilhaObj;
    }


}
