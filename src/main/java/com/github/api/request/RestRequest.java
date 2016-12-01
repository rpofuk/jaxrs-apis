package com.github.api.request;

import java.util.ArrayList;
import java.util.List;

public class RestRequest {

	private String baseUrl;

	private List<String> paths = new ArrayList<>();

	HttpMethod httpMethod;

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void addPath(String path) {
		paths.add(path);
	}

	public List<String> getPaths() {
		return paths;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

}
