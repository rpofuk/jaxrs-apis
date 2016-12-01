package com.github.api.request;

import java.util.ArrayList;
import java.util.List;

public class RestRequest {

	private String baseUrl;

	private List<String> paths = new ArrayList<>();

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

}
