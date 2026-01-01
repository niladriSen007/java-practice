package designPatterns.creational.builder.bad;

import java.util.Map;

public class HttpClient {
    static void main() {
        HttpRequest request = new HttpRequest("http://example.com");
        HttpRequest request2 = new HttpRequest("http://example.com", "POST");
        HttpRequest request3 = new HttpRequest("http://example.com", "POST",
                Map.of("Content-Type", "application/json"));
        HttpRequest request4 = new HttpRequest("http://example.com", "POST",
                Map.of("Content-Type", "application/json"),
                Map.of("q", "builder pattern"));
        HttpRequest request5 = new HttpRequest("http://example.com", "POST",
                Map.of("Content-Type", "application/json"),
                Map.of("q", "builder pattern"),
                "{\"data\":\"value\"}");
        HttpRequest request6 = new HttpRequest("http://example.com", "POST",
                Map.of("Content-Type", "application/json"),
                Map.of("q", "builder pattern"),
                "{\"data\":\"value\"}", 10000);

        System.out.println("Requests created");

    }
}
