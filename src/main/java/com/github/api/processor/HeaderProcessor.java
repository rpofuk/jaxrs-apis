package com.github.api.processor;

import java.util.Map;

import com.github.api.request.RestRequest;

public class HeaderProcessor {

	public void process(Map<String, String> headers, RestRequest request) {
		headers.entrySet().stream().forEach(p -> request.addHeder(p.getKey(), p.getValue()));
	}

}
