package ucu.edu.ua.task3;

import org.json.JSONObject;

import lombok.SneakyThrows;

// import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.net.URLEncoder;
// import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {
    @SneakyThrows
    public Company fetch (String companyName) {
        String API_KEY = "";
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=ucu.edu.ua");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text;
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            text = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
        }
        JSONObject jsonObject = new JSONObject(text);
        System.out.println(jsonObject);
        return new Company();
    }
}
