package org.example.config;

import com.google.gson.*;
import org.example.model.Location;
import org.example.model.LocationRecord;

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
                .uri(URI.create("https://rickandmortyapi.com/api/location/?name="+name.replace(" ", "+"))).build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("results");
            JsonObject location = null;
            for (int i = 0; i < jsonArray.size(); i++) {
                location = jsonArray.get(i).getAsJsonObject();
                System.out.println(location);
            }

            return new Gson().fromJson(location, LocationRecord.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/location/?name=")).build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
