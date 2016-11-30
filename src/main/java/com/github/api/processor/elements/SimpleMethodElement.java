package com.github.api.processor.elements;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.github.api.processor.ClassAnnotationProcessor;
import com.github.api.processor.MethodAnotationProcessor;
import com.github.api.request.RestRequest;

public class SimpleMethodElement {

	private RestRequest request;

	public SimpleMethodElement(RestRequest request) {
		this.request = request;
	}

	public void handle(Method method) {
		Arrays.asList(method.getAnnotations()).stream().forEach(p -> new MethodAnotationProcessor(request).process(p));
	}

}
