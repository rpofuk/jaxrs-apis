package com.github.api.request;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    String value;

    private HttpMethod(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
