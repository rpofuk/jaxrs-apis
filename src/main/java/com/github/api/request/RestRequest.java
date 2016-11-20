package com.github.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestRequest {

	private List<String> paths = new ArrayList<>();

	public void setBaseUrl(String baseUrl) {
		paths.add(0, baseUrl);
	}

	public void setPrefixUrl(String prefixUrl) {
		paths.add(1, prefixUrl);
	}

	public void addPath(String path) {
		paths.add(path);
	}

	public String getRequestPath() {
		return paths.stream().collect(Collectors.joining("/"));
	}
}
