package ucu.edu.ua.task3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class BrandFetchReader {

    public static final String BRAND_FETCH_URL = "https://api.brandfetch.io/v2/brands/";
    private static final String API_KEY = "YeJC5nIWV+oKLSs4WpsSzLvyMlhX5c43yfzXsIGGYpE=";

    @SneakyThrows
    public Company fetch(String companyName){
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
        .GET()
        .uri(new URI(BRAND_FETCH_URL + companyName))
        .header("Authorization", "Bearer" + API_KEY)
        .build();

        HttpResponse<String> response
            = httpClient.send(httpRequest, BodyHandlers.ofString());

        System.out.println(response.body());
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), Company.class);
    }
}

