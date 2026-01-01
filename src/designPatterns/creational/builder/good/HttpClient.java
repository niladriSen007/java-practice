package designPatterns.creational.builder.good;

public class HttpClient {
    static void main() {
        HttpRequest httpRequest = new HttpRequest.Builder("http://example.com")
                .build();
        HttpRequest httpRequest2 = new HttpRequest.Builder("http://example.com")
                .setMethod("POST")
                .build();
        HttpRequest httpRequest3 = new HttpRequest.Builder("http://example.com")
                .setMethod("POST")
                .setHeaders("Content-Type", "application/json")
                .build();
        HttpRequest httpRequest4 = new HttpRequest.Builder("http://example.com")
                .setMethod("POST")
                .setHeaders("Content-Type", "application/json")
                .setQueryParams("q", "builder pattern")
                .build();
        HttpRequest httpRequest5 = new HttpRequest.Builder("http://example.com")
                .setMethod("POST")
                .setHeaders("Content-Type", "application/json")
                .setQueryParams("q", "builder pattern")
                .setBody("{\"data\":\"value\"}")
                .build();
        HttpRequest httpRequest6 = new HttpRequest.Builder("http://example.com")
                .setMethod("POST")
                .setHeaders("Content-Type", "application/json")
                .setQueryParams("q", "builder pattern")
                .setBody("{\"data\":\"value\"}")
                .setTimeout(10000)
                .build();

        System.out.println(httpRequest);
    }
}
