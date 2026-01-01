package designPatterns.creational.builder.bad;

import java.util.Map;

public class HttpRequest {
    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private int timeout;

    public HttpRequest(String url) {
        this(url, "GET");
    }

    public HttpRequest(String url,
                       String method) {
        this(url, method, null);
    }

    public HttpRequest(String url,
                       String method,
                       Map<String, String> headers) {
        this(url, method, headers, null);
    }

    public HttpRequest(String url,
                       String method,
                       Map<String, String> headers,
                       Map<String, String> queryParams
    ) {
        this(url, method, headers, queryParams, null);
    }

    public HttpRequest(String url,
                       String method,
                       Map<String, String> headers,
                       Map<String, String> queryParams,
                       String body) {
        this(url, method, headers, queryParams, body, 5000);
    }

    public HttpRequest(String url,
                       String method,
                       Map<String, String> headers,
                       Map<String, String> queryParams,
                       String body,
                       int timeout) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.queryParams = queryParams;
        this.body = body;
        this.timeout = timeout;

        System.out.println("HttpRequest created with URL: " + url + ", Method: " + method + ", Headers: " + headers +
                ", QueryParams: " + queryParams + ", Body: " + body + ", Timeout: " + timeout);
    }


}
