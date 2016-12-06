package com.github.api.request;

import java.util.ArrayList;
import java.util.List;

import com.github.api.processor.elements.Header;

public class RestRequest {

	private String baseUrl;

	private Object body;

	private String dateFormat;

	private List<String> paths = new ArrayList<>();

	private List<Header> headers = new ArrayList<>();

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
		headers.add(new Header(name, value));
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
}
