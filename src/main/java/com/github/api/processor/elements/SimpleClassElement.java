package com.github.api.processor.elements;

import java.util.Arrays;

import com.github.api.processor.ClassAnnotationProcessor;
import com.github.api.request.RestRequest;

public class SimpleClassElement {

	private RestRequest request;

	public SimpleClassElement(RestRequest request) {
		super();
		this.request = request;
	}

	public void handle(Class<?> clazz) {
		Arrays.asList(clazz.getAnnotations()).stream().forEach(p -> new ClassAnnotationProcessor(request).process(p));
	}

}
