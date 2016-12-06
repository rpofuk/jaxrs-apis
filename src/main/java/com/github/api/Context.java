package com.github.api;

import java.util.Map;

public interface Context {

	String getBaseUrl();
	
	Map<String, String> getHeaders();
	
	String getDateFormat();
}
