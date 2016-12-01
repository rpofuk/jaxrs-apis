package com.github.api.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestRequest {

	private String baseUrl;

	private List<String> paths = new ArrayList<>();
 
	private Map<String, List<String>> headers = new HashMap<>();
	
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
	
	public void addHeder(String name, String value) {
		if (!headers.containsKey(name)) {
			headers.put(name, new ArrayList<>(1));			
		}
		headers.get(name).add(value);
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}
}
